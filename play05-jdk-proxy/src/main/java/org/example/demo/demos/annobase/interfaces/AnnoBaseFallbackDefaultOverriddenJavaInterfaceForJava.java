package org.example.demo.demos.annobase.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface AnnoBaseFallbackDefaultOverriddenJavaInterfaceForJava {
    @NotNull
    String greeting(@Nullable String name);

    @NotNull
    default String fallback(@Nullable String name, @Nullable Throwable thr) {
        return "";
    }
}
