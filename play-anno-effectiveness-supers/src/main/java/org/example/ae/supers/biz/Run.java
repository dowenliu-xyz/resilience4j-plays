package org.example.ae.supers.biz;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

@Slf4j
public class Run {
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
            if ("name should not be null or blank".equals(e.getMessage())) {
                effectiveFallback = DemoCase.EffectiveFallback.None;
            } else {
                throw e;
            }
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
                demoCase.hasClassAnnotationOnSuper() ? "Yes" : "No",
                demoCase.originMethodInSuper().name(),
                demoCase.fallbackInSuper().name(),
                demoCase.hasClassAnnotationOnSub() ? "Yes" : "No",
                demoCase.originMethodInSub().name(),
                demoCase.hasFallbackInSub() ? "Yes" : "No",
                effectiveAnnotation.name(),
                effectiveFallback.name()
        );
    }
}
