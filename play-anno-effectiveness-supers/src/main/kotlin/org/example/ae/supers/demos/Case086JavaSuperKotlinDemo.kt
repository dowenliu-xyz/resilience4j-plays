// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.supers.biz.DemoCase
import org.example.ae.supers.biz.Greeting.doGreeting
import org.springframework.stereotype.Component

@Component
class Case086JavaSuperKotlinDemo : Case086JavaSuperForKotlin() {

    override fun sn(): String {
        return "086"
    }

    override fun hasClassAnnotationOnSuper(): Boolean {
        return true
    }

    override fun originMethodInSuper(): DemoCase.OriginMethodInSuper {
        return DemoCase.OriginMethodInSuper.AbstractWithoutAnnotation
    }

    override fun fallbackInSuper(): DemoCase.FallbackInSuper {
        return DemoCase.FallbackInSuper.Normal
    }

    override fun hasClassAnnotationOnSub(): Boolean {
        return false
    }

    override fun originMethodInSub(): DemoCase.OriginMethodInSub {
        return DemoCase.OriginMethodInSub.WithAnnotation
    }

    override fun hasFallbackInSub(): Boolean {
        return false
    }

    @CircuitBreaker(name = "demo", fallbackMethod = "methodFallback")
    override fun greeting(name: String?): String {
        return doGreeting(name)
    }

}
