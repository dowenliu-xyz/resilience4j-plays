package org.example.ae.demos.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Nullable;

public interface InterfaceOriginMethodMethodAnnoJavaInterfaceForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    String greeting(@Nullable String name);
}
