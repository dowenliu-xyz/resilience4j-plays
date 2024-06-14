package org.example.ae.demos.interfaces

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import jakarta.annotation.Nullable
import org.example.ae.biz.Greeting

interface InterfaceOriginMethodDefaultMethodAnnoFallbackKotlinInterfaceForJava {
    // TODO name 自动完成不工作
    // TODO 没有正确解析 fallbackMethod
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    fun greeting(@Nullable name: String?): String {
        return Greeting.doGreeting(name)
    }

    fun fallback(name: String?, e: Throwable?): String?
}
