package org.example.ae.sic.demos.case01;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.ae.sic.biz.Greeting.doFallback;

public class JavaParentForKotlin {
    @NotNull
    public String fallback(@Nullable String name, @Nullable Throwable e) {
        return "super:" + doFallback(name, e);
    }
}
