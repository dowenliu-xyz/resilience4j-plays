// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos;

import org.example.ae.supers.biz.DemoCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.ae.supers.biz.DemoCase.EffectiveAnnotation.*;
import static org.example.ae.supers.biz.DemoCase.EffectiveFallback.FallbackInSuper;
import static org.example.ae.supers.biz.Greeting.doFallback;
import static org.example.ae.supers.biz.Greeting.doGreeting;

public abstract class Case139JavaSuperForKotlin implements DemoCase {

    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return "super:" + doGreeting(name);
    }

    @SuppressWarnings("unused")
    @NotNull
    public String superClassFallback(@Nullable String name, @Nullable Throwable thr) {
        return ClassAnnotationOnSuper + ":" + FallbackInSuper + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    public String superMethodFallback(@Nullable String name, @Nullable Throwable thr) {
        return MethodAnnotationInSuper + ":" + FallbackInSuper + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    public String classFallback(@Nullable String name, @Nullable Throwable thr) {
        return ClassAnnotationOnSub + ":" + FallbackInSuper + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    public String methodFallback(@Nullable String name, @Nullable Throwable thr) {
        return MethodAnnotationInSub + ":" + FallbackInSuper + ":" + doFallback(name, thr);
    }

}
