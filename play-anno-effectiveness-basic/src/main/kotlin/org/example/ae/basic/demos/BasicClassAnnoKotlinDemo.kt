package org.example.ae.basic.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.basic.biz.Greeting
import org.springframework.stereotype.Component

@CircuitBreaker(name = "demo", fallbackMethod = "fallback")
@Component
class BasicClassAnnoKotlinDemo {
    // TODO 生效注解 hint
    fun greeting(name: String): String {
        return Greeting.doGreeting(name)
    }

    private fun fallback(name: String, thr: Throwable): String {
        return Greeting.doFallback(name, thr)
    }
}
