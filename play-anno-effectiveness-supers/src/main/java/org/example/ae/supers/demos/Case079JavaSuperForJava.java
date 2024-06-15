// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.supers.biz.DemoCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


@CircuitBreaker(name = "demo", fallbackMethod = "superClassFallback")
public abstract class Case079JavaSuperForJava implements DemoCase {

    @CircuitBreaker(name = "demo", fallbackMethod = "superMethodFallback")
    @NotNull
    public abstract String greeting(@Nullable String name);

}
