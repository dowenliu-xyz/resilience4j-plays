// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.supers.biz.Greeting.doGreeting;

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
public class Case122JavaSuperJavaDemo extends Case122JavaSuperForJava {

    @NotNull
    @Override
    public String sn() {
        return "122";
    }

    @Override
    public boolean hasClassAnnotationOnSuper() {
        return false;
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
        return OriginMethodInSub.WithoutAnnotation;
    }

    @Override
    public boolean hasFallbackInSub() {
        return false;
    }

    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }

}