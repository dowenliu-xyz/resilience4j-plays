package org.example.ae.sic.demos.case01

import org.example.ae.sic.biz.Greeting

open class KotlinParentForKotlin {
    open fun fallback(name: String?, e: Throwable?): String {
        return "super:${Greeting.doFallback(name, e)}"
    }
}
