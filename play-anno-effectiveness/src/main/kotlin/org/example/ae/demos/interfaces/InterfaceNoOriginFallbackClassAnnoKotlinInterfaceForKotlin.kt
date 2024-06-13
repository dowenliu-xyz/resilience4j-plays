package org.example.ae.demos.interfaces

import org.example.ae.biz.Greeting

interface InterfaceNoOriginFallbackClassAnnoKotlinInterfaceForKotlin {
    fun fallback(name: String?, e: Throwable?): String {
        return Greeting.doFallback(name, e)
    }
}
