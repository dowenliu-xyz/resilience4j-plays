// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.interfaces.jdk.biz.Greeting.doGreeting;

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
public class Case004AnnotationBaseKotlinInterfaceJavaDemo implements Case004AnnotationBaseKotlinInterfaceForJava {

    @NotNull
    @Override
    public String sn() {
        return "004";
    }

    @Override
    public boolean hasClassAnnotationOnInterface() {
        return true;
    }

    @NotNull
    @Override
    public OriginMethodInInterface originMethodInInterface() {
        return OriginMethodInInterface.DefaultWithAnnotation;
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
