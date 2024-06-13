package org.example.ae.demos.interfaces

import org.example.ae.biz.Greeting

interface InterfaceNoOriginFallbackClassAnnoKotlinInterfaceForJava {
    fun fallback(name: String?, e: Throwable?): String {
        return Greeting.doFallback(name, e)
    }
}
