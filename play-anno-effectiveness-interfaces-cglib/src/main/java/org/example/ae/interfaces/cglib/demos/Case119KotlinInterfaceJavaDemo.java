// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.interfaces.cglib.biz.DemoCase.EffectiveAnnotation.*;
import static org.example.ae.interfaces.cglib.biz.DemoCase.EffectiveFallback.FallbackInClass;
import static org.example.ae.interfaces.cglib.biz.Greeting.doFallback;
import static org.example.ae.interfaces.cglib.biz.Greeting.doGreeting;

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
public class Case119KotlinInterfaceJavaDemo implements Case119JavaInterfaceForKotlin {

    @NotNull
    @Override
    public String sn() {
        return "119";
    }

    @Override
    public boolean hasClassAnnotationOnInterface() {
        return false;
    }

    @NotNull
    @Override
    public OriginMethodInInterface originMethodInInterface() {
        return OriginMethodInInterface.DefaultWithAnnotation;
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
        return OriginMethodInClass.WithAnnotation;
    }

    @Override
    public boolean hasFallbackInClass() {
        return true;
    }

    @CircuitBreaker(name = "demo", fallbackMethod = "methodFallback")
    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }

    @SuppressWarnings("unused")
    @NotNull
    public String interfaceClassFallback(@Nullable String name, @Nullable Throwable thr) {
        return ClassAnnotationOnInterface + ":" + FallbackInClass + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    public String interfaceMethodFallback(@Nullable String name, @Nullable Throwable thr) {
        return MethodAnnotationInInterface + ":" + FallbackInClass + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    public String classFallback(@Nullable String name, @Nullable Throwable thr) {
        return ClassAnnotationOnClass + ":" + FallbackInClass + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    public String methodFallback(@Nullable String name, @Nullable Throwable thr) {
        return MethodAnnotationInClass + ":" + FallbackInClass + ":" + doFallback(name, thr);
    }

}
