package org.example.ae.basic.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.basic.biz.Greeting
import org.springframework.stereotype.Component

@Component
@Suppress("unused")
class StaticMethodMethodAnnoKotlinDemo {
    companion object {
        @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
        @JvmStatic
        fun greeting(name: String): String {
            return Greeting.doGreeting(name)
        }
    }

    private fun fallback(name: String, thr: Throwable): String {
        return Greeting.doFallback(name, thr)
    }
}
