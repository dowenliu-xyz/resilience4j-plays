// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import org.example.ae.supers.biz.DemoCase
import org.example.ae.supers.biz.DemoCase.EffectiveAnnotation.*
import org.example.ae.supers.biz.DemoCase.EffectiveFallback.FallbackInSub
import org.example.ae.supers.biz.Greeting.doFallback
import org.springframework.stereotype.Component

@Component
class Case029JavaSuperKotlinDemo : Case029JavaSuperForKotlin() {

    override fun sn(): String {
        return "029"
    }

    override fun hasClassAnnotationOnSuper(): Boolean {
        return true
    }

    override fun originMethodInSuper(): DemoCase.OriginMethodInSuper {
        return DemoCase.OriginMethodInSuper.NormalWithAnnotation
    }

    override fun fallbackInSuper(): DemoCase.FallbackInSuper {
        return DemoCase.FallbackInSuper.None
    }

    override fun hasClassAnnotationOnSub(): Boolean {
        return false
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
