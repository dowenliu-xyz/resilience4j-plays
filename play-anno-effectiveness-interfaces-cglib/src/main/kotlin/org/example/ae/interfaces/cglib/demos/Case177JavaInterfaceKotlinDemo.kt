// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.interfaces.cglib.biz.DemoCase
import org.example.ae.interfaces.cglib.biz.DemoCase.EffectiveAnnotation.*
import org.example.ae.interfaces.cglib.biz.DemoCase.EffectiveFallback.FallbackInClass
import org.example.ae.interfaces.cglib.biz.Greeting.doFallback
import org.example.ae.interfaces.cglib.biz.Greeting.doGreeting
import org.springframework.stereotype.Component

@Component
class Case177JavaInterfaceKotlinDemo : Case177JavaInterfaceForKotlin {

    override fun sn(): String {
        return "177"
    }

    override fun hasClassAnnotationOnInterface(): Boolean {
        return false
    }

    override fun originMethodInInterface(): DemoCase.OriginMethodInInterface {
        return DemoCase.OriginMethodInInterface.AbstractWithAnnotation
    }

    override fun fallbackInInterface(): DemoCase.FallbackInInterface {
        return DemoCase.FallbackInInterface.None
    }

    override fun hasClassAnnotationOnClass(): Boolean {
        return false
    }

    override fun originMethodInClass(): DemoCase.OriginMethodInClass {
        return DemoCase.OriginMethodInClass.WithAnnotation
    }

    override fun hasFallbackInClass(): Boolean {
        return true
    }

    @CircuitBreaker(name = "demo", fallbackMethod = "methodFallback")
    override fun greeting(name: String?): String {
        return doGreeting(name)
    }

    fun interfaceClassFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnInterface:$FallbackInClass:${doFallback(name, thr)}"
    }

    fun interfaceMethodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInInterface:$FallbackInClass:${doFallback(name, thr)}"
    }

    fun classFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnClass:$FallbackInClass:${doFallback(name, thr)}"
    }

    fun methodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInClass:$FallbackInClass:${doFallback(name, thr)}"
    }
}
