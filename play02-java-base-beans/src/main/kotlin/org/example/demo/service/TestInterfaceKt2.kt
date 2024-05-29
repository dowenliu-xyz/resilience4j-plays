package org.example.demo.service

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.slf4j.Logger

/**
 * 测试case: not bean; interface; annotation on interface class
 */
@CircuitBreaker(name = "tiKt2", fallbackMethod = "fallback")
interface TestInterfaceKt2 {
    fun hello(name: String): String

    fun getLogger(): Logger

    fun fallback(name: String, e: Throwable): String {
        getLogger().debug("Throwable type: {}", e.javaClass.name)
        return "itf fallback, $name"
    }
}