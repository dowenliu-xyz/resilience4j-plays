// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.interfaces.cglib.biz.Greeting.doGreeting;

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
public class Case132JavaInterfaceJavaDemo implements Case132JavaInterfaceForJava {

    @NotNull
    @Override
    public String sn() {
        return "132";
    }

    @Override
    public boolean hasClassAnnotationOnInterface() {
        return false;
    }

    @NotNull
    @Override
    public OriginMethodInInterface originMethodInInterface() {
        return OriginMethodInInterface.DefaultWithoutAnnotation;
    }

    @NotNull
    @Override
    public FallbackInInterface fallbackInInterface() {
        return FallbackInInterface.Default;
    }

    @Override
    public boolean hasClassAnnotationOnClass() {
        return true;
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
