// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos;

import org.example.ae.interfaces.jdk.biz.DemoCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public interface Case192AnnotationBaseJavaInterfaceForJava extends DemoCase {

    @SuppressWarnings("unused")
    @NotNull
    String interfaceClassFallback(@Nullable String name, @Nullable Throwable thr);

    @SuppressWarnings("unused")
    @NotNull
    String interfaceMethodFallback(@Nullable String name, @Nullable Throwable thr);

    @SuppressWarnings("unused")
    @NotNull
    String classFallback(@Nullable String name, @Nullable Throwable thr);

    @SuppressWarnings("unused")
    @NotNull
    String methodFallback(@Nullable String name, @Nullable Throwable thr);

}
