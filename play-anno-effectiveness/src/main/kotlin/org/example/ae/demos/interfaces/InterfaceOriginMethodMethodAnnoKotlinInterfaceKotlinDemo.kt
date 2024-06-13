package org.example.ae.demos.interfaces

import org.example.ae.biz.Greeting
import org.springframework.stereotype.Component

@Suppress("unused")
@Component
class InterfaceOriginMethodMethodAnnoKotlinInterfaceKotlinDemo : InterfaceOriginMethodMethodAnnoKotlinInterfaceForKotlin {
    override fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    private fun fallback(name: String, e: Throwable): String {
        return Greeting.doFallback(name, e)
    }
}
