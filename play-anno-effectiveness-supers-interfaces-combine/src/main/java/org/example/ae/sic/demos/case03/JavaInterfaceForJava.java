package org.example.ae.sic.demos.case03;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.ae.sic.biz.Greeting.doGreeting;

public interface JavaInterfaceForJava {
    @NotNull
    default String greeting(@Nullable String name) {
        return doGreeting(name);
    }
}
