package org.example.ae.basic;

import lombok.RequiredArgsConstructor;
import org.example.ae.basic.demos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Function;

import static org.example.ae.basic.biz.Greeting.FALLBACK_RESULT;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
    private final BasicClassAnnoJavaDemo basicClassAnnoJavaDemo;
    private final BasicClassAnnoKotlinDemo basicClassAnnoKotlinDemo;
    private final BasicMethodAnnoJavaDemo basicMethodAnnoJavaDemo;
    private final BasicMethodAnnoKotlinDemo basicMethodAnnoKotlinDemo;
    private final FinalMethodClassAnnoJavaDemo finalMethodClassAnnoJavaDemo;
    private final FinalMethodClassAnnoKotlinDemo finalMethodClassAnnoKotlinDemo;
    private final FinalMethodMethodAnnoJavaDemo finalMethodMethodAnnoJavaDemo;
    private final FinalMethodMethodAnnoKotlinDemo finalMethodMethodAnnoKotlinDemo;
    private final PrivateMethodClassAnnoJavaDemo privateMethodClassAnnoJavaDemo;
    private final PrivateMethodClassAnnoKotlinDemo privateMethodClassAnnoKotlinDemo;
    private final PrivateMethodMethodAnnoJavaDemo privateMethodMethodAnnoJavaDemo;
    private final PrivateMethodMethodAnnoKotlinDemo privateMethodMethodAnnoKotlinDemo;
    private final ProtectedMethodClassAnnoJavaDemo protectedMethodClassAnnoJavaDemo;
    private final ProtectedMethodClassAnnoKotlinDemo protectedMethodClassAnnoKotlinDemo;
    private final ProtectedMethodMethodAnnoJavaDemo protectedMethodMethodAnnoJavaDemo;
    private final ProtectedMethodMethodAnnoKotlinDemo protectedMethodMethodAnnoKotlinDemo;

    @Override
    public void run(String... args) throws Exception {
        // 无继承、实现关系，源方法与处理器都在同一类中。
        {
            // 类注解
            {
                expectFallback(basicClassAnnoJavaDemo::greeting);
                expectFallback(basicClassAnnoKotlinDemo::greeting);
            }
            // 方法注解
            {
                expectFallback(basicMethodAnnoJavaDemo::greeting);
                expectFallback(basicMethodAnnoKotlinDemo::greeting);
            }
            // final 类不能使用类注解和方法注解：AOP 不能增强 final 类，
            // 但如果当前类不会被 AOP 处理（如当前不是 SpringBoot 模块、没有 r4j aspect 依赖等），注解则不应报错

            // final 方法类注解和方法注解不生效：AOP不会增强 final 方法。但不会导致报错：
            // 类注解 + 方法注解！！！
            {
                expectAnnotationNotTakeEffect(finalMethodClassAnnoJavaDemo::greeting);
                expectAnnotationNotTakeEffect(finalMethodClassAnnoKotlinDemo::greeting);
                expectAnnotationNotTakeEffect(finalMethodMethodAnnoJavaDemo::greeting);
                expectAnnotationNotTakeEffect(finalMethodMethodAnnoKotlinDemo::greeting);
            }
            // private 方法不生效：AOP 不会增强 private 方法。
            {
                // 类上注解实际在 exportGreeting 方法上生效了，导致 fallback 生效。在 private greeting 方法上是没有生效的
                expectFallback(privateMethodClassAnnoJavaDemo::exportGreeting);
                expectFallback(privateMethodClassAnnoKotlinDemo::exportGreeting);
                expectAnnotationNotTakeEffect(privateMethodMethodAnnoJavaDemo::exportGreeting);
                expectAnnotationNotTakeEffect(privateMethodMethodAnnoKotlinDemo::exportGreeting);
            }
            // protected 方法生效，但要注解需要依赖注入自身
            {
                // 类上注解时，测试用例不能明确判断 fallback 发生在 protected greeting 方法上，还是 exportGreeting 方法上
                expectFallback(protectedMethodClassAnnoJavaDemo::exportGreeting);
                expectFallback(protectedMethodClassAnnoKotlinDemo::exportGreeting);
                expectFallback(protectedMethodMethodAnnoJavaDemo::exportGreeting);
                expectFallback(protectedMethodMethodAnnoKotlinDemo::exportGreeting);
            }
        }
    }

    private static void expectFallback(Function<String, String> function) {
        String result = function.apply("");
        if (!FALLBACK_RESULT.equals(result)) {
            throw new AssertionError("expect \"" + FALLBACK_RESULT + "\", but got \"" + result + "\"");
        }
    }

    private static void expectAnnotationNotTakeEffect(Function<String, String> function) {
        try {
            String result = function.apply("");
            throw new AssertionError("expect fallback does not take effect, but got \"" + result + "\"");
        } catch (IllegalArgumentException e) {
            if (!"name should not be null or blank".equals(e.getMessage())) {
                throw e;
            }
            if (Arrays.stream(e.getStackTrace())
                    .anyMatch((ste) -> ste.getClassName().startsWith("io.github.resilience4j.spring"))) {
                throw new AssertionError("expect aspect not take effect", e);
            }
        }
    }
}
