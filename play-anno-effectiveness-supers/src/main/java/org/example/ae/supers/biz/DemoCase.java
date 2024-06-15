package org.example.ae.supers.biz;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DemoCase {
    @NotNull
    String sn();

    boolean hasClassAnnotationOnSuper();

    @NotNull
    OriginMethodInSuper originMethodInSuper();

    @NotNull
    FallbackInSuper fallbackInSuper();

    boolean hasClassAnnotationOnSub();

    @NotNull
    OriginMethodInSub originMethodInSub();

    boolean hasFallbackInSub();

    @NotNull
    String greeting(@Nullable String name);

    enum OriginMethodInSuper {
        NormalWithAnnotation,
        NormalWithoutAnnotation,
        AbstractWithAnnotation,
        AbstractWithoutAnnotation,
        None,
    }

    enum FallbackInSuper {
        Normal,
        Abstract,
        None,
    }

    enum OriginMethodInSub {
        WithAnnotation,
        WithoutAnnotation,
        None,
    }

    enum EffectiveAnnotation {
        ClassAnnotationOnSuper,
        ClassAnnotationOnSub,
        MethodAnnotationInSuper,
        MethodAnnotationInSub,
        SomeOne,
        None,
    }

    enum EffectiveFallback {
        FallbackInSuper,
        FallbackInSub,
        None,
    }
}
