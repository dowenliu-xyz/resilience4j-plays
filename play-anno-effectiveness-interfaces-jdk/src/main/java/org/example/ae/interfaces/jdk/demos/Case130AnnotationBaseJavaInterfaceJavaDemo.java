// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;


@Component
public class Case130AnnotationBaseJavaInterfaceJavaDemo implements Case130AnnotationBaseJavaInterfaceForJava {

    @NotNull
    @Override
    public String sn() {
        return "130";
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
