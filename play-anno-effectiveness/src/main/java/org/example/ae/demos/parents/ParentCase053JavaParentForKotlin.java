// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
@CircuitBreaker(name = "demo", fallbackMethod = "superClassFallback")
public class ParentCase053JavaParentForKotlin {
    @NotNull
    public String greeting(@Nullable String name) {
        return "parent: hello " + name;
    }
}
