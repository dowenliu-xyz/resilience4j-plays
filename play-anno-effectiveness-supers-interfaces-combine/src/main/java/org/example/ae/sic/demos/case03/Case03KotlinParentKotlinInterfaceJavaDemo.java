package org.example.ae.sic.demos.case03;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.sic.biz.Greeting.doFallback;

@Component
public class Case03KotlinParentKotlinInterfaceJavaDemo extends KotlinParentForJava implements KotlinInterfaceForJava {
    @NotNull
    public String fallbackBySuper(@Nullable String name, @Nullable Throwable e) {
        return "bySuper:" + doFallback(name, e);
    }
}
