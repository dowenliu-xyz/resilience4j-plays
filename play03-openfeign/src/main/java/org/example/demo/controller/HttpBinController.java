package org.example.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.feign.HttpBinFeignApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HttpBinController {
    private final HttpBinFeignApi httpBinFeignApi;
    private final int[] a = new int[]{1, 2, 3};
    private final ObjectMapper objectMapper;

    @GetMapping("/httpbin/status/{code}")
    @Retry(name = "httpBinStatus", fallbackMethod = "fallback")
    public JsonNode status(@PathVariable int code) {
        return httpBinFeignApi.status(code);
    }

    private JsonNode fallback(@PathVariable int code, Throwable thr) {
        log.info("test: {}", this.a[0] + a.length);
        return objectMapper.createObjectNode().put("code", code).put("message", thr.getMessage());
    }
}
