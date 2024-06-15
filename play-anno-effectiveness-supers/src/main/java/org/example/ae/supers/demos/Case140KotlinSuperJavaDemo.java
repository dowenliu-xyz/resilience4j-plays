// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.supers.biz.Greeting.doGreeting;

@Component
public class Case140KotlinSuperJavaDemo extends Case140KotlinSuperForJava {

    @NotNull
    @Override
    public String sn() {
        return "140";
    }

    @Override
    public boolean hasClassAnnotationOnSuper() {
        return false;
    }

    @NotNull
    @Override
    public OriginMethodInSuper originMethodInSuper() {
        return OriginMethodInSuper.NormalWithoutAnnotation;
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
        return false;
    }

    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }

}
