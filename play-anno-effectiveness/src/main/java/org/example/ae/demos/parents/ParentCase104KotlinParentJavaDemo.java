// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.biz.Greeting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class ParentCase104KotlinParentJavaDemo extends ParentCase104KotlinParentForJava {
    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return Greeting.doGreeting(name);
    }

    @NotNull
    @Override
    protected String superClassFallback(@Nullable String name, @Nullable Throwable e) {
        return TakeEffectAnno.SuperClassAnno + ":" + FallbackLocation.Sub + ":" + Greeting.doFallback(name, e);
    }

    @NotNull
    @Override
    protected String superFallback(@Nullable String name, @Nullable Throwable e) {
        return TakeEffectAnno.SuperMethodAnno + ":" + FallbackLocation.Sub + ":" + Greeting.doFallback(name, e);
    }

    @NotNull
    @Override
    protected String classFallback(@Nullable String name, @Nullable Throwable e) {
        return TakeEffectAnno.SubClassAnno + ":" + FallbackLocation.Sub + ":" + Greeting.doFallback(name, e);
    }

    @NotNull
    @Override
    protected String fallback(@Nullable String name, @Nullable Throwable e) {
        return TakeEffectAnno.SubMethodAnno + ":" + FallbackLocation.Sub + ":" + Greeting.doFallback(name, e);
    }
}
