package org.example.jp.demos.javabase.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.jp.biz.Biz.doFallback;

@SuppressWarnings("unused")
public interface JavaBaseFallbackDefaultJavaInterfaceForKotlin {
    @NotNull
    String greeting(@Nullable String name);

    @NotNull
    default String fallback(@Nullable String name, @Nullable Throwable thr) {
        return doFallback(name, thr);
    }
}
