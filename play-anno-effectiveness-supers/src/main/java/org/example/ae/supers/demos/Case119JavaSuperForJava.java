// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.supers.biz.DemoCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.ae.supers.biz.Greeting.doGreeting;

public abstract class Case119JavaSuperForJava implements DemoCase {

    @CircuitBreaker(name = "demo", fallbackMethod = "superMethodFallback")
    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return "super:" + doGreeting(name);
    }

}