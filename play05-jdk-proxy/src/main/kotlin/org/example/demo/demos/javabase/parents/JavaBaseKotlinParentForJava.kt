package org.example.demo.demos.javabase.parents

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Biz

open class JavaBaseKotlinParentForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback") // TODO final 方法 aspect 不生效检查
    open fun greeting(name: String?): String {
        return Biz.doGreeting(name)
    }

    private fun fallback(name: String?, thr: Throwable): String {
        return Biz.doFallback(name, thr)
    }
}
