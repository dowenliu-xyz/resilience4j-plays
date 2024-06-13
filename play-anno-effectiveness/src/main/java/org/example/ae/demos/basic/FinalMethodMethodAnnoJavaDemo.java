package org.example.ae.demos.basic;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;

import static org.example.ae.biz.Greeting.doFallback;
import static org.example.ae.biz.Greeting.doGreeting;

@SuppressWarnings("unused")
@Component
public class FinalMethodMethodAnnoJavaDemo {
    // This method is final, and annotation will not take effect.
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public final String greeting(String name) {
        return doGreeting(name);
    }

    private String fallback(String name, Throwable thr) {
        return doFallback(name, thr);
    }
}
