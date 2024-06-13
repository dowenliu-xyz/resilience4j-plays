// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.biz.Greeting
import org.springframework.stereotype.Component

@Suppress("unused", "UNUSED_PARAMETER")
@Component
class ParentCase059KotlinParentKotlinDemo : ParentCase059KotlinParentForKotlin() {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
     fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }
}
