// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos

import org.example.ae.interfaces.jdk.biz.DemoCase
import org.example.ae.interfaces.jdk.biz.Greeting.doGreeting

interface Case160JavaBaseKotlinInterfaceForKotlin : DemoCase {

    override fun greeting(name: String?): String {
        return "super:${doGreeting(name)}"
    }

}
