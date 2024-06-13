// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.biz.Greeting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class ParentCase076JavaParentForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "superFallback")
    @NotNull
    public String greeting(@Nullable String name) {
        return Greeting.doGreeting(name);
    }

    @NotNull
    private String superClassFallback(@Nullable String name, @Nullable Throwable e) {
        return TakeEffectAnno.SuperClassAnno + ":" + FallbackLocation.Super + ":" + Greeting.doFallback(name, e);
    }

    @NotNull
    private String superFallback(@Nullable String name, @Nullable Throwable e) {
        return TakeEffectAnno.SuperMethodAnno + ":" + FallbackLocation.Super + ":" + Greeting.doFallback(name, e);
    }

    @NotNull
    private String classFallback(@Nullable String name, @Nullable Throwable e) {
        return TakeEffectAnno.SubClassAnno + ":" + FallbackLocation.Super + ":" + Greeting.doFallback(name, e);
    }

    @NotNull
    private String fallback(@Nullable String name, @Nullable Throwable e) {
        return TakeEffectAnno.SubMethodAnno + ":" + FallbackLocation.Super + ":" + Greeting.doFallback(name, e);
    }
}