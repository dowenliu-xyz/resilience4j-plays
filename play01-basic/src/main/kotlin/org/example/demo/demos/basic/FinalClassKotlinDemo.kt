package org.example.demo.demos.basic

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Greeting

// Kotlin's spring plugin only opens classes which annotated with specified annotations.
// Java-base container configured bean class won't be opened.
// This class will be compiled to a final class.
@CircuitBreaker(name = "demo")
class FinalClassKotlinDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
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
