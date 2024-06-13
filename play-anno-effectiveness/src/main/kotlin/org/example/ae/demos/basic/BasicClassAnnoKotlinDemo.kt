package org.example.ae.demos.basic

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.biz.Greeting
import org.springframework.stereotype.Component

@CircuitBreaker(name = "demo", fallbackMethod = "fallback")
@Component
class BasicClassAnnoKotlinDemo {
    fun greeting(name: String): String {
        return Greeting.doGreeting(name)
    }

    private fun fallback(name: String, thr: Throwable): String {
        return Greeting.doFallback(name, thr)
    }
}
