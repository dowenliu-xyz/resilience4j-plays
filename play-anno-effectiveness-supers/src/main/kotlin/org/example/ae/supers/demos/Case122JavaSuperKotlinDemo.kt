// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.supers.biz.DemoCase
import org.example.ae.supers.biz.Greeting.doGreeting
import org.springframework.stereotype.Component

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
class Case122JavaSuperKotlinDemo : Case122JavaSuperForKotlin() {

    override fun sn(): String {
        return "122"
    }

    override fun hasClassAnnotationOnSuper(): Boolean {
        return false
    }

    override fun originMethodInSuper(): DemoCase.OriginMethodInSuper {
        return DemoCase.OriginMethodInSuper.NormalWithAnnotation
    }

    override fun fallbackInSuper(): DemoCase.FallbackInSuper {
        return DemoCase.FallbackInSuper.None
    }

    override fun hasClassAnnotationOnSub(): Boolean {
        return true
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
