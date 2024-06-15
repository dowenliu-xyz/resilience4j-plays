package org.example.ae.basic.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.basic.biz.Greeting
import org.springframework.stereotype.Component

@Suppress("unused")
@Component
class FinalMethodMethodAnnoKotlinDemo {
    // This method is final, and annotation will not take effect.
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    final fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    private fun fallback(name: String, thr: Throwable): String {
        return Greeting.doFallback(name, thr)
    }
}
