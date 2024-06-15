// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.interfaces.jdk.biz.DemoCase
import org.example.ae.interfaces.jdk.biz.DemoCase.EffectiveAnnotation.*
import org.example.ae.interfaces.jdk.biz.DemoCase.EffectiveFallback.FallbackInInterface
import org.example.ae.interfaces.jdk.biz.Greeting.doFallback
import org.example.ae.interfaces.jdk.biz.Greeting.doGreeting

interface Case107AnnotationBaseKotlinInterfaceForKotlin : DemoCase {

    @CircuitBreaker(name = "demo", fallbackMethod = "interfaceMethodFallback")
    override fun greeting(name: String?): String {
        return "super:${doGreeting(name)}"
    }

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
