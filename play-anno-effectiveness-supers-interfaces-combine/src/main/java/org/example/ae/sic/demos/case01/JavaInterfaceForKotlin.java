package org.example.ae.sic.demos.case01;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.ae.sic.biz.Greeting.doFallback;

public interface JavaInterfaceForKotlin {
    @NotNull
    default String fallback(@Nullable String name, @Nullable Throwable e) {
        return "interface:" + doFallback(name, e);
    }
}
