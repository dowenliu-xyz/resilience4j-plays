package org.example.demo.demos.annobase.interfaces

import org.example.demo.biz.Biz

@Suppress("unused")
interface AnnoBaseFallbackDefaultKotlinInterfaceForJava {
    fun greeting(name: String?): String

    fun fallback(name: String?, thr: Throwable?): String {
        return Biz.doFallback(name, thr)
    }
}
