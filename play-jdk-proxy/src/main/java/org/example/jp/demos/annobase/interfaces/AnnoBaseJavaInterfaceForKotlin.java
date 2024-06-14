package org.example.jp.demos.annobase.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface AnnoBaseJavaInterfaceForKotlin {
    @NotNull
    String greeting(@Nullable String name);

    @NotNull
    String fallback(@Nullable String name, @Nullable Throwable thr);
}
