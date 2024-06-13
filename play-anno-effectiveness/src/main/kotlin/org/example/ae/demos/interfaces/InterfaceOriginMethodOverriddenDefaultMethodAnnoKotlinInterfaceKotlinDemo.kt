package org.example.ae.demos.interfaces

import org.example.ae.biz.Greeting
import org.example.ae.biz.Greeting.doGreeting
import org.springframework.stereotype.Component

@Suppress("unused")
@Component
class InterfaceOriginMethodOverriddenDefaultMethodAnnoKotlinInterfaceKotlinDemo :
    InterfaceOriginMethodOverriddenDefaultMethodAnnoKotlinInterfaceForKotlin {
    override fun greeting(name: String?): String {
        return doGreeting(name)
    }

    private fun fallback(name: String, e: Throwable): String {
        return Greeting.doFallback(name, e)
    }
}
