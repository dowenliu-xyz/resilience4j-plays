package org.example.ae.demos.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.biz.Greeting.doGreeting;

@Component
public class InterfaceNoOriginFallbackMethodAnnoJavaInterfaceJavaDemo implements InterfaceNoOriginFallbackMethodAnnoJavaInterfaceForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }
}
