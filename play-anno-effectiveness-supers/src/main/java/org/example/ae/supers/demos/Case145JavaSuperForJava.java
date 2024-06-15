// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos;

import org.example.ae.supers.biz.DemoCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.ae.supers.biz.Greeting.doGreeting;

public abstract class Case145JavaSuperForJava implements DemoCase {

    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return "super:" + doGreeting(name);
    }

    @SuppressWarnings("unused")
    @NotNull
    public abstract String superClassFallback(@Nullable String name, @Nullable Throwable thr);

    @SuppressWarnings("unused")
    @NotNull
    public abstract String superMethodFallback(@Nullable String name, @Nullable Throwable thr);

    @SuppressWarnings("unused")
    @NotNull
    public abstract String classFallback(@Nullable String name, @Nullable Throwable thr);

    @SuppressWarnings("unused")
    @NotNull
    public abstract String methodFallback(@Nullable String name, @Nullable Throwable thr);

}
