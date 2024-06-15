// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.supers.biz.DemoCase
import org.example.ae.supers.biz.DemoCase.EffectiveAnnotation.*
import org.example.ae.supers.biz.DemoCase.EffectiveFallback.FallbackInSub
import org.example.ae.supers.biz.Greeting.doFallback
import org.springframework.stereotype.Component

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
class Case153JavaSuperKotlinDemo : Case153JavaSuperForKotlin() {

    override fun sn(): String {
        return "153"
    }

    override fun hasClassAnnotationOnSuper(): Boolean {
        return false
    }

    override fun originMethodInSuper(): DemoCase.OriginMethodInSuper {
        return DemoCase.OriginMethodInSuper.NormalWithoutAnnotation
    }

    override fun fallbackInSuper(): DemoCase.FallbackInSuper {
        return DemoCase.FallbackInSuper.None
    }

    override fun hasClassAnnotationOnSub(): Boolean {
        return true
    }

    override fun originMethodInSub(): DemoCase.OriginMethodInSub {
        return DemoCase.OriginMethodInSub.None
    }

    override fun hasFallbackInSub(): Boolean {
        return true
    }

    fun superClassFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnSuper:$FallbackInSub:${doFallback(name, thr)}"
    }

    fun superMethodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInSuper:$FallbackInSub:${doFallback(name, thr)}"
    }

    fun classFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnSub:$FallbackInSub:${doFallback(name, thr)}"
    }

    fun methodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInSub:$FallbackInSub:${doFallback(name, thr)}"
    }
}
