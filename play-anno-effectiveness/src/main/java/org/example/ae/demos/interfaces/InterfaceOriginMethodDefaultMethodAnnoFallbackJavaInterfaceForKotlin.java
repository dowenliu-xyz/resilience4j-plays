package org.example.ae.demos.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Nullable;

import static org.example.ae.biz.Greeting.doFallback;
import static org.example.ae.biz.Greeting.doGreeting;

public interface InterfaceOriginMethodDefaultMethodAnnoFallbackJavaInterfaceForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    default String greeting(@Nullable String name) {
        return doGreeting(name);
    }

    default String fallback(String name, Throwable e) {
        return doFallback(name, e);
    }
}
