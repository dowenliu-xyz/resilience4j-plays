// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.biz.Greeting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
@CircuitBreaker(name = "demo", fallbackMethod = "superClassFallback")
public class ParentCase056JavaParentForKotlin {
    @NotNull
    public String greeting(@Nullable String name) {
        return Greeting.doGreeting(name);
    }
}
