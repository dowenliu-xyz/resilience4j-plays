package org.example.demo.demos.annobase.self;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.demo.biz.Biz.doFallback;
import static org.example.demo.biz.Biz.doGreeting;

@Component
public class AnnoBaseSelfJavaDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public @NotNull String greeting(@Nullable String name) {
        return doGreeting(name);
    }

    private String fallback(@Nullable String name, Throwable thr) {
        return doFallback(name, thr);
    }
}
