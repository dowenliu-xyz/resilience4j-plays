package org.example.jp.demos.javabase.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface JavaBaseFallbackDefaultOverriddenJavaInterfaceForKotlin {
    @NotNull
    String greeting(@Nullable String name);

    @NotNull
    default String fallback(@Nullable String name, @Nullable Throwable thr) {
        return "";
    }
}
