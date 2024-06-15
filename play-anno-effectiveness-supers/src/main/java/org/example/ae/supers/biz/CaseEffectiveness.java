package org.example.ae.supers.biz;

import org.jetbrains.annotations.NotNull;

public record CaseEffectiveness(
        @NotNull String sn,
        @NotNull String hasClassAnnotationOnSuper,
        @NotNull String originMethodInSuper,
        @NotNull String fallbackInSuper,
        @NotNull String hasClassAnnotationOnSub,
        @NotNull String originMethodInSub,
        @NotNull String hasFallbackInSub,
        @NotNull String EffectiveAnnotation,
        @NotNull String EffectiveFallback
) {
    @NotNull
    public String csvLine() {
        return String.join(",", sn, hasClassAnnotationOnSuper, originMethodInSuper, fallbackInSuper,
                hasClassAnnotationOnSub, originMethodInSub, hasFallbackInSub, EffectiveAnnotation, EffectiveFallback);
    }
}
