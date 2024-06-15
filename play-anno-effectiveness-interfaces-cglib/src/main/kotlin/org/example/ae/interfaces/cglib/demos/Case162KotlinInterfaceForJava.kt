// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.interfaces.cglib.biz.DemoCase
import org.example.ae.interfaces.cglib.biz.DemoCase.EffectiveAnnotation.*
import org.example.ae.interfaces.cglib.biz.DemoCase.EffectiveFallback.FallbackInInterface
import org.example.ae.interfaces.cglib.biz.Greeting.doFallback

interface Case162KotlinInterfaceForJava : DemoCase {

    @CircuitBreaker(name = "demo", fallbackMethod = "interfaceMethodFallback")
    override fun greeting(name: String?): String

    fun interfaceClassFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnInterface:$FallbackInInterface:${doFallback(name, thr)}"
    }

    fun interfaceMethodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInInterface:$FallbackInInterface:${doFallback(name, thr)}"
    }

    fun classFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnClass:$FallbackInInterface:${doFallback(name, thr)}"
    }

    fun methodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInClass:$FallbackInInterface:${doFallback(name, thr)}"
    }

}
