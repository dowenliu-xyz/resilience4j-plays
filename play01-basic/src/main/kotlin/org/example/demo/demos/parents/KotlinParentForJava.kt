package org.example.demo.demos.parents

import org.slf4j.LoggerFactory

@Suppress("UNUSED_PARAMETER")
abstract class KotlinParentForJava {
    companion object {
        private val log = LoggerFactory.getLogger(KotlinParentForJava::class.java)
    }

    private fun fallback(name: String, thr: Throwable): String {
        log.error("parent fallback", thr)
        return "Hello stranger (from parent)"
    }

    private fun fallback(thr: Throwable): String {
        log.error("parent fallback", thr)
        return "Hello stranger (from parent)"
    }
}