package org.example.ae.interfaces.jdk.demos;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.ae.interfaces.jdk.biz.DemoCase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.example.ae.interfaces.jdk.biz.Run.detectEffectiveness;
import static org.example.ae.interfaces.jdk.biz.Run.detectProxyType;

@ConditionalOnProperty(name = "run.only", havingValue = "case066", matchIfMissing = true)
@Component
@Slf4j
public class Case066Runner implements CommandLineRunner, Ordered {
    @Resource(name = "case066AnnotationBaseJavaInterfaceJavaDemo")
    private DemoCase annotationBaseJavaInterfaceJavaDemo;
    @Resource(name = "case066AnnotationBaseJavaInterfaceKotlinDemo")
    private DemoCase annotationBaseJavaInterfaceKotlinDemo;
    @Resource(name = "case066AnnotationBaseKotlinInterfaceJavaDemo")
    private DemoCase annotationBaseKotlinInterfaceJavaDemo;
    @Resource(name = "case066AnnotationBaseKotlinInterfaceKotlinDemo")
    private DemoCase annotationBaseKotlinInterfaceKotlinDemo;
    @Resource(name = "case066JavaBaseJavaInterfaceJavaDemo")
    private DemoCase javaBaseJavaInterfaceJavaDemo;
    @Resource(name = "case066JavaBaseJavaInterfaceKotlinDemo")
    private DemoCase javaBaseJavaInterfaceKotlinDemo;
    @Resource(name = "case066JavaBaseKotlinInterfaceJavaDemo")
    private DemoCase javaBaseKotlinInterfaceJavaDemo;
    @Resource(name = "case066JavaBaseKotlinInterfaceKotlinDemo")
    private DemoCase javaBaseKotlinInterfaceKotlinDemo;

    @Override
    public int getOrder() {
        return Integer.parseInt(annotationBaseJavaInterfaceJavaDemo.sn());
    }

    @Override
    public void run(String... args) {
        String proxyType = verifyProxyType();
        if (!"JdkDynamic".equals(proxyType)) {
            log.info("case 066 real proxy type is {}", proxyType);
        }
        log.info("case result: {},{}", detectCasesEffectiveness(), proxyType);
    }

    private String verifyProxyType() {
        String ajjProxyType = detectProxyType(annotationBaseJavaInterfaceJavaDemo);
        String ajkProxyType = detectProxyType(annotationBaseJavaInterfaceKotlinDemo);
        String akjProxyType = detectProxyType(annotationBaseKotlinInterfaceJavaDemo);
        String akkProxyType = detectProxyType(annotationBaseKotlinInterfaceKotlinDemo);
        String jjjProxyType = detectProxyType(javaBaseJavaInterfaceJavaDemo);
        String jjkProxyType = detectProxyType(javaBaseJavaInterfaceKotlinDemo);
        String jkjProxyType = detectProxyType(javaBaseKotlinInterfaceJavaDemo);
        String jkkProxyType = detectProxyType(javaBaseKotlinInterfaceKotlinDemo);
        if (Objects.equals(ajjProxyType, ajkProxyType) &&
                Objects.equals(ajkProxyType, akjProxyType) &&
                Objects.equals(akjProxyType, akkProxyType) &&
                Objects.equals(akkProxyType, jjjProxyType) &&
                Objects.equals(jjjProxyType, jjkProxyType) &&
                Objects.equals(jjkProxyType, jkjProxyType) &&
                Objects.equals(jkjProxyType, jkkProxyType)
        ) {
            return ajjProxyType;
        }
        throw new IllegalStateException("case proxyType not match");
    }

    private String detectCasesEffectiveness() {
        var ajjResult = detectEffectiveness(annotationBaseJavaInterfaceJavaDemo);
        var ajkResult = detectEffectiveness(annotationBaseJavaInterfaceKotlinDemo);
        var akjResult = detectEffectiveness(annotationBaseKotlinInterfaceJavaDemo);
        var akkResult = detectEffectiveness(annotationBaseKotlinInterfaceKotlinDemo);
        var jjjResult = detectEffectiveness(javaBaseJavaInterfaceJavaDemo);
        var jjkResult = detectEffectiveness(javaBaseJavaInterfaceKotlinDemo);
        var jkjResult = detectEffectiveness(javaBaseKotlinInterfaceJavaDemo);
        var jkkResult = detectEffectiveness(javaBaseKotlinInterfaceKotlinDemo);
        if (Objects.equals(ajjResult, ajkResult) &&
                Objects.equals(ajkResult, akjResult) &&
                Objects.equals(akjResult, akkResult) &&
                Objects.equals(akkResult, jjjResult) &&
                Objects.equals(jjjResult, jjkResult) &&
                Objects.equals(jjkResult, jkjResult) &&
                Objects.equals(jkjResult, jkkResult)
        ) {
            return ajjResult.csvLine();
        }
        throw new IllegalStateException("case effectiveness not match");
    }
}
