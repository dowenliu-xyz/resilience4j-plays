// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import org.example.ae.supers.biz.DemoCase
import org.example.ae.supers.biz.Greeting.doGreeting

abstract class Case149KotlinSuperForJava : DemoCase {

    override fun greeting(name: String?): String {
        return "super:${doGreeting(name)}"
    }

}
