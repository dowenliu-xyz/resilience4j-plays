// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;


@Component
public class Case160JavaInterfaceJavaDemo implements Case160JavaInterfaceForJava {

    @NotNull
    @Override
    public String sn() {
        return "160";
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