package org.example.jp.demos.annobase.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.jp.biz.Biz.doFallback;
import static org.example.jp.biz.Biz.doGreeting;

@Component
public class AnnoBaseJavaInterfaceJavaDemo implements AnnoBaseJavaInterfaceForJava {
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
