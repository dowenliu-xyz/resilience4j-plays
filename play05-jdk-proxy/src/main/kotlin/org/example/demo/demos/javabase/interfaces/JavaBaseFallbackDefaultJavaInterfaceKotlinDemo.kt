package org.example.demo.demos.javabase.interfaces

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Biz

open class JavaBaseFallbackDefaultJavaInterfaceKotlinDemo : JavaBaseFallbackDefaultJavaInterfaceForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback") // TODO 接口上定义的 fallback 是 default 方法是生效的。
    override fun greeting(name: String?): String {
        return Biz.doGreeting(name)
    }
}
