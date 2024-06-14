package org.example.jp.demos.javabase.parents

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.jp.biz.Biz

open class JavaBaseKotlinParentForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    open fun greeting(name: String?): String {
        return Biz.doGreeting(name)
    }

    private fun fallback(name: String?, thr: Throwable): String {
        return Biz.doFallback(name, thr)
    }
}
