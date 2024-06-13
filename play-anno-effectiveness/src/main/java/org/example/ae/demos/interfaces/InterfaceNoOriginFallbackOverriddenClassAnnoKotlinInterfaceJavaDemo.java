package org.example.ae.demos.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Nullable;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import static org.example.ae.biz.Greeting.doFallback;
import static org.example.ae.biz.Greeting.doGreeting;

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "fallback")
public class InterfaceNoOriginFallbackOverriddenClassAnnoKotlinInterfaceJavaDemo implements InterfaceNoOriginFallbackOverriddenClassAnnoKotlinInterfaceForJava {
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }

    @NotNull
    @Override
    public String fallback(@Nullable String name, @Nullable Throwable e) {
        return doFallback(name, e);
    }
}
