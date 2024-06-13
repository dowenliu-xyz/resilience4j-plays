package org.example.ae.demos.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Nullable;

import static org.example.ae.biz.Greeting.doGreeting;

public interface InterfaceOriginMethodDefaultMethodAnnoJavaInterfaceForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback") // TODO 没有找到 fallbackMethod
    default String greeting(@Nullable String name) {
        return doGreeting(name);
    }
}
