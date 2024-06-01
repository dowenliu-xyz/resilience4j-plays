package org.example.demo.demos.javabase.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.demo.biz.Biz.doFallback;
import static org.example.demo.biz.Biz.doGreeting;

public class JavaBaseJavaInterfaceJavaDemo implements JavaBaseJavaInterfaceForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }

    @NotNull
    @Override
    public String fallback(@Nullable String name, @Nullable Throwable thr) {
        return doFallback(name, thr);
    }
}
