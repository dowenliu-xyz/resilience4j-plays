// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.supers.biz.Greeting.doGreeting;

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
public class Case020KotlinSuperJavaDemo extends Case020KotlinSuperForJava {

    @NotNull
    @Override
    public String sn() {
        return "020";
    }

    @Override
    public boolean hasClassAnnotationOnSuper() {
        return true;
    }

    @NotNull
    @Override
    public OriginMethodInSuper originMethodInSuper() {
        return OriginMethodInSuper.NormalWithAnnotation;
    }

    @NotNull
    @Override
    public FallbackInSuper fallbackInSuper() {
        return FallbackInSuper.None;
    }

    @Override
    public boolean hasClassAnnotationOnSub() {
        return true;
    }

    @NotNull
    @Override
    public OriginMethodInSub originMethodInSub() {
        return OriginMethodInSub.WithAnnotation;
    }

    @Override
    public boolean hasFallbackInSub() {
        return false;
    }

    @CircuitBreaker(name = "demo", fallbackMethod = "methodFallback")
    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }

}
