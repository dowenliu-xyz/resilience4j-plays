package org.example.demo.demos.javabase.self

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Biz

// kotlin spring 插件只会 open 有对应注解的类。这里需要手动 open ，否则编译后仍然是 final 的，会因为无法被 cglib 代理，启动报错。

open class JavaBaseSelfKotlinDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    open fun greeting(name: String?): String {
        return Biz.doGreeting(name)
    }

    private fun fallback(name: String?, thr: Throwable): String {
        return Biz.doFallback(name, thr)
    }
}
