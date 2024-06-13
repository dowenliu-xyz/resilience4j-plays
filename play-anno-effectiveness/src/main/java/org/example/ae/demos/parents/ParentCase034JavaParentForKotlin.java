// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.biz.Greeting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
@CircuitBreaker(name = "demo", fallbackMethod = "superClassFallback")
public class ParentCase034JavaParentForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "superFallback")
    @NotNull
    public String greeting(@Nullable String name) {
        return "parent: hello " + name;
    }

    @NotNull
    protected String superClassFallback(@Nullable String name, @Nullable Throwable e) {
        return TakeEffectAnno.SuperClassAnno + ":" + FallbackLocation.Super + ":" + Greeting.doFallback(name, e);
    }

    @NotNull
    protected String superFallback(@Nullable String name, @Nullable Throwable e) {
        return TakeEffectAnno.SuperMethodAnno + ":" + FallbackLocation.Super + ":" + Greeting.doFallback(name, e);
    }

    @NotNull
    protected String classFallback(@Nullable String name, @Nullable Throwable e) {
        return TakeEffectAnno.SubClassAnno + ":" + FallbackLocation.Super + ":" + Greeting.doFallback(name, e);
    }

    @NotNull
    protected String fallback(@Nullable String name, @Nullable Throwable e) {
        return TakeEffectAnno.SubMethodAnno + ":" + FallbackLocation.Super + ":" + Greeting.doFallback(name, e);
    }
}
