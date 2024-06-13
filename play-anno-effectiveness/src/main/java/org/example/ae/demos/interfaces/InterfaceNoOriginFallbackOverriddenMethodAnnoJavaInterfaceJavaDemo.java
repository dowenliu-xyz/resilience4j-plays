package org.example.ae.demos.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.biz.Greeting.doFallback;
import static org.example.ae.biz.Greeting.doGreeting;

@Component
public class InterfaceNoOriginFallbackOverriddenMethodAnnoJavaInterfaceJavaDemo implements InterfaceNoOriginFallbackOverriddenMethodAnnoJavaInterfaceForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }

    @Override
    public String fallback(String name, Throwable e) {
        return doFallback(name, e);
    }
}
