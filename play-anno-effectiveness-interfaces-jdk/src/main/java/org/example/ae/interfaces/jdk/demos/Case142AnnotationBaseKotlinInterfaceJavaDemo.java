// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;


@Component
public class Case142AnnotationBaseKotlinInterfaceJavaDemo implements Case142AnnotationBaseKotlinInterfaceForJava {

    @NotNull
    @Override
    public String sn() {
        return "142";
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
        return false;
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
