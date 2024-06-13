// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.biz.Greeting
import org.springframework.stereotype.Component

@Suppress("unused", "UNUSED_PARAMETER")
@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
class ParentCase074JavaParentKotlinDemo : ParentCase074JavaParentForKotlin() {
    override fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }
}
