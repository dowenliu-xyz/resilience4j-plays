//extra["resilience4j.version"] = "2.0.1" // 2.2.0 by root project

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("io.github.resilience4j:resilience4j-spring-boot3")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks {
    create("generateDemos") {
        val basePkg = "org.example.ae.interfaces.jdk"
        doLast {
            mkdirs(basePkg)
            val cases = generateCases()
            cases.forEach { generateDemo(basePkg, it) }
            generateJavaBaseConfig(basePkg, cases)
            cases.forEach { generateCaseRunner(basePkg, it) }
        }
    }
}

fun mkdirs(basePkg: String) {
    val javaPkgPath = "src/main/java/${basePkg.replace(".", "/")}/demos"
    mkdir(javaPkgPath)
    val kotlinPkgPath = "src/main/kotlin/${basePkg.replace(".", "/")}/demos"
    mkdir(kotlinPkgPath)
}

fun generateCases(): List<Case> {
    val cases = mutableListOf<Case>()
    for (hasClassAnnotationOnInterface in listOf(true, false)) {
        for (originMethodInInterface in OriginMethodInInterface.values()) {
            for (fallbackInInterface in FallbackInInterface.values()) {
                for (hasClassAnnotationOnClass in listOf(true, false)) {
                    for (originMethodInClass in OriginMethodInClass.values()) {
                        if (!originMethodInInterface.isDefault && originMethodInClass == OriginMethodInClass.None) {
                            // 无效组合：即没有在接口中提供 default originMethod 也没有在类中实现 originMethod
                            continue
                        }
                        for (hasFallbackInClass in listOf(true, false)) {
                            if (!hasFallbackInClass && fallbackInInterface == FallbackInInterface.Abstract) {
                                // 无效组合：接口要求实现 fallback 方法，但类中想不提供 fallback 实现。语法错误
                                continue
                            }
                            cases.add(
                                Case(
                                    sn = String.format("%03d", cases.size + 1),
                                    hasClassAnnotationOnInterface = hasClassAnnotationOnInterface,
                                    originMethodInInterface = originMethodInInterface,
                                    fallbackInInterface = fallbackInInterface,
                                    hasClassAnnotationOnClass = hasClassAnnotationOnClass,
                                    originMethodInClass = originMethodInClass,
                                    hasFallbackInClass = hasFallbackInClass,
                                )
                            )
                        }
                    }
                }
            }
        }
    }
    return cases
}

fun generateDemo(basePkg: String, case: Case) {
    logger.lifecycle("generateDemo: $case")
    val javaPkgPath = "src/main/java/${basePkg.replace(".", "/")}/demos"
    val kotlinPkgPath = "src/main/kotlin/${basePkg.replace(".", "/")}/demos"
    generateJavaInterface(javaPkgPath, basePkg, case, "Java", ConfigType.AnnotationBase)
    generateJavaDemo(javaPkgPath, basePkg, case, "Java", ConfigType.AnnotationBase)
    generateJavaInterface(javaPkgPath, basePkg, case, "Kotlin", ConfigType.AnnotationBase)
    generateKotlinDemo(kotlinPkgPath, basePkg, case, "Java", ConfigType.AnnotationBase)
    generateKotlinInterface(kotlinPkgPath, basePkg, case, "Java", ConfigType.AnnotationBase)
    generateJavaDemo(javaPkgPath, basePkg, case, "Kotlin", ConfigType.AnnotationBase)
    generateKotlinInterface(kotlinPkgPath, basePkg, case, "Kotlin", ConfigType.AnnotationBase)
    generateKotlinDemo(kotlinPkgPath, basePkg, case, "Kotlin", ConfigType.AnnotationBase)

    generateJavaInterface(javaPkgPath, basePkg, case, "Java", ConfigType.JavaBase)
    generateJavaDemo(javaPkgPath, basePkg, case, "Java", ConfigType.JavaBase)
    generateJavaInterface(javaPkgPath, basePkg, case, "Kotlin", ConfigType.JavaBase)
    generateKotlinDemo(kotlinPkgPath, basePkg, case, "Java", ConfigType.JavaBase)
    generateKotlinInterface(kotlinPkgPath, basePkg, case, "Java", ConfigType.JavaBase)
    generateJavaDemo(javaPkgPath, basePkg, case, "Kotlin", ConfigType.JavaBase)
    generateKotlinInterface(kotlinPkgPath, basePkg, case, "Kotlin", ConfigType.JavaBase)
    generateKotlinDemo(kotlinPkgPath, basePkg, case, "Kotlin", ConfigType.JavaBase)
}

fun generateJavaInterface(pkgPath: String, basePkg: String, case: Case, classLang: String, configType: ConfigType) {
    val interfaceName = "Case${case.sn}${configType}JavaInterfaceFor$classLang"
    val file = File("$pkgPath/$interfaceName.java")
    file.writeText(
        """
                    |// Generated by generateDemo task, DO NOT MODIFY
                    |package $basePkg.demos;
                    |
        """.trimMargin()
    )
    if (case.hasClassAnnotationOnInterface || case.originMethodInInterface.hasAnnotation) {
        file.appendText(
            """
                    |
                    |import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |import $basePkg.biz.DemoCase;
        """.trimMargin()
    )
    if (
        case.originMethodInInterface.isDefault ||
        case.originMethodInInterface.hasAnnotation ||
        case.fallbackInInterface != FallbackInInterface.None
    ) {
        file.appendText(
            """
                    |
                    |import org.jetbrains.annotations.NotNull;
                    |import org.jetbrains.annotations.Nullable;
                    |
           """.trimMargin()
        )
    }
    if (case.fallbackInInterface == FallbackInInterface.Default) {
        file.appendText(
            """
                    |
                    |import static $basePkg.biz.DemoCase.EffectiveAnnotation.*;
                    |import static $basePkg.biz.DemoCase.EffectiveFallback.FallbackInInterface;
                    |import static $basePkg.biz.Greeting.doFallback;
            """.trimMargin()
        )
    }
    if (case.originMethodInInterface.isDefault) {
        file.appendText(
            """
                    |
                    |import static $basePkg.biz.Greeting.doGreeting;
            """.trimMargin()
        )
    }
    file.appendText("\n")
    if (case.hasClassAnnotationOnInterface) {
        file.appendText(
            """
                    |
                    |@CircuitBreaker(name = "demo", fallbackMethod = "interfaceClassFallback")
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |public interface $interfaceName extends DemoCase {
                    |
        """.trimMargin()
    )
    if (case.originMethodInInterface.hasAnnotation) {
        file.appendText(
            """
                    |
                    |    @CircuitBreaker(name = "demo", fallbackMethod = "interfaceMethodFallback")
            """.trimMargin()
        )
    }
    if (case.originMethodInInterface.isDefault) {
        file.appendText(
            """
                    |
                    |    @NotNull
                    |    @Override
                    |    default String greeting(@Nullable String name) {
                    |        return "super:" + doGreeting(name);
                    |    }
                    |
                """.trimMargin()
        )
    } else if (case.originMethodInInterface.hasAnnotation) {
        file.appendText(
            """
                    |
                    |    @NotNull
                    |    String greeting(@Nullable String name);
                    |
                """.trimMargin()
        )
    }
    if (case.fallbackInInterface == FallbackInInterface.Default) {
        file.appendText(
            """
                    |
                    |    @SuppressWarnings("unused")
                    |    @NotNull
                    |    default String interfaceClassFallback(@Nullable String name, @Nullable Throwable thr) {
                    |        return ClassAnnotationOnInterface + ":" + FallbackInInterface + ":" + doFallback(name, thr);
                    |    }
                    |
                    |    @SuppressWarnings("unused")
                    |    @NotNull
                    |    default String interfaceMethodFallback(@Nullable String name, @Nullable Throwable thr) {
                    |        return MethodAnnotationInInterface + ":" + FallbackInInterface + ":" + doFallback(name, thr);
                    |    }
                    |
                    |    @SuppressWarnings("unused")
                    |    @NotNull
                    |    default String classFallback(@Nullable String name, @Nullable Throwable thr) {
                    |        return ClassAnnotationOnClass + ":" + FallbackInInterface + ":" + doFallback(name, thr);
                    |    }
                    |
                    |    @SuppressWarnings("unused")
                    |    @NotNull
                    |    default String methodFallback(@Nullable String name, @Nullable Throwable thr) {
                    |        return MethodAnnotationInClass + ":" + FallbackInInterface + ":" + doFallback(name, thr);
                    |    }
                    |
            """.trimMargin()
        )
    } else if (case.fallbackInInterface == FallbackInInterface.Abstract) {
        file.appendText(
            """
                    |
                    |    @SuppressWarnings("unused")
                    |    @NotNull
                    |    String interfaceClassFallback(@Nullable String name, @Nullable Throwable thr);
                    |
                    |    @SuppressWarnings("unused")
                    |    @NotNull
                    |    String interfaceMethodFallback(@Nullable String name, @Nullable Throwable thr);
                    |
                    |    @SuppressWarnings("unused")
                    |    @NotNull
                    |    String classFallback(@Nullable String name, @Nullable Throwable thr);
                    |
                    |    @SuppressWarnings("unused")
                    |    @NotNull
                    |    String methodFallback(@Nullable String name, @Nullable Throwable thr);
                    |
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |}
                    |
        """.trimMargin()
    )
}

fun generateJavaDemo(pkgPath: String, basePkg: String, case: Case, interfaceLang: String, configType: ConfigType) {
    val className = "Case${case.sn}${configType}${interfaceLang}InterfaceJavaDemo"
    val file = File("$pkgPath/$className.java")
    file.writeText(
        """
                    |// Generated by generateDemo task, DO NOT MODIFY
                    |package $basePkg.demos;
                    |
        """.trimMargin()
    )
    if (case.hasClassAnnotationOnClass || case.originMethodInClass.hasAnnotation) {
        file.appendText(
            """
                    |
                    |import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |import org.jetbrains.annotations.NotNull;
        """.trimMargin()
    )
    if (case.originMethodInClass != OriginMethodInClass.None || case.hasFallbackInClass) {
        file.appendText(
            """
                    |
                    |import org.jetbrains.annotations.Nullable;
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |import org.springframework.stereotype.Component;
                    |
        """.trimMargin()
    )
    if (case.hasFallbackInClass) {
        file.appendText(
            """
                    |
                    |import static $basePkg.biz.DemoCase.EffectiveAnnotation.*;
                    |import static $basePkg.biz.DemoCase.EffectiveFallback.FallbackInClass;
                    |import static $basePkg.biz.Greeting.doFallback;
            """.trimMargin()
        )
    }
    if (case.originMethodInClass != OriginMethodInClass.None) {
        file.appendText(
            """
                    |
                    |import static $basePkg.biz.Greeting.doGreeting;
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |
                    |@Component
        """.trimMargin()
    )
    if (case.hasClassAnnotationOnClass) {
        file.appendText(
            """
                    |
                    |@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |public class $className implements Case${case.sn}${configType}${interfaceLang}InterfaceForJava {
                    |
                    |    @NotNull
                    |    @Override
                    |    public String sn() {
                    |        return "${case.sn}";
                    |    }
                    |
                    |    @Override
                    |    public boolean hasClassAnnotationOnInterface() {
                    |        return ${case.hasClassAnnotationOnInterface};
                    |    }
                    |
                    |    @NotNull
                    |    @Override
                    |    public OriginMethodInInterface originMethodInInterface() {
                    |        return OriginMethodInInterface.${case.originMethodInInterface.name};
                    |    }
                    |
                    |    @NotNull
                    |    @Override
                    |    public FallbackInInterface fallbackInInterface() {
                    |        return FallbackInInterface.${case.fallbackInInterface.name};
                    |    }
                    |
                    |    @Override
                    |    public boolean hasClassAnnotationOnClass() {
                    |        return ${case.hasClassAnnotationOnClass};
                    |    }
                    |
                    |    @NotNull
                    |    @Override
                    |    public OriginMethodInClass originMethodInClass() {
                    |        return OriginMethodInClass.${case.originMethodInClass.name};
                    |    }
                    |
                    |    @Override
                    |    public boolean hasFallbackInClass() {
                    |        return ${case.hasFallbackInClass};
                    |    }
                    |
        """.trimMargin()
    )
    if (case.originMethodInClass.hasAnnotation) {
        file.appendText(
            """
                    |
                    |    @CircuitBreaker(name = "demo", fallbackMethod = "methodFallback")
            """.trimMargin()
        )
    }
    if (case.originMethodInClass != OriginMethodInClass.None) {
        file.appendText(
            """
                    |
                    |    @NotNull
                    |    @Override
                    |    public String greeting(@Nullable String name) {
                    |        return doGreeting(name);
                    |    }
                    |
            """.trimMargin()
        )
    }
    if (case.hasFallbackInClass) {
        val optionalOverrideAnno =
            if (case.fallbackInInterface != FallbackInInterface.None) "\n    @Override" else ""
        file.appendText(
            """
                    |
                    |    @SuppressWarnings("unused")
                    |    @NotNull$optionalOverrideAnno
                    |    public String interfaceClassFallback(@Nullable String name, @Nullable Throwable thr) {
                    |        return ClassAnnotationOnInterface + ":" + FallbackInClass + ":" + doFallback(name, thr);
                    |    }
                    |
                    |    @SuppressWarnings("unused")
                    |    @NotNull$optionalOverrideAnno
                    |    public String interfaceMethodFallback(@Nullable String name, @Nullable Throwable thr) {
                    |        return MethodAnnotationInInterface + ":" + FallbackInClass + ":" + doFallback(name, thr);
                    |    }
                    |
                    |    @SuppressWarnings("unused")
                    |    @NotNull$optionalOverrideAnno
                    |    public String classFallback(@Nullable String name, @Nullable Throwable thr) {
                    |        return ClassAnnotationOnClass + ":" + FallbackInClass + ":" + doFallback(name, thr);
                    |    }
                    |
                    |    @SuppressWarnings("unused")
                    |    @NotNull$optionalOverrideAnno
                    |    public String methodFallback(@Nullable String name, @Nullable Throwable thr) {
                    |        return MethodAnnotationInClass + ":" + FallbackInClass + ":" + doFallback(name, thr);
                    |    }
                    |
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |}
                    |
        """.trimMargin()
    )
}

fun generateKotlinInterface(pkgPath: String, basePkg: String, case: Case, classLang: String, configType: ConfigType) {
    val interfaceName = "Case${case.sn}${configType}KotlinInterfaceFor$classLang"
    val file = File("$pkgPath/$interfaceName.kt")
    file.writeText(
        """
                    |// Generated by generateDemo task, DO NOT MODIFY
                    |package $basePkg.demos
                    |
        """.trimMargin()
    )
    if (case.hasClassAnnotationOnInterface || case.originMethodInInterface.hasAnnotation) {
        file.appendText(
            """
                    |
                    |import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |import $basePkg.biz.DemoCase
        """.trimMargin()
    )
    if (case.fallbackInInterface == FallbackInInterface.Default) {
        file.appendText(
            """
                    |
                    |import $basePkg.biz.DemoCase.EffectiveAnnotation.*
                    |import $basePkg.biz.DemoCase.EffectiveFallback.FallbackInInterface
                    |import $basePkg.biz.Greeting.doFallback
            """.trimMargin()
        )
    }
    if (case.originMethodInInterface.isDefault) {
        file.appendText(
            """
                    |
                    |import $basePkg.biz.Greeting.doGreeting
            """.trimMargin()
        )
    }
    file.appendText("\n")
    if (case.hasClassAnnotationOnInterface) {
        file.appendText(
            """
                    |
                    |@CircuitBreaker(name = "demo", fallbackMethod = "interfaceClassFallback")
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |interface $interfaceName : DemoCase
        """.trimMargin()
    )
    val hasInterfaceBody = case.originMethodInInterface.isDefault ||
            case.originMethodInInterface.hasAnnotation ||
            case.fallbackInInterface != FallbackInInterface.None
    if (hasInterfaceBody) {
        file.appendText(" {\n")
    } else {
        file.appendText("\n")
    }
    if (case.originMethodInInterface.hasAnnotation) {
        file.appendText(
            """
                    |
                    |    @CircuitBreaker(name = "demo", fallbackMethod = "interfaceMethodFallback")
            """.trimMargin()
        )
    }
    if (case.originMethodInInterface.isDefault) {
        file.appendText(
            """
                    |
                    |    override fun greeting(name: String?): String {
                    |        return "super:${"$"}{doGreeting(name)}"
                    |    }
                    |
                """.trimMargin()
        )
    } else if (case.originMethodInInterface.hasAnnotation) {
        file.appendText(
            """
                    |
                    |    override fun greeting(name: String?): String
                    |
                """.trimMargin()
        )
    }
    if (case.fallbackInInterface == FallbackInInterface.Default) {
        file.appendText(
            """
                    |
                    |    fun interfaceClassFallback(name: String?, thr: Throwable?): String {
                    |        return "${"$"}ClassAnnotationOnInterface:${"$"}FallbackInInterface:${"$"}{doFallback(name, thr)}"
                    |    }
                    |
                    |    fun interfaceMethodFallback(name: String?, thr: Throwable?): String {
                    |        return "${"$"}MethodAnnotationInInterface:${"$"}FallbackInInterface:${"$"}{doFallback(name, thr)}"
                    |    }
                    |
                    |    fun classFallback(name: String?, thr: Throwable?): String {
                    |        return "${"$"}ClassAnnotationOnClass:${"$"}FallbackInInterface:${"$"}{doFallback(name, thr)}"
                    |    }
                    |
                    |    fun methodFallback(name: String?, thr: Throwable?): String {
                    |        return "${"$"}MethodAnnotationInClass:${"$"}FallbackInInterface:${"$"}{doFallback(name, thr)}"
                    |    }
                    |
            """.trimMargin()
        )
    } else if (case.fallbackInInterface == FallbackInInterface.Abstract) {
        file.appendText(
            """
                    |
                    |    fun interfaceClassFallback(name: String?, thr: Throwable?): String
                    |
                    |    fun interfaceMethodFallback(name: String?, thr: Throwable?): String
                    |
                    |    fun classFallback(name: String?, thr: Throwable?): String
                    |
                    |    fun methodFallback(name: String?, thr: Throwable?): String
                    |
            """.trimMargin()
        )
    }
    if (hasInterfaceBody) {
        file.appendText("\n}\n")
    }
}

fun generateKotlinDemo(pkgPath: String, basePkg: String, case: Case, interfaceLang: String, configType: ConfigType) {
    val className = "Case${case.sn}${configType}${interfaceLang}InterfaceKotlinDemo"
    val file = File("$pkgPath/$className.kt")
    file.writeText(
        """
                    |// Generated by generateDemo task, DO NOT MODIFY
                    |package $basePkg.demos
                    |
        """.trimMargin()
    )
    if (case.hasClassAnnotationOnClass || case.originMethodInClass.hasAnnotation) {
        file.appendText(
            """
                    |
                    |import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |import $basePkg.biz.DemoCase
        """.trimMargin()
    )
    if (case.hasFallbackInClass) {
        file.appendText(
            """
                    |
                    |import $basePkg.biz.DemoCase.EffectiveAnnotation.*
                    |import $basePkg.biz.DemoCase.EffectiveFallback.FallbackInClass
                    |import $basePkg.biz.Greeting.doFallback
            """.trimMargin()
        )
    }
    if (case.originMethodInClass != OriginMethodInClass.None) {
        file.appendText(
            """
                    |
                    |import $basePkg.biz.Greeting.doGreeting
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |import org.springframework.stereotype.Component
                    |
                    |@Component
        """.trimMargin()
    )
    if (case.hasClassAnnotationOnClass) {
        file.appendText(
            """
                    |
                    |@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |class $className : Case${case.sn}${configType}${interfaceLang}InterfaceForKotlin {
                    |
                    |    override fun sn(): String {
                    |        return "${case.sn}"
                    |    }
                    |
                    |    override fun hasClassAnnotationOnInterface(): Boolean {
                    |        return ${case.hasClassAnnotationOnInterface}
                    |    }
                    |
                    |    override fun originMethodInInterface(): DemoCase.OriginMethodInInterface {
                    |        return DemoCase.OriginMethodInInterface.${case.originMethodInInterface.name}
                    |    }
                    |
                    |    override fun fallbackInInterface(): DemoCase.FallbackInInterface {
                    |        return DemoCase.FallbackInInterface.${case.fallbackInInterface.name}
                    |    }
                    |
                    |    override fun hasClassAnnotationOnClass(): Boolean {
                    |        return ${case.hasClassAnnotationOnClass}
                    |    }
                    |
                    |    override fun originMethodInClass(): DemoCase.OriginMethodInClass {
                    |        return DemoCase.OriginMethodInClass.${case.originMethodInClass.name}
                    |    }
                    |
                    |    override fun hasFallbackInClass(): Boolean {
                    |        return ${case.hasFallbackInClass}
                    |    }
                    |
        """.trimMargin()
    )
    if (case.originMethodInClass.hasAnnotation) {
        file.appendText(
            """
                    |
                    |    @CircuitBreaker(name = "demo", fallbackMethod = "methodFallback")
            """.trimMargin()
        )
    }
    if (case.originMethodInClass != OriginMethodInClass.None) {
        file.appendText(
            """
                    |
                    |    override fun greeting(name: String?): String {
                    |        return doGreeting(name)
                    |    }
                    |
            """.trimMargin()
        )
    }
    if (case.hasFallbackInClass) {
        val optionalOverrideKeyword =
            if (case.fallbackInInterface != FallbackInInterface.None) "override " else ""
        file.appendText(
            """
                    |
                    |    ${optionalOverrideKeyword}fun interfaceClassFallback(name: String?, thr: Throwable?): String {
                    |        return "${"$"}ClassAnnotationOnInterface:${"$"}FallbackInClass:${"$"}{doFallback(name, thr)}"
                    |    }
                    |
                    |    ${optionalOverrideKeyword}fun interfaceMethodFallback(name: String?, thr: Throwable?): String {
                    |        return "${"$"}MethodAnnotationInInterface:${"$"}FallbackInClass:${"$"}{doFallback(name, thr)}"
                    |    }
                    |
                    |    ${optionalOverrideKeyword}fun classFallback(name: String?, thr: Throwable?): String {
                    |        return "${"$"}ClassAnnotationOnClass:${"$"}FallbackInClass:${"$"}{doFallback(name, thr)}"
                    |    }
                    |
                    |    ${optionalOverrideKeyword}fun methodFallback(name: String?, thr: Throwable?): String {
                    |        return "${"$"}MethodAnnotationInClass:${"$"}FallbackInClass:${"$"}{doFallback(name, thr)}"
                    |    }
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |}
                    |
        """.trimMargin()
    )
}

fun generateJavaBaseConfig(basePkg: String, cases: List<Case>) {
    val className = "JavaBaseConfig"
    val pkgPath = "src/main/java/${basePkg.replace(".", "/")}"
    val file = File("$pkgPath/$className.java")
    file.writeText(
        """
                        |// Generated by generateDemo task, DO NOT MODIFY
                        |package $basePkg;
                        |
                        |import org.example.ae.interfaces.jdk.demos.*;
                        |import org.springframework.context.annotation.Bean;
                        |import org.springframework.context.annotation.Configuration;
                        |
                        |@Configuration
                        |public class $className {
                        |
        """.trimMargin()
    )
    cases.forEach { case ->
        arrayOf("Java", "Kotlin").forEach { interfaceLang ->
            arrayOf("Java", "Kotlin").forEach { classLang ->
                file.appendText(
                    """
                        |
                        |    @Bean
                        |    public Case${case.sn}JavaBase${interfaceLang}InterfaceFor${classLang} case${case.sn}JavaBase${interfaceLang}InterfaceFor${classLang}() {
                        |        return new Case${case.sn}JavaBase${interfaceLang}Interface${classLang}Demo();
                        |    }
                        |
                    """.trimMargin()
                )
            }
        }
    }
    file.appendText(
        """
                        |
                        |}
                        |
        """.trimMargin()
    )
}

fun generateCaseRunner(basePkg: String, case: Case) {
    val className = "Case${case.sn}Runner"
    val pkgPath = "src/main/java/${basePkg.replace(".", "/")}/demos"
    val file = File("$pkgPath/$className.java")
    file.writeText(
        """
            package $basePkg.demos;

            import jakarta.annotation.Resource;
            import lombok.extern.slf4j.Slf4j;
            import $basePkg.biz.DemoCase;
            import org.springframework.boot.CommandLineRunner;
            import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
            import org.springframework.core.Ordered;
            import org.springframework.stereotype.Component;

            import java.util.Objects;

            import static $basePkg.biz.Run.detectEffectiveness;
            import static $basePkg.biz.Run.detectProxyType;

            @ConditionalOnProperty(name = "run.only", havingValue = "case${case.sn}", matchIfMissing = true)
            @Component
            @Slf4j
            public class Case${case.sn}Runner implements CommandLineRunner, Ordered {
                @Resource(name = "case${case.sn}AnnotationBaseJavaInterfaceJavaDemo")
                private DemoCase annotationBaseJavaInterfaceJavaDemo;
                @Resource(name = "case${case.sn}AnnotationBaseJavaInterfaceKotlinDemo")
                private DemoCase annotationBaseJavaInterfaceKotlinDemo;
                @Resource(name = "case${case.sn}AnnotationBaseKotlinInterfaceJavaDemo")
                private DemoCase annotationBaseKotlinInterfaceJavaDemo;
                @Resource(name = "case${case.sn}AnnotationBaseKotlinInterfaceKotlinDemo")
                private DemoCase annotationBaseKotlinInterfaceKotlinDemo;
                @Resource(name = "case${case.sn}JavaBaseJavaInterfaceJavaDemo")
                private DemoCase javaBaseJavaInterfaceJavaDemo;
                @Resource(name = "case${case.sn}JavaBaseJavaInterfaceKotlinDemo")
                private DemoCase javaBaseJavaInterfaceKotlinDemo;
                @Resource(name = "case${case.sn}JavaBaseKotlinInterfaceJavaDemo")
                private DemoCase javaBaseKotlinInterfaceJavaDemo;
                @Resource(name = "case${case.sn}JavaBaseKotlinInterfaceKotlinDemo")
                private DemoCase javaBaseKotlinInterfaceKotlinDemo;

                @Override
                public int getOrder() {
                    return Integer.parseInt(annotationBaseJavaInterfaceJavaDemo.sn());
                }

                @Override
                public void run(String... args) {
                    String proxyType = verifyProxyType();
                    if (!"JdkDynamic".equals(proxyType)) {
                        log.info("case ${case.sn} real proxy type is {}", proxyType);
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

        """.trimIndent()
    )
}

data class Case(
    val sn: String,
    val hasClassAnnotationOnInterface: Boolean,
    val originMethodInInterface: OriginMethodInInterface,
    val fallbackInInterface: FallbackInInterface,
    val hasClassAnnotationOnClass: Boolean,
    val originMethodInClass: OriginMethodInClass,
    val hasFallbackInClass: Boolean,
)

enum class OriginMethodInInterface(val isDefault: Boolean, val hasAnnotation: Boolean) {
    DefaultWithAnnotation(true, true),
    DefaultWithoutAnnotation(true, false),
    AbstractWithAnnotation(false, true),
    AbstractWithoutAnnotation(false, false),
    ;
}

enum class FallbackInInterface {
    Default,
    Abstract,
    None,
    ;
}

enum class OriginMethodInClass(val hasAnnotation: Boolean) {
    WithAnnotation(true),
    WithoutAnnotation(false),
    None(false),
    ;
}

enum class ConfigType {
    AnnotationBase,
    JavaBase,
}
