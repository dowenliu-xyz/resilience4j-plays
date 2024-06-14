package org.example.jp.demos.javabase.self;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.jp.biz.Biz.doFallback;
import static org.example.jp.biz.Biz.doGreeting;

public class JavaBaseSelfJavaDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public @NotNull String greeting(@Nullable String name) {
        return doGreeting(name);
    }

    private String fallback(@Nullable String name, Throwable thr) {
        return doFallback(name, thr);
    }
}
