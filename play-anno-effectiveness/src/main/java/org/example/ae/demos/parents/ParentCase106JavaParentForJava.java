// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class ParentCase106JavaParentForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "superFallback")
    @NotNull
    public String greeting(@Nullable String name) {
        return "parent: hello " + name;
    }
}
