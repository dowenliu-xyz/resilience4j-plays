// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos

import org.example.ae.interfaces.cglib.biz.DemoCase
import org.example.ae.interfaces.cglib.biz.Greeting.doGreeting

interface Case158KotlinInterfaceForJava : DemoCase {

    override fun greeting(name: String?): String {
        return "super:${doGreeting(name)}"
    }

}
