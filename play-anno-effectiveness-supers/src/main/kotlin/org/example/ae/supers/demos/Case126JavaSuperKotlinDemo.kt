// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.supers.biz.DemoCase
import org.example.ae.supers.biz.Greeting.doGreeting
import org.springframework.stereotype.Component

@Component
class Case126JavaSuperKotlinDemo : Case126JavaSuperForKotlin() {

    override fun sn(): String {
        return "126"
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
