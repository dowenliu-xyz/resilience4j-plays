package org.example.demo.demos.basic;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;

import static org.example.demo.biz.Greeting.doFallback;
import static org.example.demo.biz.Greeting.doGreeting;

//@Component // Enable this will cause bootstrap failure.
@CircuitBreaker(name = "demo")
public final class FinalClassJavaDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public String greeting(String name) {
        return doGreeting(name);
    }

    private String fallback(String name, Throwable thr) {
        return doFallback(name, thr);
    }

    private String fallback(Throwable thr) {
        return doFallback(thr);
    }
}
