// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos

import org.example.ae.interfaces.jdk.biz.DemoCase
import org.example.ae.interfaces.jdk.biz.DemoCase.EffectiveAnnotation.*
import org.example.ae.interfaces.jdk.biz.DemoCase.EffectiveFallback.FallbackInClass
import org.example.ae.interfaces.jdk.biz.Greeting.doFallback
import org.example.ae.interfaces.jdk.biz.Greeting.doGreeting
import org.springframework.stereotype.Component

@Component
class Case047AnnotationBaseKotlinInterfaceKotlinDemo : Case047AnnotationBaseKotlinInterfaceForKotlin {

    override fun sn(): String {
        return "047"
    }

    override fun hasClassAnnotationOnInterface(): Boolean {
        return true
    }

    override fun originMethodInInterface(): DemoCase.OriginMethodInInterface {
        return DemoCase.OriginMethodInInterface.DefaultWithoutAnnotation
    }

    override fun fallbackInInterface(): DemoCase.FallbackInInterface {
        return DemoCase.FallbackInInterface.Abstract
    }

    override fun hasClassAnnotationOnClass(): Boolean {
        return false
    }

    override fun originMethodInClass(): DemoCase.OriginMethodInClass {
        return DemoCase.OriginMethodInClass.WithoutAnnotation
    }

    override fun hasFallbackInClass(): Boolean {
        return true
    }

    override fun greeting(name: String?): String {
        return doGreeting(name)
    }

    override fun interfaceClassFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnInterface:$FallbackInClass:${doFallback(name, thr)}"
    }

    override fun interfaceMethodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInInterface:$FallbackInClass:${doFallback(name, thr)}"
    }

    override fun classFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnClass:$FallbackInClass:${doFallback(name, thr)}"
    }

    override fun methodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInClass:$FallbackInClass:${doFallback(name, thr)}"
    }
}
