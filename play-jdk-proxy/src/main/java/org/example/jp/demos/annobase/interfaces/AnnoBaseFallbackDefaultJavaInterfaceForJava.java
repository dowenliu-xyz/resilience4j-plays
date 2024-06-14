package org.example.jp.demos.annobase.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.jp.biz.Biz.doFallback;

@SuppressWarnings("unused")
public interface AnnoBaseFallbackDefaultJavaInterfaceForJava {
    @NotNull
    String greeting(@Nullable String name);

    @NotNull
    default String fallback(@Nullable String name, @Nullable Throwable thr) {
        return doFallback(name, thr);
    }
}
