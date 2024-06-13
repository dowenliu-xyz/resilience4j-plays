package org.example.ae.demos.basic

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.biz.Greeting

//@Component // Enable this will cause bootstrap failure.
@Suppress("unused")
@CircuitBreaker(name = "demo", fallbackMethod = "fallback")
final class FinalClassClassAnnoKotlinDemo {
    fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    private fun fallback(name: String, thr: Throwable): String {
        return Greeting.doFallback(name, thr)
    }
}
