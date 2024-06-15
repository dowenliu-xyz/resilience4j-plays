// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.supers.biz.DemoCase
import org.example.ae.supers.biz.DemoCase.EffectiveAnnotation.*
import org.example.ae.supers.biz.DemoCase.EffectiveFallback.FallbackInSub
import org.example.ae.supers.biz.Greeting.doFallback
import org.example.ae.supers.biz.Greeting.doGreeting
import org.springframework.stereotype.Component

@Component
class Case091JavaSuperKotlinDemo : Case091JavaSuperForKotlin() {

    override fun sn(): String {
        return "091"
    }

    override fun hasClassAnnotationOnSuper(): Boolean {
        return true
    }

    override fun originMethodInSuper(): DemoCase.OriginMethodInSuper {
        return DemoCase.OriginMethodInSuper.AbstractWithoutAnnotation
    }

    override fun fallbackInSuper(): DemoCase.FallbackInSuper {
        return DemoCase.FallbackInSuper.Abstract
    }

    override fun hasClassAnnotationOnSub(): Boolean {
        return false
    }

    override fun originMethodInSub(): DemoCase.OriginMethodInSub {
        return DemoCase.OriginMethodInSub.WithAnnotation
    }

    override fun hasFallbackInSub(): Boolean {
        return true
    }

    @CircuitBreaker(name = "demo", fallbackMethod = "methodFallback")
    override fun greeting(name: String?): String {
        return doGreeting(name)
    }

    override fun superClassFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnSuper:$FallbackInSub:${doFallback(name, thr)}"
    }

    override fun superMethodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInSuper:$FallbackInSub:${doFallback(name, thr)}"
    }

    override fun classFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnSub:$FallbackInSub:${doFallback(name, thr)}"
    }

    override fun methodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInSub:$FallbackInSub:${doFallback(name, thr)}"
    }
}
