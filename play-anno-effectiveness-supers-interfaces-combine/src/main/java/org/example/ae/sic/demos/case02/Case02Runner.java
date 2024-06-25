package org.example.ae.sic.demos.case02;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@SuppressWarnings("GrazieInspection")
@ConditionalOnProperty(name = "run.only", havingValue = "case02", matchIfMissing = true)
@Component
@Order(2)
@RequiredArgsConstructor
@Slf4j
public class Case02Runner implements CommandLineRunner {
    private final Case02JavaParentJavaInterfaceJavaDemo case02JavaParentJavaInterfaceJavaDemo;
    private final Case02JavaParentKotlinInterfaceJavaDemo case02JavaParentKotlinInterfaceJavaDemo;
    private final Case02KotlinParentJavaInterfaceJavaDemo case02KotlinParentJavaInterfaceJavaDemo;
    private final Case02KotlinParentKotlinInterfaceJavaDemo case02KotlinParentKotlinInterfaceJavaDemo;

    @Override
    public void run(String... args) {
        // TODO 行为很奇怪。把异常栈打出来，可以看出执行的是 parent 中的方法，但执行的 fallback 是由 interface 中 default 方法指定的。这看起来是个 bug。需要 issue 提给 r4j
        //      另外 case03 的实验证明，如果 interface 中 default 方法没有注解，会导致 AOP 完全切不到方法、 AOP 失效。
        log.info("javaParentJavaInterfaceJavaDemo.greeting('') = {}", case02JavaParentJavaInterfaceJavaDemo.greeting(""));
        log.info("javaParentKotlinInterfaceJavaDemo.greeting('') = {}", case02JavaParentKotlinInterfaceJavaDemo.greeting(""));
        log.info("kotlinParentJavaInterfaceJavaDemo.greeting('') = {}", case02KotlinParentJavaInterfaceJavaDemo.greeting(""));
        log.info("kotlinParentKotlinInterfaceJavaDemo.greeting('') = {}", case02KotlinParentKotlinInterfaceJavaDemo.greeting(""));
    }
}
