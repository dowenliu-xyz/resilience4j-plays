// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import org.example.ae.supers.biz.DemoCase
import org.example.ae.supers.biz.DemoCase.EffectiveAnnotation.*
import org.example.ae.supers.biz.DemoCase.EffectiveFallback.FallbackInSuper
import org.example.ae.supers.biz.Greeting.doFallback
import org.example.ae.supers.biz.Greeting.doGreeting

abstract class Case132KotlinSuperForJava : DemoCase {

    override fun greeting(name: String?): String {
        return "super:${doGreeting(name)}"
    }

    fun superClassFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnSuper:$FallbackInSuper:${doFallback(name, thr)}"
    }

    fun superMethodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInSuper:$FallbackInSuper:${doFallback(name, thr)}"
    }

    fun classFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnSub:$FallbackInSuper:${doFallback(name, thr)}"
    }

    fun methodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInSub:$FallbackInSuper:${doFallback(name, thr)}"
    }

}
