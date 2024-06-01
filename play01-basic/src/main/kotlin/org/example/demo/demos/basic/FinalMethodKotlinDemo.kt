package org.example.demo.demos.basic

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Greeting
import org.springframework.stereotype.Component

@Suppress("unused")
@Component
class FinalMethodKotlinDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    final fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    private fun fallback(name: String, thr: Throwable): String {
        return Greeting.doFallback(name, thr)
    }

    private fun fallback(thr: Throwable): String {
        return Greeting.doFallback(thr)
    }
}
