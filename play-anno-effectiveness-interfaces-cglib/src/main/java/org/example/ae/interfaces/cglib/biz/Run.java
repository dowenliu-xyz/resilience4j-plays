package org.example.ae.interfaces.cglib.biz;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.aop.support.AopUtils;

import java.util.Arrays;

@Slf4j
public class Run {
    @NotNull
    public static String detectProxyType(@NotNull DemoCase demoCase) {
        if (!AopUtils.isAopProxy(demoCase)) {
            return "None";
        }
        if (AopUtils.isCglibProxy(demoCase)) {
            return "Cglib";
        }
        if (AopUtils.isJdkDynamicProxy(demoCase)) {
            return "JdkDynamic";
        }
        return "Unknown";
    }

    @NotNull
    public static CaseEffectiveness detectEffectiveness(@NotNull DemoCase demoCase) {
        DemoCase.EffectiveAnnotation effectiveAnnotation;
        DemoCase.EffectiveFallback effectiveFallback;
        try {
            String result = demoCase.greeting("");
            String[] split = result.split(":");
            effectiveAnnotation = DemoCase.EffectiveAnnotation.valueOf(split[0]);
            effectiveFallback = DemoCase.EffectiveFallback.valueOf(split[1]);
        } catch (IllegalArgumentException e) {
            if (!"name should not be null or blank".equals(e.getMessage())) {
                throw e;
            }
            effectiveFallback = DemoCase.EffectiveFallback.None;
            boolean aopCut = Arrays.stream(e.getStackTrace()).anyMatch(ste ->
                    ste.getClassName().contains(".fallback.FallbackExecutor"));
            if (aopCut) {
                effectiveAnnotation = DemoCase.EffectiveAnnotation.SomeOne;
            } else {
                effectiveAnnotation = DemoCase.EffectiveAnnotation.None;
            }
        }
        return new CaseEffectiveness(
                demoCase.sn(),
                demoCase.hasClassAnnotationOnInterface() ? "Yes" : "No",
                demoCase.originMethodInInterface().name(),
                demoCase.fallbackInInterface().name(),
                demoCase.hasClassAnnotationOnClass() ? "Yes" : "No",
                demoCase.originMethodInClass().name(),
                demoCase.hasFallbackInClass() ? "Yes" : "No",
                effectiveAnnotation.name(),
                effectiveFallback.name()
        );
    }
}
