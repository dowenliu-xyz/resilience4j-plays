package org.example.demo.service

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.slf4j.Logger

/**
 * 测试case: bean; interface; annotation on interface method
 */
interface TestInterfaceKt1 {
    @CircuitBreaker(name = "tiKt1", fallbackMethod = "fallback")
    fun hello(name: String?): String?
    val logger: Logger
    fun fallback(name: String, throwable: Throwable): String? {
        logger.debug("Throwable type: {}", throwable.javaClass.name)
        return "itf fallback, $name"
    }
}
