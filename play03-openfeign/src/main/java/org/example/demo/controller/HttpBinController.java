package org.example.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.example.demo.feign.HttpBinFeignApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HttpBinController {
    private final HttpBinFeignApi httpBinFeignApi;

    @GetMapping("/httpbin/status/{code}")
    public JsonNode status(@PathVariable int code) {
        return httpBinFeignApi.status(code);
    }

    @GetMapping("/httpbin/get")
    public JsonNode get() {
        return httpBinFeignApi.get();
    }

    @GetMapping("/httpbin/delay/{seconds}")
    public JsonNode delay(@PathVariable int seconds) {
        return httpBinFeignApi.delay(seconds);
    }
}
