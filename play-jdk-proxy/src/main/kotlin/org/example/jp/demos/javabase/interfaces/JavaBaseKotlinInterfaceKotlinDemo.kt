package org.example.jp.demos.javabase.interfaces

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.jp.biz.Biz

class JavaBaseKotlinInterfaceKotlinDemo : JavaBaseKotlinInterfaceForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    override fun greeting(name: String?): String {
        return Biz.doGreeting(name)
    }

    override fun fallback(name: String?, thr: Throwable?): String {
        return Biz.doFallback(name, thr)
    }
}
