package org.example.demo;

import lombok.RequiredArgsConstructor;
import org.example.demo.demos.annobase.interfaces.AnnoBaseJavaInterfaceForJava;
import org.example.demo.demos.annobase.interfaces.AnnoBaseJavaInterfaceForKotlin;
import org.example.demo.demos.annobase.interfaces.AnnoBaseKotlinInterfaceForJava;
import org.example.demo.demos.annobase.interfaces.AnnoBaseKotlinInterfaceForKotlin;
import org.example.demo.demos.annobase.parents.AnnoBaseJavaParentJavaDemo;
import org.example.demo.demos.annobase.parents.AnnoBaseJavaParentKotlinDemo;
import org.example.demo.demos.annobase.parents.AnnoBaseKotlinParentJavaDemo;
import org.example.demo.demos.annobase.parents.AnnoBaseKotlinParentKotlinDemo;
import org.example.demo.demos.annobase.self.AnnoBaseSelfJavaDemo;
import org.example.demo.demos.annobase.self.AnnoBaseSelfKotlinDemo;
import org.example.demo.demos.javabase.interfaces.JavaBaseJavaInterfaceForJava;
import org.example.demo.demos.javabase.interfaces.JavaBaseJavaInterfaceForKotlin;
import org.example.demo.demos.javabase.interfaces.JavaBaseKotlinInterfaceForJava;
import org.example.demo.demos.javabase.interfaces.JavaBaseKotlinInterfaceForKotlin;
import org.example.demo.demos.javabase.parents.JavaBaseJavaParentJavaDemo;
import org.example.demo.demos.javabase.parents.JavaBaseJavaParentKotlinDemo;
import org.example.demo.demos.javabase.parents.JavaBaseKotlinParentJavaDemo;
import org.example.demo.demos.javabase.parents.JavaBaseKotlinParentKotlinDemo;
import org.example.demo.demos.javabase.self.JavaBaseSelfJavaDemo;
import org.example.demo.demos.javabase.self.JavaBaseSelfKotlinDemo;
import org.jetbrains.annotations.NotNull;
import org.springframework.aop.support.AopUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Function;

@SuppressWarnings("DuplicatedCode")
@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
    private final AnnoBaseSelfJavaDemo annoBaseSelfJavaDemo;
    private final JavaBaseSelfJavaDemo javaBaseSelfJavaDemo;
    private final AnnoBaseSelfKotlinDemo annoBaseSelfKotlinDemo;
    private final JavaBaseSelfKotlinDemo javaBaseSelfKotlinDemo;
    private final AnnoBaseJavaParentJavaDemo annoBaseJavaParentJavaDemo;
    private final AnnoBaseJavaParentKotlinDemo annoBaseJavaParentKotlinDemo;
    private final AnnoBaseKotlinParentJavaDemo annoBaseKotlinParentJavaDemo;
    private final AnnoBaseKotlinParentKotlinDemo annoBaseKotlinParentKotlinDemo;
    private final JavaBaseJavaParentJavaDemo javaBaseJavaParentJavaDemo;
    private final JavaBaseJavaParentKotlinDemo javaBaseJavaParentKotlinDemo;
    private final JavaBaseKotlinParentJavaDemo javaBaseKotlinParentJavaDemo;
    private final JavaBaseKotlinParentKotlinDemo javaBaseKotlinParentKotlinDemo;
    private final AnnoBaseJavaInterfaceForJava annoBaseJavaInterfaceForJava;
    private final AnnoBaseJavaInterfaceForKotlin annoBaseJavaInterfaceForKotlin;
    private final AnnoBaseKotlinInterfaceForJava annoBaseKotlinInterfaceForJava;
    private final AnnoBaseKotlinInterfaceForKotlin annoBaseKotlinInterfaceForKotlin;
    private final JavaBaseJavaInterfaceForJava javaBaseJavaInterfaceForJava;
    private final JavaBaseJavaInterfaceForKotlin javaBaseJavaInterfaceForKotlin;
    private final JavaBaseKotlinInterfaceForJava javaBaseKotlinInterfaceForJava;
    private final JavaBaseKotlinInterfaceForKotlin javaBaseKotlinInterfaceForKotlin;

    @Override
    public void run(String... args) {
        {
            expectProxyType(annoBaseSelfJavaDemo, ProxyType.CGLIB);
            expectFallbackTakeEffect(annoBaseSelfJavaDemo::greeting);
            expectProxyType(javaBaseSelfJavaDemo, ProxyType.CGLIB);
            expectFallbackTakeEffect(javaBaseSelfJavaDemo::greeting);
            expectProxyType(annoBaseSelfKotlinDemo, ProxyType.CGLIB);
            expectFallbackTakeEffect(annoBaseSelfKotlinDemo::greeting);
            expectProxyType(javaBaseSelfKotlinDemo, ProxyType.CGLIB);
            expectFallbackTakeEffect(javaBaseSelfKotlinDemo::greeting);
        }
        {
            expectProxyType(annoBaseJavaParentJavaDemo, ProxyType.CGLIB);
            expectFallbackTakeEffect(annoBaseJavaParentJavaDemo::greeting);
            expectProxyType(annoBaseJavaParentKotlinDemo, ProxyType.CGLIB);
            expectFallbackTakeEffect(annoBaseJavaParentKotlinDemo::greeting);
            expectProxyType(annoBaseKotlinParentJavaDemo, ProxyType.CGLIB);
            expectFallbackTakeEffect(annoBaseKotlinParentJavaDemo::greeting);
            expectProxyType(annoBaseKotlinParentKotlinDemo, ProxyType.CGLIB);
            expectFallbackTakeEffect(annoBaseKotlinParentKotlinDemo::greeting);
            expectProxyType(javaBaseJavaParentJavaDemo, ProxyType.CGLIB);
            expectFallbackTakeEffect(javaBaseJavaParentJavaDemo::greeting);
            expectProxyType(javaBaseJavaParentKotlinDemo, ProxyType.CGLIB);
            expectFallbackTakeEffect(javaBaseJavaParentKotlinDemo::greeting);
            expectProxyType(javaBaseKotlinParentJavaDemo, ProxyType.CGLIB);
            expectFallbackTakeEffect(javaBaseKotlinParentJavaDemo::greeting);
            expectProxyType(javaBaseKotlinParentKotlinDemo, ProxyType.CGLIB);
            expectFallbackTakeEffect(javaBaseKotlinParentKotlinDemo::greeting);
        }
        {
            expectProxyType(annoBaseJavaInterfaceForJava, ProxyType.JDK);
            expectAspectTakeEffectButFallbackNotTakeEffect(annoBaseJavaInterfaceForJava::greeting);
            expectProxyType(annoBaseJavaInterfaceForKotlin, ProxyType.JDK);
            expectAspectTakeEffectButFallbackNotTakeEffect(annoBaseJavaInterfaceForKotlin::greeting);
            expectProxyType(annoBaseKotlinInterfaceForJava, ProxyType.JDK);
            expectAspectTakeEffectButFallbackNotTakeEffect(annoBaseKotlinInterfaceForJava::greeting);
            expectProxyType(annoBaseKotlinInterfaceForKotlin, ProxyType.JDK);
            expectAspectTakeEffectButFallbackNotTakeEffect(annoBaseKotlinInterfaceForKotlin::greeting);
            expectProxyType(javaBaseJavaInterfaceForJava, ProxyType.JDK);
            expectAspectTakeEffectButFallbackNotTakeEffect(javaBaseJavaInterfaceForJava::greeting);
            expectProxyType(javaBaseJavaInterfaceForKotlin, ProxyType.JDK);
            expectAspectTakeEffectButFallbackNotTakeEffect(javaBaseJavaInterfaceForKotlin::greeting);
            expectProxyType(javaBaseKotlinInterfaceForJava, ProxyType.JDK);
            expectAspectTakeEffectButFallbackNotTakeEffect(javaBaseKotlinInterfaceForJava::greeting);
            expectProxyType(javaBaseKotlinInterfaceForKotlin, ProxyType.JDK);
            expectAspectTakeEffectButFallbackNotTakeEffect(javaBaseKotlinInterfaceForKotlin::greeting);
        }
    }

    private static void expectProxyType(@NotNull Object object, @NotNull ProxyType proxyType) {
        switch (proxyType) {
            case NONE -> {
                if (AopUtils.isAopProxy(object)) {
                    throw new AssertionError("expect not a proxy, but got: " + object.getClass().getName());
                }
            }
            case JDK -> {
                if (!AopUtils.isJdkDynamicProxy(object)) {
                    throw new AssertionError("expect JDK dynamic proxy, but got: " + object.getClass().getName());
                }
            }
            case CGLIB -> {
                if (!AopUtils.isCglibProxy(object)) {
                    throw new AssertionError("expect CGLIB proxy, but got: " + object.getClass().getName());
                }
            }
        }
    }

    private static void expectFallbackTakeEffect(Function<String, String> function) {
        String result = function.apply("");
        if ("fallback".equals(result)) return;
        throw new AssertionError("expect \"fallback\", but got: \"" + result + "\"");
    }

    private static void expectAspectTakeEffectButFallbackNotTakeEffect(Function<String, String> function) {
        try {
            String result = function.apply("");
            if ("fallback".equals(result)) {
                throw new AssertionError("expect no fallback, but it does.");
            }
        } catch (Throwable e) {
            if (Arrays.stream(e.getStackTrace()).noneMatch(ste ->
                    ste.getClassName().startsWith("io.github.resilience4j.spring"))) {
                throw e;
            }
            if ("object is not an instance of declaring class".equals(e.getMessage())) return;
            throw e;
        }
    }
}
