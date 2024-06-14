package org.example.demo.demos.javabase.interfaces

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Biz

open class JavaBaseFallbackDefaultOverriddenJavaInterfaceKotlinDemo :
    JavaBaseFallbackDefaultOverriddenJavaInterfaceForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback") // TODO 接口上定义的 fallback 是 default 方法时，这里重写的 fallback 是生效的。
    override fun greeting(name: String?): String {
        return Biz.doGreeting(name)
    }

    override fun fallback(name: String?, thr: Throwable?): String {
        return Biz.doFallback(name, thr)
    }
}
