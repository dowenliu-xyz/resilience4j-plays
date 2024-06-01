package org.example.demo.demos.basic

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Greeting
import org.springframework.stereotype.Component

@Suppress("unused")
// This is a Java-based container configured bean.
// If we turn this into an annotation-based container configured bean,
// kotlin's spring plugin will "open" all it's methods.
open class FinalMethodKotlinDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    // This method is not open
    fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    private fun fallback(name: String, thr: Throwable): String {
        return Greeting.doFallback(name, thr)
    }

    private fun fallback(thr: Throwable): String {
        return Greeting.doFallback(thr)
    }
}
