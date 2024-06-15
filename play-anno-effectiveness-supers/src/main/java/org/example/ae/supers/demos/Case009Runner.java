package org.example.ae.supers.demos;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.ae.supers.biz.DemoCase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.example.ae.supers.biz.Run.detectEffectiveness;

@ConditionalOnProperty(name = "run.only", havingValue = "case009", matchIfMissing = true)
@Component
@Slf4j
public class Case009Runner implements CommandLineRunner, Ordered {
    @Resource(name = "case009JavaSuperJavaDemo")
    private DemoCase javaSuperJavaDemo;
    @Resource(name = "case009JavaSuperKotlinDemo")
    private DemoCase javaSuperKotlinDemo;
    @Resource(name = "case009KotlinSuperJavaDemo")
    private DemoCase kotlinSuperJavaDemo;
    @Resource(name = "case009KotlinSuperKotlinDemo")
    private DemoCase kotlinSuperKotlinDemo;

    @Override
    public int getOrder() {
        return Integer.parseInt(javaSuperJavaDemo.sn());
    }

    @Override
    public void run(String... args) {
        log.info("case result: {}", detectCasesEffectiveness());
    }

    private String detectCasesEffectiveness() {
        var jjResult = detectEffectiveness(javaSuperJavaDemo);
        var jkResult = detectEffectiveness(javaSuperKotlinDemo);
        var kjResult = detectEffectiveness(kotlinSuperJavaDemo);
        var kkResult = detectEffectiveness(kotlinSuperKotlinDemo);
        if (Objects.equals(jjResult, jkResult) && Objects.equals(jkResult, kjResult) && Objects.equals(kjResult, kkResult)) {
            return jjResult.csvLine();
        }
        throw new IllegalStateException("case effectiveness not match");
    }
}
