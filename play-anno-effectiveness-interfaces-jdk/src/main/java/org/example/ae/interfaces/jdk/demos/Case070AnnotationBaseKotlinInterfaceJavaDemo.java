// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.interfaces.jdk.biz.DemoCase.EffectiveAnnotation.*;
import static org.example.ae.interfaces.jdk.biz.DemoCase.EffectiveFallback.FallbackInClass;
import static org.example.ae.interfaces.jdk.biz.Greeting.doFallback;
import static org.example.ae.interfaces.jdk.biz.Greeting.doGreeting;

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
public class Case070AnnotationBaseKotlinInterfaceJavaDemo implements Case070AnnotationBaseKotlinInterfaceForJava {

    @NotNull
    @Override
    public String sn() {
        return "070";
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
        return FallbackInInterface.Abstract;
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
        return true;
    }

    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }

    @SuppressWarnings("unused")
    @NotNull
    @Override
    public String interfaceClassFallback(@Nullable String name, @Nullable Throwable thr) {
        return ClassAnnotationOnInterface + ":" + FallbackInClass + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    @Override
    public String interfaceMethodFallback(@Nullable String name, @Nullable Throwable thr) {
        return MethodAnnotationInInterface + ":" + FallbackInClass + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    @Override
    public String classFallback(@Nullable String name, @Nullable Throwable thr) {
        return ClassAnnotationOnClass + ":" + FallbackInClass + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    @Override
    public String methodFallback(@Nullable String name, @Nullable Throwable thr) {
        return MethodAnnotationInClass + ":" + FallbackInClass + ":" + doFallback(name, thr);
    }

}
