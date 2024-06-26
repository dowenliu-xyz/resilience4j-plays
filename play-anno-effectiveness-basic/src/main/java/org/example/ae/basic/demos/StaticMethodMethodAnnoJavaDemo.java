package org.example.ae.basic.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import static org.example.ae.basic.biz.Greeting.doFallback;
import static org.example.ae.basic.biz.Greeting.doGreeting;

@Component
@SuppressWarnings("unused")
public class StaticMethodMethodAnnoJavaDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public static String greeting(@NotNull String name) {
        return doGreeting(name);
    }

    private String fallback(@NotNull String name, Throwable thr) {
        return doFallback(name, thr);
    }
}
