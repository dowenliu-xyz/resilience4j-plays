// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;


@Component
public class Case060KotlinSuperJavaDemo extends Case060KotlinSuperForJava {

    @NotNull
    @Override
    public String sn() {
        return "060";
    }

    @Override
    public boolean hasClassAnnotationOnSuper() {
        return true;
    }

    @NotNull
    @Override
    public OriginMethodInSuper originMethodInSuper() {
        return OriginMethodInSuper.NormalWithoutAnnotation;
    }

    @NotNull
    @Override
    public FallbackInSuper fallbackInSuper() {
        return FallbackInSuper.None;
    }

    @Override
    public boolean hasClassAnnotationOnSub() {
        return false;
    }

    @NotNull
    @Override
    public OriginMethodInSub originMethodInSub() {
        return OriginMethodInSub.None;
    }

    @Override
    public boolean hasFallbackInSub() {
        return false;
    }

}
