package org.example.jp.demos.javabase.interfaces

import org.example.jp.biz.Biz

@Suppress("unused")
interface JavaBaseFallbackDefaultKotlinInterfaceForKotlin {
    fun greeting(name: String?): String

    fun fallback(name: String?, thr: Throwable?): String {
        return Biz.doFallback(name, thr)
    }
}
