package org.example.ae.sic.demos.case02;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.sic.biz.Greeting.doFallback;

@Component
public class Case02JavaParentJavaInterfaceJavaDemo extends JavaParentForJava implements JavaInterfaceForJava {
    @NotNull
    public String fallbackBySuper(@Nullable String name, @Nullable Throwable e) {
        return "bySuper:" + doFallback(name, e);
    }

    @NotNull
    public String fallbackByInterface(@Nullable String name, @Nullable Throwable e) {
        return "byInterface:" + doFallback(name, e);
    }
}
