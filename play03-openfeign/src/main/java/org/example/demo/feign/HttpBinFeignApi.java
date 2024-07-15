package org.example.demo.feign;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public interface HttpBinFeignApi {
    @GetMapping("/status/{code}")
    JsonNode status(@PathVariable int code);

    @Component
    class HttpBinFeignApiFallbackFactory implements FallbackFactory<HttpBinFeignApi> {
        private static final Logger LOG = LoggerFactory.getLogger(HttpBinFeignApiFallbackFactory.class);

        @Resource
        private ObjectMapper mapper;

        @Override
        public HttpBinFeignApi create(Throwable cause) {
            LOG.error("fallback create()", cause);
            return code -> {
                LOG.info("fallback status:{}", code);
                return mapper.createObjectNode().put("feignFallback", "status")
                        .put("cause", cause.getMessage());
            };
        }
    }
}
