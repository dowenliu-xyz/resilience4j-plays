package org.example.ae.interfaces.cglib.biz;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DemoCase {
    @NotNull
    String sn();

    boolean hasClassAnnotationOnInterface();

    @NotNull
    OriginMethodInInterface originMethodInInterface();

    @NotNull
    FallbackInInterface fallbackInInterface();

    boolean hasClassAnnotationOnClass();

    @NotNull
    OriginMethodInClass originMethodInClass();

    boolean hasFallbackInClass();

    @NotNull
    String greeting(@Nullable String name);

    enum OriginMethodInInterface {
        DefaultWithAnnotation,
        DefaultWithoutAnnotation,
        AbstractWithAnnotation,
        AbstractWithoutAnnotation,
        None,
    }

    enum FallbackInInterface {
        Default,
        Abstract,
        None,
    }

    enum OriginMethodInClass {
        WithAnnotation,
        WithoutAnnotation,
        None,
    }

    enum EffectiveAnnotation {
        ClassAnnotationOnInterface,
        ClassAnnotationOnClass,
        MethodAnnotationInInterface,
        MethodAnnotationInClass,
        SomeOne,
        None,
    }

    enum EffectiveFallback {
        FallbackInInterface,
        FallbackInClass,
        None,
    }
}
