package org.example.jp.demos.annobase.interfaces

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.jp.biz.Biz
import org.springframework.stereotype.Component

@Component
class AnnoBaseKotlinInterfaceKotlinDemo : AnnoBaseKotlinInterfaceForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    override fun greeting(name: String?): String {
        return Biz.doGreeting(name)
    }

    override fun fallback(name: String?, thr: Throwable?): String {
        return Biz.doFallback(name, thr)
    }
}
