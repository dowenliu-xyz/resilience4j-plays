package org.example.ae.interfaces.cglib.demos;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.ae.interfaces.cglib.biz.DemoCase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.example.ae.interfaces.cglib.biz.Run.detectEffectiveness;
import static org.example.ae.interfaces.cglib.biz.Run.detectProxyType;

@ConditionalOnProperty(name = "run.only", havingValue = "case042", matchIfMissing = true)
@Component
@Slf4j
public class Case042Runner implements CommandLineRunner, Ordered {
    @Resource(name = "case042JavaInterfaceJavaDemo")
    private DemoCase javaInterfaceJavaDemo;
    @Resource(name = "case042JavaInterfaceKotlinDemo")
    private DemoCase javaInterfaceKotlinDemo;
    @Resource(name = "case042KotlinInterfaceJavaDemo")
    private DemoCase kotlinInterfaceJavaDemo;
    @Resource(name = "case042KotlinInterfaceKotlinDemo")
    private DemoCase kotlinInterfaceKotlinDemo;

    @Override
    public int getOrder() {
        return Integer.parseInt(javaInterfaceJavaDemo.sn());
    }

    @Override
    public void run(String... args) throws Exception {
        String proxyType = verifyProxyType();
        if (!"Cglib".equals(proxyType)) {
            log.info("case 042 real proxy type is {}", proxyType);
        }
        log.info("case result: {},{}", detectCasesEffectiveness(), proxyType);
    }

    private String verifyProxyType() {
        String jjProxyType = detectProxyType(javaInterfaceJavaDemo);
        String jkProxyType = detectProxyType(javaInterfaceKotlinDemo);
        String kjProxyType = detectProxyType(kotlinInterfaceJavaDemo);
        String kkProxyType = detectProxyType(kotlinInterfaceKotlinDemo);
        if (Objects.equals(jjProxyType, jkProxyType) && Objects.equals(jkProxyType, kjProxyType) && Objects.equals(kjProxyType, kkProxyType)) {
            return jjProxyType;
        }
        throw new IllegalStateException("case proxyType not match");
    }

    private String detectCasesEffectiveness() {
        var jjResult = detectEffectiveness(javaInterfaceJavaDemo);
        var jkResult = detectEffectiveness(javaInterfaceKotlinDemo);
        var kjResult = detectEffectiveness(kotlinInterfaceJavaDemo);
        var kkResult = detectEffectiveness(kotlinInterfaceKotlinDemo);
        if (Objects.equals(jjResult, jkResult) && Objects.equals(jkResult, kjResult) && Objects.equals(kjResult, kkResult)) {
            return jjResult.csvLine();
        }
        throw new IllegalStateException("case effectiveness not match");
    }
}
