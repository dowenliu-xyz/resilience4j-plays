// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;


@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
public class Case154JavaBaseJavaInterfaceJavaDemo implements Case154JavaBaseJavaInterfaceForJava {

    @NotNull
    @Override
    public String sn() {
        return "154";
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
        return FallbackInInterface.None;
    }

    @Override
    public boolean hasClassAnnotationOnClass() {
        return true;
    }

    @NotNull
    @Override
    public OriginMethodInClass originMethodInClass() {
        return OriginMethodInClass.None;
    }

    @Override
    public boolean hasFallbackInClass() {
        return false;
    }

}