package org.example.ae.sic.demos.case01

import org.example.ae.sic.biz.Greeting

interface KotlinInterfaceForJava {
    fun fallback(name: String?, e: Throwable?): String {
        return "interface:${Greeting.doFallback(name, e)}"
    }
}
