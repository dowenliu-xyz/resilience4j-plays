package org.example.demo.demos.javabase.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface JavaBaseJavaInterfaceForJava {
    @NotNull
    String greeting(@Nullable String name);

    @NotNull
    String fallback(@Nullable String name, @Nullable Throwable thr);
}
