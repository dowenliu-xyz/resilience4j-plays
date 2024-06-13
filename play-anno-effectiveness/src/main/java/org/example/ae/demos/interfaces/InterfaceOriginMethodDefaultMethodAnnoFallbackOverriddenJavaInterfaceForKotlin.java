package org.example.ae.demos.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Nullable;

import static org.example.ae.biz.Greeting.doGreeting;

public interface InterfaceOriginMethodDefaultMethodAnnoFallbackOverriddenJavaInterfaceForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    default String greeting(@Nullable String name) {
        return doGreeting(name);
    }

    default String fallback(String name, Throwable e) {
        return "";
    }
}
