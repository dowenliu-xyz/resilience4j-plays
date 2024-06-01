package org.example.demo.demos.basic

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Greeting.doFallback
import org.example.demo.biz.Greeting.doGreeting
import org.springframework.stereotype.Component

@Suppress("unused")
@Component
class BasicKotlinDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    fun greeting(name: String?): String {
        return doGreeting(name)
    }

    private fun fallback(name: String?, thr: Throwable): String {
        return doFallback(name, thr)
    }

    private fun fallback(thr: Throwable): String {
        return doFallback(thr)
    }
}