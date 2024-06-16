package org.example.ae.basic.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import static org.example.ae.basic.biz.Greeting.doFallback;
import static org.example.ae.basic.biz.Greeting.doGreeting;

//@Component // Enable this will cause bootstrap failure.
@SuppressWarnings("unused")
public final class FinalClassMethodAnnoJavaDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public String greeting(String name) {
        return doGreeting(name);
    }

    private String fallback(String name, Throwable thr) {
        return doFallback(name, thr);
    }
}