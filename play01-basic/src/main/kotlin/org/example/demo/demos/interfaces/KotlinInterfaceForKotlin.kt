package org.example.demo.demos.interfaces

import org.slf4j.LoggerFactory

interface KotlinInterfaceForKotlin {
    companion object {
        private val log = LoggerFactory.getLogger(KotlinInterfaceForJava::class.java)
    }

    fun fallback(name: String?, thr: Throwable?): String {
        log.error("Something wrong", thr)
        return "Hello there"
    }

    fun fallback(thr: Throwable?): String {
        log.error("Something wrong", thr)
        return "Hello there"
    }
}