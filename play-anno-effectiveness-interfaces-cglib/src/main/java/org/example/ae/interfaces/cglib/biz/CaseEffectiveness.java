package org.example.ae.interfaces.cglib.biz;

import org.jetbrains.annotations.NotNull;

public record CaseEffectiveness(
        @NotNull String sn,
        @NotNull String hasClassAnnotationOnInterface,
        @NotNull String originMethodInInterface,
        @NotNull String fallbackInInterface,
        @NotNull String hasClassAnnotationOnClass,
        @NotNull String originMethodInClass,
        @NotNull String hasFallbackInClass,
        @NotNull String EffectiveAnnotation,
        @NotNull String EffectiveFallback
) {
    @NotNull
    public String csvLine() {
        return String.join(",", sn, hasClassAnnotationOnInterface, originMethodInInterface,
                fallbackInInterface, hasClassAnnotationOnClass, originMethodInClass, hasFallbackInClass,
                EffectiveAnnotation, EffectiveFallback);
    }
}
