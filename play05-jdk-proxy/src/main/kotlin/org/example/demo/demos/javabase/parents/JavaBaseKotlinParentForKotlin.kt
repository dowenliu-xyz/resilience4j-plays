package org.example.demo.demos.javabase.parents

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Biz

open class JavaBaseKotlinParentForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    open fun greeting(name: String?): String {
        return Biz.doGreeting(name)
    }

    private fun fallback(name: String?, thr: Throwable): String {
        return Biz.doFallback(name, thr)
    }
}
