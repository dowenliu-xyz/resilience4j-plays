package org.example.demo.demos.basic;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;

import static org.example.demo.biz.Greeting.doFallback;
import static org.example.demo.biz.Greeting.doGreeting;

@SuppressWarnings("unused")
@Component
public class FinalMethodJavaDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public final String greeting(String name) {
        return doGreeting(name);
    }

    private String fallback(String name, Throwable thr) {
        return doFallback(name, thr);
    }

    private String fallback(Throwable thr) {
        return doFallback(thr);
    }
}
