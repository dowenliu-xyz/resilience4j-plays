// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.interfaces.jdk.biz.Greeting.doGreeting;

@Component
public class Case056JavaBaseKotlinInterfaceJavaDemo implements Case056JavaBaseKotlinInterfaceForJava {

    @NotNull
    @Override
    public String sn() {
        return "056";
    }

    @Override
    public boolean hasClassAnnotationOnInterface() {
        return true;
    }

    @NotNull
    @Override
    public OriginMethodInInterface originMethodInInterface() {
        return OriginMethodInInterface.DefaultWithoutAnnotation;
    }

    @NotNull
    @Override
    public FallbackInInterface fallbackInInterface() {
        return FallbackInInterface.None;
    }

    @Override
    public boolean hasClassAnnotationOnClass() {
        return false;
    }

    @NotNull
    @Override
    public OriginMethodInClass originMethodInClass() {
        return OriginMethodInClass.WithAnnotation;
    }

    @Override
    public boolean hasFallbackInClass() {
        return false;
    }

    @CircuitBreaker(name = "demo", fallbackMethod = "methodFallback")
    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }

}
