// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.supers.biz.DemoCase.EffectiveAnnotation.*;
import static org.example.ae.supers.biz.DemoCase.EffectiveFallback.FallbackInSub;
import static org.example.ae.supers.biz.Greeting.doFallback;
import static org.example.ae.supers.biz.Greeting.doGreeting;

@Component
public class Case009KotlinSuperJavaDemo extends Case009KotlinSuperForJava {

    @NotNull
    @Override
    public String sn() {
        return "009";
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
        return FallbackInSuper.Normal;
    }

    @Override
    public boolean hasClassAnnotationOnSub() {
        return false;
    }

    @NotNull
    @Override
    public OriginMethodInSub originMethodInSub() {
        return OriginMethodInSub.WithoutAnnotation;
    }

    @Override
    public boolean hasFallbackInSub() {
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
    public String superClassFallback(@Nullable String name, @Nullable Throwable thr) {
        return ClassAnnotationOnSuper + ":" + FallbackInSub + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    @Override
    public String superMethodFallback(@Nullable String name, @Nullable Throwable thr) {
        return MethodAnnotationInSuper + ":" + FallbackInSub + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    @Override
    public String classFallback(@Nullable String name, @Nullable Throwable thr) {
        return ClassAnnotationOnSub + ":" + FallbackInSub + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    @Override
    public String methodFallback(@Nullable String name, @Nullable Throwable thr) {
        return MethodAnnotationInSub + ":" + FallbackInSub + ":" + doFallback(name, thr);
    }

}
