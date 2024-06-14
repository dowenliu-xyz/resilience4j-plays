package org.example.demo.demos.javabase;

import org.example.demo.demos.javabase.interfaces.*;
import org.example.demo.demos.javabase.parents.JavaBaseJavaParentJavaDemo;
import org.example.demo.demos.javabase.parents.JavaBaseJavaParentKotlinDemo;
import org.example.demo.demos.javabase.parents.JavaBaseKotlinParentJavaDemo;
import org.example.demo.demos.javabase.parents.JavaBaseKotlinParentKotlinDemo;
import org.example.demo.demos.javabase.self.JavaBaseSelfJavaDemo;
import org.example.demo.demos.javabase.self.JavaBaseSelfKotlinDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConf {
    @Bean
    public JavaBaseSelfJavaDemo javaBaseSelfJavaDemo() {
        return new JavaBaseSelfJavaDemo();
    }

    @Bean
    public JavaBaseSelfKotlinDemo javaBaseSelfKotlinDemo() {
        return new JavaBaseSelfKotlinDemo();
    }

    @Bean
    public JavaBaseJavaParentJavaDemo javaBaseJavaParentJavaDemo() {
        return new JavaBaseJavaParentJavaDemo();
    }

    @Bean
    public JavaBaseJavaParentKotlinDemo javaBaseJavaParentKotlinDemo() {
        return new JavaBaseJavaParentKotlinDemo();
    }

    @Bean
    public JavaBaseKotlinParentJavaDemo javaBaseKotlinParentJavaDemo() {
        return new JavaBaseKotlinParentJavaDemo();
    }

    @Bean
    public JavaBaseKotlinParentKotlinDemo javaBaseKotlinParentKotlinDemo() {
        return new JavaBaseKotlinParentKotlinDemo();
    }

    @Bean
    public JavaBaseJavaInterfaceForJava javaBaseJavaInterfaceForJava() {
        return new JavaBaseJavaInterfaceJavaDemo();
    }

    @Bean
    public JavaBaseJavaInterfaceForKotlin javaBaseJavaInterfaceForKotlin() {
        return new JavaBaseJavaInterfaceKotlinDemo();
    }

    @Bean
    public JavaBaseKotlinInterfaceForJava javaBaseKotlinInterfaceForJava() {
        return new JavaBaseKotlinInterfaceJavaDemo();
    }

    @Bean
    public JavaBaseKotlinInterfaceForKotlin javaBaseKotlinInterfaceForKotlin() {
        return new JavaBaseKotlinInterfaceKotlinDemo();
    }

    @Bean
    public JavaBaseFallbackDefaultJavaInterfaceForJava javaBaseFallbackDefaultJavaInterfaceForJava() {
        return new JavaBaseFallbackDefaultJavaInterfaceJavaDemo();
    }

    @Bean
    public JavaBaseFallbackDefaultJavaInterfaceForKotlin javaBaseFallbackDefaultJavaInterfaceForKotlin() {
        return new JavaBaseFallbackDefaultJavaInterfaceKotlinDemo();
    }

    @Bean
    public JavaBaseFallbackDefaultKotlinInterfaceForJava javaBaseFallbackDefaultKotlinInterfaceForJava() {
        return new JavaBaseFallbackDefaultKotlinInterfaceJavaDemo();
    }

    @Bean
    public JavaBaseFallbackDefaultKotlinInterfaceForKotlin javaBaseFallbackDefaultKotlinInterfaceForKotlin() {
        return new JavaBaseFallbackDefaultKotlinInterfaceKotlinDemo();
    }

    @Bean
    public JavaBaseFallbackDefaultOverriddenJavaInterfaceForJava javaBaseFallbackDefaultOverriddenJavaInterfaceForJava() {
        return new JavaBaseFallbackDefaultOverriddenJavaInterfaceJavaDemo();
    }

    @Bean
    public JavaBaseFallbackDefaultOverriddenJavaInterfaceForKotlin javaBaseFallbackDefaultOverriddenJavaInterfaceForKotlin() {
        return new JavaBaseFallbackDefaultOverriddenJavaInterfaceKotlinDemo();
    }

    @Bean
    public JavaBaseFallbackDefaultOverriddenKotlinInterfaceForJava javaBaseFallbackDefaultOverriddenKotlinInterfaceForJava() {
        return new JavaBaseFallbackDefaultOverriddenKotlinInterfaceJavaDemo();
    }

    @Bean
    public JavaBaseFallbackDefaultOverriddenKotlinInterfaceForKotlin javaBaseFallbackDefaultOverriddenKotlinInterfaceForKotlin() {
        return new JavaBaseFallbackDefaultOverriddenKotlinInterfaceKotlinDemo();
    }
}
