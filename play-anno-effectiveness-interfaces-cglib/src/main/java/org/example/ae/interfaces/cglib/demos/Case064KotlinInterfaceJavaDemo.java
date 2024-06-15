// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.interfaces.cglib.biz.Greeting.doGreeting;

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
public class Case064KotlinInterfaceJavaDemo implements Case064KotlinInterfaceForJava {

    @NotNull
    @Override
    public String sn() {
        return "064";
    }

    @Override
    public boolean hasClassAnnotationOnInterface() {
        return true;
    }

    @NotNull
    @Override
    public OriginMethodInInterface originMethodInInterface() {
        return OriginMethodInInterface.AbstractWithAnnotation;
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
        return OriginMethodInClass.WithoutAnnotation;
    }

    @Override
    public boolean hasFallbackInClass() {
        return false;
    }

    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }

}
