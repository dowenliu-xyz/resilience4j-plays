package org.example.ae.demos.basic;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import static org.example.ae.biz.Greeting.doFallback;
import static org.example.ae.biz.Greeting.doGreeting;

@Component
public class BasicMethodAnnoJavaDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public String greeting(@NotNull String name) {
        return doGreeting(name);
    }

    private String fallback(@NotNull String name, Throwable thr) {
        return doFallback(name, thr);
    }
}
