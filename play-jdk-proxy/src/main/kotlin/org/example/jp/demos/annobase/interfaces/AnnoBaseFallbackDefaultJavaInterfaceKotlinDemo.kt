package org.example.jp.demos.annobase.interfaces

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.jp.biz.Biz
import org.springframework.stereotype.Component

@Component
class AnnoBaseFallbackDefaultJavaInterfaceKotlinDemo : AnnoBaseFallbackDefaultJavaInterfaceForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback") // TODO 接口上定义的 fallback 是 default 方法是生效的。
    override fun greeting(name: String?): String {
        return Biz.doGreeting(name)
    }
}
