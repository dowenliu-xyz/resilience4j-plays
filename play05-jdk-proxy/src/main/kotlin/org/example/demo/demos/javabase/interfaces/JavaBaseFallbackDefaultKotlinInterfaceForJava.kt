package org.example.demo.demos.javabase.interfaces

import org.example.demo.biz.Biz

@Suppress("unused")
interface JavaBaseFallbackDefaultKotlinInterfaceForJava {
    fun greeting(name: String?): String

    fun fallback(name: String?, thr: Throwable?): String {
        return Biz.doFallback(name, thr)
    }
}
