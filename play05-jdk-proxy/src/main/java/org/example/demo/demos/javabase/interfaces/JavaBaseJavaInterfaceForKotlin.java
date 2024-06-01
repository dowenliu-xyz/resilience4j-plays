package org.example.demo.demos.javabase.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JavaBaseJavaInterfaceForKotlin {
    @NotNull
    String greeting(@Nullable String name);

    @NotNull
    String fallback(@Nullable String name, @Nullable Throwable thr);
}
