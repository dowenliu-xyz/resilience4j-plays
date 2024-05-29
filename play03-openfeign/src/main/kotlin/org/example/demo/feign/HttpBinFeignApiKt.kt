package org.example.demo.feign

import com.fasterxml.jackson.databind.JsonNode
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "httpBinKt", url = "http://127.0.0.1:8011")
@CircuitBreaker(name = "httpBin", fallbackMethod = "fff")
interface HttpBinFeignApiKt {
    @GetMapping("/status/{code}")
    @CircuitBreaker(name = "httpBinStatus")
    fun status(@PathVariable code: Int): JsonNode

    @GetMapping("/get")
    fun get(): JsonNode

    @GetMapping("/delay/{seconds}")
    fun delay(@PathVariable seconds: Int): JsonNode
}
