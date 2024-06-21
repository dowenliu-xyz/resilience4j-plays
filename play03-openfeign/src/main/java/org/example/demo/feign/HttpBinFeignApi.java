package org.example.demo.feign;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign client, always jdk-proxied bean.
 */
@FeignClient(name = "httpBin", url = "https://httpbin.org"
        , fallbackFactory = HttpBinFeignApi.HttpBinFeignApiFallbackFactory.class
)
//@CircuitBreaker(name = "httpBin", fallbackMethod = "fallbacks")
public interface HttpBinFeignApi {
    @GetMapping("/status/{code}")
    @CircuitBreaker(name = "httpBinStatus", fallbackMethod = "aFallback")
    JsonNode status(@PathVariable int code);

    @GetMapping("/get")
    JsonNode get();

    @GetMapping("/delay/{seconds}")
    JsonNode delay(@PathVariable int seconds);

    default JsonNode fallbacks(int code, Throwable cause) {
        return new ObjectMapper().createObjectNode().put("annoFallback", "fallbacks")
                .put("code", code).put("cause", cause.getMessage());
    }

    default JsonNode aFallback(int code, Throwable cause) {
        return new ObjectMapper().createObjectNode().put("annoFallback", "aFallback")
                .put("code", code).put("cause", cause.getMessage());
    }

    JsonNode bFallback(int code, Throwable cause);

    @Component
    class HttpBinFeignApiFallbackFactory implements FallbackFactory<HttpBinFeignApi> {
        private static final Logger LOG = LoggerFactory.getLogger(HttpBinFeignApiFallbackFactory.class);

        @Resource
        private ObjectMapper mapper;

        @Override
        public HttpBinFeignApi create(Throwable cause) {
            LOG.error("fallback create()", cause);
            return new HttpBinFeignApi() {
                @Override
                public JsonNode status(int code) {
                    LOG.info("fallback status:{}", code);
                    return mapper.createObjectNode().put("feignFallback", "status")
                            .put("cause", cause.getMessage());
                }

                @Override
                public JsonNode get() {
                    LOG.info("fallback get()");
                    return mapper.createObjectNode().put("feignFallback", "get");
                }

                @Override
                public JsonNode delay(int seconds) {
                    LOG.info("fallback delay({})", seconds);
                    return mapper.createObjectNode().put("feignFallback", "delay");
                }

                @Override
                public JsonNode bFallback(int code, Throwable cause) {
                    return new ObjectMapper().createObjectNode().put("annoFallback", "bFallback")
                            .put("code", code).put("cause", cause.getMessage());
                }
            };
        }
    }
}
