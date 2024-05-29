package org.example.demo.service

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory

/**
 * 测试case: not bean; abstract class; annotation on class
 */
@CircuitBreaker(name = "tpKt8", fallbackMethod = "fallback")
abstract class TestParentKt8 {
    companion object {
        private val log = LoggerFactory.getLogger(TestParentKt8::class.java)
    }

    fun hello(name: String?): String {
        require(!name.isNullOrBlank()) { "name is blank" }
        return "hello, $name"
    }

    fun fallback(name: String, e: Throwable): String {
        log.debug("Throwable type: {}", e.javaClass.name)
        return "parent fallback, $name"
    }
}
