// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.biz.Greeting

@Suppress("unused", "UNUSED_PARAMETER")
open class ParentCase089KotlinParentForJava {
    open fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }
}