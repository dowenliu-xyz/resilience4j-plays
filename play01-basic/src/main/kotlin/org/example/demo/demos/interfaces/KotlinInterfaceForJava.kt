package org.example.demo.demos.interfaces

import org.slf4j.LoggerFactory

// with compiler option: -Xjvm-default=all
interface KotlinInterfaceForJava {
    companion object {
        private val log = LoggerFactory.getLogger(KotlinInterfaceForJava::class.java)
    }

    fun fallback(thr: Throwable?): String {
        log.error("Something wrong", thr)
        return "Hello there"
    }
}