package org.example.demo.demos.annobase.self

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Biz
import org.springframework.stereotype.Component

@Component
class AnnoBaseSelfKotlinDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    fun greeting(name: String?): String {
        return Biz.doGreeting(name)
    }

    private fun fallback(name: String?, thr: Throwable): String {
        return Biz.doFallback(name, thr)
    }
}
