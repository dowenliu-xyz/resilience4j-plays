// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import org.example.ae.supers.biz.DemoCase
import org.example.ae.supers.biz.Greeting.doGreeting
import org.springframework.stereotype.Component

@Component
class Case080JavaSuperKotlinDemo : Case080JavaSuperForKotlin() {

    override fun sn(): String {
        return "080"
    }

    override fun hasClassAnnotationOnSuper(): Boolean {
        return true
    }

    override fun originMethodInSuper(): DemoCase.OriginMethodInSuper {
        return DemoCase.OriginMethodInSuper.AbstractWithAnnotation
    }

    override fun fallbackInSuper(): DemoCase.FallbackInSuper {
        return DemoCase.FallbackInSuper.None
    }

    override fun hasClassAnnotationOnSub(): Boolean {
        return false
    }

    override fun originMethodInSub(): DemoCase.OriginMethodInSub {
        return DemoCase.OriginMethodInSub.WithoutAnnotation
    }

    override fun hasFallbackInSub(): Boolean {
        return false
    }

    override fun greeting(name: String?): String {
        return doGreeting(name)
    }

}
