package org.example.demo.controller

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import io.github.resilience4j.retry.annotation.Retry
import org.example.demo.feign.HttpBinFeignApi
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class KtHttpBinController(
    private val httpBinFeignApi: HttpBinFeignApi,
    private val objectMapper: ObjectMapper
) {
    @GetMapping("/kt-httpbin/status/{code}")
    @Retry(name = "httpBinStatus", fallbackMethod = "fallback")
    fun status(@PathVariable code: Int): JsonNode {
        return httpBinFeignApi.status(code)
    }

    private fun fallback(@PathVariable code: Int, thr: Throwable): JsonNode {
        return objectMapper.createObjectNode().put("code", code).put("message", thr.message)
    }
}
