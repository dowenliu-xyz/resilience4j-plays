// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos;

import org.example.ae.interfaces.cglib.biz.DemoCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.ae.interfaces.cglib.biz.Greeting.doGreeting;

public interface Case158JavaInterfaceForJava extends DemoCase {

    @NotNull
    @Override
    default String greeting(@Nullable String name) {
        return "super:" + doGreeting(name);
    }

}
