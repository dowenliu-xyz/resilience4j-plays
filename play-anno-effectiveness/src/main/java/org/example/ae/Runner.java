package org.example.ae;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.example.ae.demos.basic.*;
import org.example.ae.demos.interfaces.*;
import org.example.ae.demos.parents.FallbackLocation;
import org.example.ae.demos.parents.TakeEffectAnno;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.example.ae.biz.Greeting.FALLBACK_RESULT;
import static org.example.ae.demos.parents.FallbackLocation.*;
import static org.example.ae.demos.parents.FallbackLocation.None;
import static org.example.ae.demos.parents.TakeEffectAnno.*;

@SuppressWarnings("DuplicatedCode")
@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner, ApplicationContextAware {
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

    private final InterfaceClassAnnoJavaInterfaceJavaDemo interfaceClassAnnoJavaInterfaceJavaDemo;
    private final InterfaceClassAnnoJavaInterfaceKotlinDemo interfaceClassAnnoJavaInterfaceKotlinDemo;
    private final InterfaceClassAnnoKotlinInterfaceJavaDemo interfaceClassAnnoKotlinInterfaceJavaDemo;
    private final InterfaceClassAnnoKotlinInterfaceKotlinDemo interfaceClassAnnoKotlinInterfaceKotlinDemo;

    private final InterfaceOriginMethodMethodAnnoJavaInterfaceJavaDemo interfaceOriginMethodMethodAnnoJavaInterfaceJavaDemo;
    private final InterfaceOriginMethodMethodAnnoJavaInterfaceKotlinDemo interfaceOriginMethodMethodAnnoJavaInterfaceKotlinDemo;
    private final InterfaceOriginMethodMethodAnnoKotlinInterfaceJavaDemo interfaceOriginMethodMethodAnnoKotlinInterfaceJavaDemo;
    private final InterfaceOriginMethodMethodAnnoKotlinInterfaceKotlinDemo interfaceOriginMethodMethodAnnoKotlinInterfaceKotlinDemo;

    private final InterfaceOriginMethodDefaultMethodAnnoJavaInterfaceJavaDemo interfaceOriginMethodDefaultMethodAnnoJavaInterfaceJavaDemo;
    private final InterfaceOriginMethodDefaultMethodAnnoJavaInterfaceKotlinDemo interfaceOriginMethodDefaultMethodAnnoJavaInterfaceKotlinDemo;
    private final InterfaceOriginMethodDefaultMethodAnnoKotlinInterfaceJavaDemo interfaceOriginMethodDefaultMethodAnnoKotlinInterfaceJavaDemo;
    private final InterfaceOriginMethodDefaultMethodAnnoKotlinInterfaceKotlinDemo interfaceOriginMethodDefaultMethodAnnoKotlinInterfaceKotlinDemo;

    private final InterfaceOriginMethodOverriddenDefaultMethodAnnoJavaInterfaceJavaDemo interfaceOriginMethodOverriddenDefaultMethodAnnoJavaInterfaceJavaDemo;
    private final InterfaceOriginMethodOverriddenDefaultMethodAnnoJavaInterfaceKotlinDemo interfaceOriginMethodOverriddenDefaultMethodAnnoJavaInterfaceKotlinDemo;
    private final InterfaceOriginMethodOverriddenDefaultMethodAnnoKotlinInterfaceJavaDemo interfaceOriginMethodOverriddenDefaultMethodAnnoKotlinInterfaceJavaDemo;
    private final InterfaceOriginMethodOverriddenDefaultMethodAnnoKotlinInterfaceKotlinDemo interfaceOriginMethodOverriddenDefaultMethodAnnoKotlinInterfaceKotlinDemo;

    private final InterfaceOriginMethodDefaultMethodAnnoFallbackJavaInterfaceJavaDemo interfaceOriginMethodDefaultMethodAnnoFallbackJavaInterfaceJavaDemo;
    private final InterfaceOriginMethodDefaultMethodAnnoFallbackJavaInterfaceKotlinDemo interfaceOriginMethodDefaultMethodAnnoFallbackJavaInterfaceKotlinDemo;
    private final InterfaceOriginMethodDefaultMethodAnnoFallbackKotlinInterfaceJavaDemo interfaceOriginMethodDefaultMethodAnnoFallbackKotlinInterfaceJavaDemo;
    private final InterfaceOriginMethodDefaultMethodAnnoFallbackKotlinInterfaceKotlinDemo interfaceOriginMethodDefaultMethodAnnoFallbackKotlinInterfaceKotlinDemo;

    private final InterfaceOriginMethodDefaultMethodAnnoFallbackOverriddenJavaInterfaceJavaDemo interfaceOriginMethodDefaultMethodAnnoFallbackOverriddenJavaInterfaceJavaDemo;
    private final InterfaceOriginMethodDefaultMethodAnnoFallbackOverriddenJavaInterfaceKotlinDemo interfaceOriginMethodDefaultMethodAnnoFallbackOverriddenJavaInterfaceKotlinDemo;
    private final InterfaceOriginMethodDefaultMethodAnnoFallbackOverriddenKotlinInterfaceJavaDemo interfaceOriginMethodDefaultMethodAnnoFallbackOverriddenKotlinInterfaceJavaDemo;
    private final InterfaceOriginMethodDefaultMethodAnnoFallbackOverriddenKotlinInterfaceKotlinDemo interfaceOriginMethodDefaultMethodAnnoFallbackOverriddenKotlinInterfaceKotlinDemo;

    private final InterfaceNoOriginFallbackClassAnnoJavaInterfaceJavaDemo interfaceNoOriginFallbackClassAnnoJavaInterfaceJavaDemo;
    private final InterfaceNoOriginFallbackClassAnnoJavaInterfaceKotlinDemo interfaceNoOriginFallbackClassAnnoJavaInterfaceKotlinDemo;
    private final InterfaceNoOriginFallbackClassAnnoKotlinInterfaceJavaDemo interfaceNoOriginFallbackClassAnnoKotlinInterfaceJavaDemo;
    private final InterfaceNoOriginFallbackClassAnnoKotlinInterfaceKotlinDemo interfaceNoOriginFallbackClassAnnoKotlinInterfaceKotlinDemo;
    private final InterfaceNoOriginFallbackMethodAnnoJavaInterfaceJavaDemo interfaceNoOriginFallbackMethodAnnoJavaInterfaceJavaDemo;
    private final InterfaceNoOriginFallbackMethodAnnoJavaInterfaceKotlinDemo interfaceNoOriginFallbackMethodAnnoJavaInterfaceKotlinDemo;
    private final InterfaceNoOriginFallbackMethodAnnoKotlinInterfaceJavaDemo interfaceNoOriginFallbackMethodAnnoKotlinInterfaceJavaDemo;
    private final InterfaceNoOriginFallbackMethodAnnoKotlinInterfaceKotlinDemo interfaceNoOriginFallbackMethodAnnoKotlinInterfaceKotlinDemo;

    private final InterfaceNoOriginFallbackOverriddenClassAnnoJavaInterfaceJavaDemo interfaceNoOriginFallbackOverriddenClassAnnoJavaInterfaceJavaDemo;
    private final InterfaceNoOriginFallbackOverriddenClassAnnoJavaInterfaceKotlinDemo interfaceNoOriginFallbackOverriddenClassAnnoJavaInterfaceKotlinDemo;
    private final InterfaceNoOriginFallbackOverriddenClassAnnoKotlinInterfaceJavaDemo interfaceNoOriginFallbackOverriddenClassAnnoKotlinInterfaceJavaDemo;
    private final InterfaceNoOriginFallbackOverriddenClassAnnoKotlinInterfaceKotlinDemo interfaceNoOriginFallbackOverriddenClassAnnoKotlinInterfaceKotlinDemo;

    private final InterfaceNoOriginFallbackOverriddenMethodAnnoJavaInterfaceJavaDemo interfaceNoOriginFallbackOverriddenMethodAnnoJavaInterfaceJavaDemo;
    private final InterfaceNoOriginFallbackOverriddenMethodAnnoJavaInterfaceKotlinDemo interfaceNoOriginFallbackOverriddenMethodAnnoJavaInterfaceKotlinDemo;
    private final InterfaceNoOriginFallbackOverriddenMethodAnnoKotlinInterfaceJavaDemo interfaceNoOriginFallbackOverriddenMethodAnnoKotlinInterfaceJavaDemo;
    private final InterfaceNoOriginFallbackOverriddenMethodAnnoKotlinInterfaceKotlinDemo interfaceNoOriginFallbackOverriddenMethodAnnoKotlinInterfaceKotlinDemo;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private record ParentCase(
            @NotNull String sn,
            @Nullable TakeEffectAnno anno,
            @NotNull FallbackLocation location
    ) {
    }

    private List<ParentCase> provideParentCases() {
        List<ParentCase> cases = new ArrayList<>(200);
        cases.add(new ParentCase("001", SubMethodAnno, Sub));
        cases.add(new ParentCase("002", SubMethodAnno, Super));
        cases.add(new ParentCase("003", SubMethodAnno, Sub));
        cases.add(new ParentCase("004", SubMethodAnno, None));
        cases.add(new ParentCase("005", SubClassAnno, Sub));
        cases.add(new ParentCase("006", SubClassAnno, Super));
        cases.add(new ParentCase("007", SubClassAnno, Sub));
        cases.add(new ParentCase("008", SubClassAnno, None));
        cases.add(new ParentCase("009", SuperMethodAnno, Sub));
        cases.add(new ParentCase("010", SuperMethodAnno, Super));
        cases.add(new ParentCase("011", SuperMethodAnno, Sub));
        cases.add(new ParentCase("012", SuperMethodAnno, None));
        cases.add(new ParentCase("013", SubMethodAnno, Sub));
        cases.add(new ParentCase("014", SubMethodAnno, Super));
        cases.add(new ParentCase("015", SubMethodAnno, Sub));
        cases.add(new ParentCase("016", SubMethodAnno, None));
        cases.add(new ParentCase("017", SubClassAnno, Sub));
        cases.add(new ParentCase("018", SubClassAnno, Super));
        cases.add(new ParentCase("019", SubClassAnno, Sub));
        cases.add(new ParentCase("020", SubClassAnno, None));
        // TODO 源方法位于父类，没有重写。子类有类注解。子类的类注解生效
        cases.add(new ParentCase("021", SubClassAnno, Sub));
        cases.add(new ParentCase("022", SubClassAnno, Super));
        cases.add(new ParentCase("023", SubClassAnno, Sub));
        cases.add(new ParentCase("024", SubClassAnno, None));
        cases.add(new ParentCase("025", SubMethodAnno, Sub));
        cases.add(new ParentCase("026", SubMethodAnno, Super));
        cases.add(new ParentCase("027", SubMethodAnno, Sub));
        cases.add(new ParentCase("028", SubMethodAnno, None));
        cases.add(new ParentCase("029", SubClassAnno, Sub));
        cases.add(new ParentCase("030", SubClassAnno, Super));
        cases.add(new ParentCase("031", SubClassAnno, Sub));
        cases.add(new ParentCase("032", SubClassAnno, None));
        cases.add(new ParentCase("034", SubMethodAnno, Sub));
        cases.add(new ParentCase("035", SubMethodAnno, Super));
        cases.add(new ParentCase("036", SubMethodAnno, Sub));
        cases.add(new ParentCase("037", SubMethodAnno, None));
        // TODO 父类有类注解和方法注解。子类重写源方法，即没有方法注解也没有类注解。虽然父类有类注解，但不会生效：
        //      AOP 直接就切不到这个方法。所以也没有什么后续查找类注解的事儿了。
        cases.add(new ParentCase("038", null, None));
        cases.add(new ParentCase("039", null, None));
        cases.add(new ParentCase("040", null, None));
        cases.add(new ParentCase("041", null, None));
        cases.add(new ParentCase("042", SuperMethodAnno, Sub));
        cases.add(new ParentCase("043", SuperMethodAnno, Super));
        cases.add(new ParentCase("044", SuperMethodAnno, Sub));
        cases.add(new ParentCase("045", SuperMethodAnno, None));
        cases.add(new ParentCase("046", SubMethodAnno, Sub));
        cases.add(new ParentCase("047", SubMethodAnno, Super));
        cases.add(new ParentCase("048", SubMethodAnno, Sub));
        cases.add(new ParentCase("049", SubMethodAnno, None));
        // TODO 源方法位于子类，没有方法注解，有重写。子类没有类注解。虽然父类有类注解，但不会生效：
        //      AOP 直接就切不到这个方法。所以也没有什么后续查找类注解的事儿了。
        cases.add(new ParentCase("050", null, None));
        cases.add(new ParentCase("051", null, None));
        cases.add(new ParentCase("052", null, None));
        cases.add(new ParentCase("053", null, None));
        // TODO 仅父类有类注解，源方法也只有父类定义没有重写。还是没有注解生效。
        //      AOP 有切到，所以会尝试从 target （也就是 bean 对象）上尝试找类注解，但因为注解没有元注解 @Inherited，所以不会查找父类的类注解。
        cases.add(new ParentCase("054", null, None));
        cases.add(new ParentCase("055", null, None));
        cases.add(new ParentCase("056", null, None));
        cases.add(new ParentCase("057", null, None));
        cases.add(new ParentCase("058", SubMethodAnno, Sub));
        cases.add(new ParentCase("059", SubMethodAnno, Super));
        cases.add(new ParentCase("060", SubMethodAnno, Sub));
        cases.add(new ParentCase("061", SubMethodAnno, None));
        // TODO 源方法位于子类，没有方法注解，没有重写。子类没有类注解。虽然父类有类注解，但不会生效：
        //      AOP 直接就切不到这个方法。所以也没有什么后续查找类注解的事儿了。
        cases.add(new ParentCase("062", null, None));
        cases.add(new ParentCase("063", null, None));
        cases.add(new ParentCase("064", null, None));
        cases.add(new ParentCase("065", null, None));
        cases.add(new ParentCase("067", SubMethodAnno, Sub));
        cases.add(new ParentCase("068", SubMethodAnno, Super));
        cases.add(new ParentCase("069", SubMethodAnno, Sub));
        cases.add(new ParentCase("070", SubMethodAnno, None));
        cases.add(new ParentCase("071", SubClassAnno, Sub));
        cases.add(new ParentCase("072", SubClassAnno, Super));
        cases.add(new ParentCase("073", SubClassAnno, Sub));
        cases.add(new ParentCase("074", SubClassAnno, None));
        cases.add(new ParentCase("075", SuperMethodAnno, Sub));
        cases.add(new ParentCase("076", SuperMethodAnno, Super));
        cases.add(new ParentCase("077", SuperMethodAnno, Sub));
        cases.add(new ParentCase("078", SuperMethodAnno, None));
        cases.add(new ParentCase("079", SubMethodAnno, Sub));
        cases.add(new ParentCase("080", SubMethodAnno, Super));
        cases.add(new ParentCase("081", SubMethodAnno, Sub));
        cases.add(new ParentCase("082", SubMethodAnno, None));
        cases.add(new ParentCase("083", SubClassAnno, Sub));
        cases.add(new ParentCase("084", SubClassAnno, Super));
        cases.add(new ParentCase("085", SubClassAnno, Sub));
        cases.add(new ParentCase("086", SubClassAnno, None));
        // TODO 源方法位于父类，没有方法注解，没有重写。父类没有类注解，但子类有类注解。子类的类注解无效。
        //      AOP 直接就切不到这个方法。所以也没有什么后续查找类注解的事儿了。
        cases.add(new ParentCase("087", null, None));
        cases.add(new ParentCase("088", null, None));
        cases.add(new ParentCase("089", null, None));
        cases.add(new ParentCase("090", null, None));
        cases.add(new ParentCase("091", SubMethodAnno, Sub));
        cases.add(new ParentCase("092", SubMethodAnno, Super));
        cases.add(new ParentCase("093", SubMethodAnno, Sub));
        cases.add(new ParentCase("094", SubMethodAnno, None));
        cases.add(new ParentCase("095", SubClassAnno, Sub));
        cases.add(new ParentCase("096", SubClassAnno, Super));
        cases.add(new ParentCase("097", SubClassAnno, Sub));
        cases.add(new ParentCase("098", SubClassAnno, None));
        cases.add(new ParentCase("100", SubMethodAnno, Sub));
        cases.add(new ParentCase("101", SubMethodAnno, Super));
        cases.add(new ParentCase("102", SubMethodAnno, Sub));
        cases.add(new ParentCase("103", SubMethodAnno, None));
        // TODO 源方法位于子类，没有方法注解，有重写。父类中被重写源方法有方法注解，但不会生效。子类没有类注解。没有注解生效：
        //      AOP 直接就切不到这个方法。所以也没有什么后续查找类注解的事儿了。
        cases.add(new ParentCase("104", null, None));
        cases.add(new ParentCase("105", null, None));
        cases.add(new ParentCase("106", null, None));
        cases.add(new ParentCase("107", null, None));
        cases.add(new ParentCase("108", SuperMethodAnno, Sub));
        cases.add(new ParentCase("109", SuperMethodAnno, Super));
        cases.add(new ParentCase("110", SuperMethodAnno, Sub));
        cases.add(new ParentCase("111", SuperMethodAnno, None));
        cases.add(new ParentCase("112", SubMethodAnno, Sub));
        cases.add(new ParentCase("113", SubMethodAnno, Super));
        cases.add(new ParentCase("114", SubMethodAnno, Sub));
        cases.add(new ParentCase("115", SubMethodAnno, None));
        cases.add(new ParentCase("118", SubMethodAnno, Sub));
        cases.add(new ParentCase("119", SubMethodAnno, Super));
        cases.add(new ParentCase("120", SubMethodAnno, Sub));
        cases.add(new ParentCase("121", SubMethodAnno, None));
        return cases;
    }

    @Override
    public void run(String... args) throws Exception {
        runBasicTests();
        runInterfacesTests();
        runParentsTests();
    }

    private void runBasicTests() {
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

    private void runInterfacesTests() {
        // 实现接口时
        {
            // 接口上使用类注解，类注解无效
            {
                expectAnnotationNotTakeEffect(interfaceClassAnnoJavaInterfaceJavaDemo::greeting);
                expectAnnotationNotTakeEffect(interfaceClassAnnoJavaInterfaceKotlinDemo::greeting);
                expectAnnotationNotTakeEffect(interfaceClassAnnoKotlinInterfaceJavaDemo::greeting);
                expectAnnotationNotTakeEffect(interfaceClassAnnoKotlinInterfaceKotlinDemo::greeting);
            }
            // 接口中定义源方法，并使用方法注解。方法注解无效（因为被重写了）
            {
                expectAnnotationNotTakeEffect(interfaceOriginMethodMethodAnnoJavaInterfaceJavaDemo::greeting);
                expectAnnotationNotTakeEffect(interfaceOriginMethodMethodAnnoJavaInterfaceKotlinDemo::greeting);
                expectAnnotationNotTakeEffect(interfaceOriginMethodMethodAnnoKotlinInterfaceJavaDemo::greeting);
                expectAnnotationNotTakeEffect(interfaceOriginMethodMethodAnnoKotlinInterfaceKotlinDemo::greeting);
            }
            // 接口中定义源方法（default 方法），并使用方法注解。注解生效！
            {
                expectFallback(interfaceOriginMethodDefaultMethodAnnoJavaInterfaceJavaDemo::greeting);
                expectFallback(interfaceOriginMethodDefaultMethodAnnoJavaInterfaceKotlinDemo::greeting);
                expectFallback(interfaceOriginMethodDefaultMethodAnnoKotlinInterfaceJavaDemo::greeting);
                expectFallback(interfaceOriginMethodDefaultMethodAnnoKotlinInterfaceKotlinDemo::greeting);
            }
            // 接口中定义源方法（default 方法），并使用方法注解，方法被重写。注解不生效！
            {
                expectAnnotationNotTakeEffect(interfaceOriginMethodOverriddenDefaultMethodAnnoJavaInterfaceJavaDemo::greeting);
                expectAnnotationNotTakeEffect(interfaceOriginMethodOverriddenDefaultMethodAnnoJavaInterfaceKotlinDemo::greeting);
                expectAnnotationNotTakeEffect(interfaceOriginMethodOverriddenDefaultMethodAnnoKotlinInterfaceJavaDemo::greeting);
                expectAnnotationNotTakeEffect(interfaceOriginMethodOverriddenDefaultMethodAnnoKotlinInterfaceKotlinDemo::greeting);
            }
            // 接口上定义源方法，并使用方法注解；接口上定义 fallbackMethod 。fallback 生效
            {
                expectFallback(interfaceOriginMethodDefaultMethodAnnoFallbackJavaInterfaceJavaDemo::greeting);
                expectFallback(interfaceOriginMethodDefaultMethodAnnoFallbackJavaInterfaceKotlinDemo::greeting);
                expectFallback(interfaceOriginMethodDefaultMethodAnnoFallbackKotlinInterfaceJavaDemo::greeting);
                expectFallback(interfaceOriginMethodDefaultMethodAnnoFallbackKotlinInterfaceKotlinDemo::greeting);
            }
            // 接口上定义源方法，并使用方法注解；接口上定义 fallbackMethod ，fallback 被重写 。 重写 fallback 生效
            {
                expectFallback(interfaceOriginMethodDefaultMethodAnnoFallbackOverriddenJavaInterfaceJavaDemo::greeting);
                expectFallback(interfaceOriginMethodDefaultMethodAnnoFallbackOverriddenJavaInterfaceKotlinDemo::greeting);
                expectFallback(interfaceOriginMethodDefaultMethodAnnoFallbackOverriddenKotlinInterfaceJavaDemo::greeting);
                expectFallback(interfaceOriginMethodDefaultMethodAnnoFallbackOverriddenKotlinInterfaceKotlinDemo::greeting);
            }
            // 接口上不定义源方法，但定义 fallbackMethod。类注解 生效
            {
                expectFallback(interfaceNoOriginFallbackClassAnnoJavaInterfaceJavaDemo::greeting);
                expectFallback(interfaceNoOriginFallbackClassAnnoJavaInterfaceKotlinDemo::greeting);
                expectFallback(interfaceNoOriginFallbackClassAnnoKotlinInterfaceJavaDemo::greeting);
                expectFallback(interfaceNoOriginFallbackClassAnnoKotlinInterfaceKotlinDemo::greeting);
            }
            // 接口上不定义源方法，但定义 fallbackMethod。方法注解 生效
            {
                expectFallback(interfaceNoOriginFallbackMethodAnnoJavaInterfaceJavaDemo::greeting);
                expectFallback(interfaceNoOriginFallbackMethodAnnoJavaInterfaceKotlinDemo::greeting);
                expectFallback(interfaceNoOriginFallbackMethodAnnoKotlinInterfaceJavaDemo::greeting);
                expectFallback(interfaceNoOriginFallbackMethodAnnoKotlinInterfaceKotlinDemo::greeting);
            }
            // 接口上不定义源方法，但定义 fallbackMethod，fallback 重写。 类注解 、子类 fallback 生效
            {
                expectFallback(interfaceNoOriginFallbackOverriddenClassAnnoJavaInterfaceJavaDemo::greeting);
                expectFallback(interfaceNoOriginFallbackOverriddenClassAnnoJavaInterfaceKotlinDemo::greeting);
                expectFallback(interfaceNoOriginFallbackOverriddenClassAnnoKotlinInterfaceJavaDemo::greeting);
                expectFallback(interfaceNoOriginFallbackOverriddenClassAnnoKotlinInterfaceKotlinDemo::greeting);
            }
            // 接口上不定义源方法，但定义 fallbackMethod，fallback 重写。 方法注解 、子类 fallback 生效
            {
                expectFallback(interfaceNoOriginFallbackOverriddenMethodAnnoJavaInterfaceJavaDemo::greeting);
                expectFallback(interfaceNoOriginFallbackOverriddenMethodAnnoJavaInterfaceKotlinDemo::greeting);
                expectFallback(interfaceNoOriginFallbackOverriddenMethodAnnoKotlinInterfaceJavaDemo::greeting);
                expectFallback(interfaceNoOriginFallbackOverriddenMethodAnnoKotlinInterfaceKotlinDemo::greeting);
            }
        }
    }

    private void runParentsTests() throws NoSuchMethodException {
        // 继承父类时
        // ./parents_matrix.md
        String[] languages = {"Java", "Kotlin"};
        for (ParentCase parentCase : provideParentCases()) {
            for (String superLanguage : languages) {
                for (String demoLanguage : languages) {
                    String demoBeanName = "parentCase" + parentCase.sn() + superLanguage + "Parent" + demoLanguage + "Demo";
                    Object bean = applicationContext.getBean(demoBeanName);
                    Method greeting = bean.getClass().getMethod("greeting", String.class);
                    if (parentCase.anno == null) {
                        expectParentCaseAnnotationNotTakeEffect(parentCase.sn, s -> (String) greeting.invoke(bean, s));
                    } else if (parentCase.location == None) {
                        expectParentCaseNoFallback(parentCase.sn, s -> (String) greeting.invoke(bean, s));
                    } else {
                        expectParentCaseFallback(
                                parentCase.sn,
                                s -> (String) greeting.invoke(bean, s),
                                parentCase.anno,
                                parentCase.location);
                    }
                }
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

    private static void expectParentCaseFallback(@NotNull String sn,
                                                 @NotNull CheckedFunction<String, String> function,
                                                 @NotNull TakeEffectAnno takeEffectAnno,
                                                 @NotNull FallbackLocation fallbackLocation) {
        String result;
        try {
            result = function.apply("");
        } catch (Exception e) {
            throw new AssertionError("Case " + sn + ", got unexpect exception", e);
        }
        String expect = takeEffectAnno.name() + ":" + fallbackLocation.name() + ":" + FALLBACK_RESULT;
        if (!expect.equals(result)) {
            throw new AssertionError("Case " + sn + ",expect \"" + expect + "\", but got \"" + result + "\"");
        }
    }

    private static void expectParentCaseAnnotationNotTakeEffect(@NotNull String sn,
                                                                @NotNull CheckedFunction<String, String> function) {
        try {
            try {
                String result = function.apply("");
                throw new AssertionError("Case " + sn + ", expect fallback does not take effect, but got \"" + result + "\"");
            } catch (InvocationTargetException e) {
                if (e.getCause() instanceof IllegalArgumentException iae) {
                    throw iae;
                }
                throw new AssertionError("Case " + sn + ", got unexpect exception", e);
            }
        } catch (IllegalArgumentException e) {
            if (!"name should not be null or blank".equals(e.getMessage())) {
                throw new AssertionError("Case " + sn + ", got unexpect exception", e);
            }
            if (Arrays.stream(e.getStackTrace())
                    .anyMatch((ste) -> ste.getClassName().contains(".fallback.FallbackExecutor"))) {
                throw new AssertionError("Case " + sn + ", expect aspect not take effect", e);
            }
        } catch (Throwable e) {
            if (e instanceof AssertionError ae) {
                throw ae;
            }
            throw new AssertionError("Case " + sn + ", got unexpect exception", e);
        }
    }

    private static void expectParentCaseNoFallback(@NotNull String sn,
                                                   @NotNull CheckedFunction<String, String> function) {
        String result;
        try {
            try {
                result = function.apply("");
            } catch (InvocationTargetException e) {
                if (e.getCause() instanceof IllegalArgumentException iae) {
                    throw iae;
                }
                throw new AssertionError("Case " + sn + ", got unexpect exception", e);
            }
        } catch (IllegalArgumentException e) {
            if (!"name should not be null or blank".equals(e.getMessage())) {
                throw new AssertionError("Case " + sn + ", got unexpect exception", e);
            }
            if (Arrays.stream(e.getStackTrace())
                    .noneMatch((ste) -> ste.getClassName().contains(".fallback.FallbackExecutor"))) {
                throw new AssertionError("Case " + sn + ", expect aspect take effect", e);
            }
            return;
        } catch (Throwable e) {
            if (e instanceof AssertionError ae) {
                throw ae;
            }
            throw new AssertionError("Case " + sn + ", got unexpect exception", e);
        }

        throw new AssertionError("Case " + sn + ", expect fallback does not take effect, but got \"" + result + "\"");
    }

    @FunctionalInterface
    private interface CheckedFunction<T, R> {
        R apply(T t) throws Exception;
    }
}
