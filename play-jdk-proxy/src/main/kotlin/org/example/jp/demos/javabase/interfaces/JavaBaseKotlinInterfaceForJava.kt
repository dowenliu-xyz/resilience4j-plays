package org.example.jp.demos.javabase.interfaces

interface JavaBaseKotlinInterfaceForJava {
    fun greeting(name: String?): String

    fun fallback(name: String?, thr: Throwable?): String
}
