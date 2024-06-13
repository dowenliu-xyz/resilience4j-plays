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
    create("genParentsMatrix") {
        val input = "src/main/java/org/example/ae/parents_matrix.md"
        val distSrc = "src"
        val basePkg = "org.example.ae"
        doLast {
            val cases = readMatrix(input)
            cases.forEach { genCase(distSrc, basePkg, it) }
        }
    }
}

enum class OriginMethod {
    YesWithAnno,
    YesWithoutAnno,
    No,
}

data class Case(
    val sn: String,
    val classAnnoOnSuper: Boolean,
    val originMethodInSuper: OriginMethod,
    val fallbackInSuper: Boolean,
    val classAnnoOnSub: Boolean,
    val originMethodInSub: OriginMethod,
    val fallbackInSub: Boolean,
)

fun readMatrix(input: String): List<Case> {
    val lines = File(input).readLines().drop(2)
    return lines.mapNotNull(::parseMatrixLine)
}

fun parseMatrixLine(line: String): Case? {
    val parts = line.split('|').map(String::trim)
    parts[1].startsWith("~~") && return null
    val sn = parts[1].removeSuffix("*")
    val classAnnoOnSuper = when (parts[2]) {
        "Yes" -> true
        "No" -> false
        else -> throw IllegalArgumentException("Unknown value: ${parts[2]}")
    }
    val originMethodInSuper = when (parts[3]) {
        "Yes with anno" -> OriginMethod.YesWithAnno
        "Yes without anno" -> OriginMethod.YesWithoutAnno
        "No" -> OriginMethod.No
        else -> throw IllegalArgumentException("Unknown value: ${parts[3]}")
    }
    val fallbackInSuper = when (parts[4]) {
        "Yes" -> true
        "No" -> false
        else -> throw IllegalArgumentException("Unknown value: ${parts[4]}")
    }
    val classAnnoOnSub = when (parts[5]) {
        "Yes" -> true
        "No" -> false
        else -> throw IllegalArgumentException("Unknown value: ${parts[5]}")
    }
    val originMethodInSub = when (parts[6]) {
        "Yes with anno" -> OriginMethod.YesWithAnno
        "Yes without anno" -> OriginMethod.YesWithoutAnno
        "No" -> OriginMethod.No
        else -> throw IllegalArgumentException("Unknown value: ${parts[6]}")
    }
    val fallbackInSub = when (parts[7]) {
        "Yes" -> true
        "No" -> false
        else -> throw IllegalArgumentException("Unknown value: ${parts[7]}")
    }
    return Case(
        sn,
        classAnnoOnSuper,
        originMethodInSuper,
        fallbackInSuper,
        classAnnoOnSub,
        originMethodInSub,
        fallbackInSub,
    )
}

fun genCase(distSrc: String, basePkg: String, case: Case) {
    val javaPackagePath = "$distSrc/main/java/${basePkg.replace('.', '/')}/demos/parents"
    mkdir(javaPackagePath)
    val kotlinPackagePath = "$distSrc/main/kotlin/${basePkg.replace('.', '/')}/demos/parents"
    mkdir(kotlinPackagePath)
    generateJavaParent(javaPackagePath, basePkg, case, "Java")
    generateJavaDemo(javaPackagePath, basePkg, case, "Java")
    generateJavaParent(javaPackagePath, basePkg, case, "Kotlin")
    generateKotlinDemo(kotlinPackagePath, basePkg, case, "Java")
    generateKotlinParent(kotlinPackagePath, basePkg, case, "Java")
    generateJavaDemo(javaPackagePath, basePkg, case, "Kotlin")
    generateKotlinParent(kotlinPackagePath, basePkg, case, "Kotlin")
    generateKotlinDemo(kotlinPackagePath, basePkg, case, "Kotlin")
}

fun generateJavaParent(path: String, basePkg: String, case: Case, subLang: String) {
    val className = "ParentCase${case.sn}JavaParentFor$subLang"
    val file = File("$path/$className.java")
    if (file.exists()) file.delete()
    file.createNewFile()
    file.appendText(
        """
                    |// Generated by genParentsMatrix task, DO NOT MODIFY
                    |package $basePkg.demos.parents;
                    |
                    |import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
        """.trimMargin()
    )
    if (case.fallbackInSuper || case.originMethodInSub == OriginMethod.No) {
        file.appendText(
            """
                    |
                    |import $basePkg.biz.Greeting;
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |import org.jetbrains.annotations.NotNull;
                    |import org.jetbrains.annotations.Nullable;
                    |
                    |@SuppressWarnings("unused")
        """.trimMargin()
    )
    if (case.classAnnoOnSuper) {
        file.appendText(
            """
                    |
                    |@CircuitBreaker(name = "demo", fallbackMethod = "superClassFallback")
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |public class $className {
        """.trimMargin()
    )
    if (case.originMethodInSuper != OriginMethod.No) {
        if (case.originMethodInSuper == OriginMethod.YesWithAnno) {
            file.appendText(
                """
                    |
                    |    @CircuitBreaker(name = "demo", fallbackMethod = "superFallback")
                """.trimMargin()
            )
        }
        val `return` = if (case.originMethodInSub != OriginMethod.No) {
            "\"parent: hello \" + name"
        } else {
            "Greeting.doGreeting(name)"
        }
        file.appendText(
            """
                    |
                    |    @NotNull
                    |    public String greeting(@Nullable String name) {
                    |        return $`return`;
                    |    }
            """.trimMargin()
        )
    }
    if (case.fallbackInSuper) {
        val modifier = if (case.fallbackInSub) "protected" else "private"
        file.appendText(
            """
                    |
                    |
                    |    @NotNull
                    |    $modifier String superClassFallback(@Nullable String name, @Nullable Throwable e) {
                    |        return TakeEffectAnno.SuperClassAnno + ":" + FallbackLocation.Super + ":" + Greeting.doFallback(name, e);
                    |    }
                    |
                    |    @NotNull
                    |    $modifier String superFallback(@Nullable String name, @Nullable Throwable e) {
                    |        return TakeEffectAnno.SuperMethodAnno + ":" + FallbackLocation.Super + ":" + Greeting.doFallback(name, e);
                    |    }
                    |
                    |    @NotNull
                    |    $modifier String classFallback(@Nullable String name, @Nullable Throwable e) {
                    |        return TakeEffectAnno.SubClassAnno + ":" + FallbackLocation.Super + ":" + Greeting.doFallback(name, e);
                    |    }
                    |
                    |    @NotNull
                    |    $modifier String fallback(@Nullable String name, @Nullable Throwable e) {
                    |        return TakeEffectAnno.SubMethodAnno + ":" + FallbackLocation.Super + ":" + Greeting.doFallback(name, e);
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

fun generateJavaDemo(path: String, basePkg: String, case: Case, parentLang: String) {
    val className = "ParentCase${case.sn}${parentLang}ParentJavaDemo"
    val file = File("$path/$className.java")
    if (file.exists()) file.delete()
    file.createNewFile()
    file.appendText(
        """
                    |// Generated by genParentsMatrix task, DO NOT MODIFY
                    |package $basePkg.demos.parents;
                    |
                    |import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
        """.trimMargin()
    )
    if (case.fallbackInSub || case.originMethodInSub != OriginMethod.No) {
        file.appendText(
            """
                    |
                    |import $basePkg.biz.Greeting;
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |import org.jetbrains.annotations.NotNull;
                    |import org.jetbrains.annotations.Nullable;
                    |import org.springframework.stereotype.Component;
                    |
                    |@SuppressWarnings("unused")
                    |@Component
        """.trimMargin()
    )
    if (case.classAnnoOnSub) {
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
                    |public class $className extends ParentCase${case.sn}${parentLang}ParentForJava {
        """.trimMargin()
    )
    if (case.originMethodInSub != OriginMethod.No) {
        if (case.originMethodInSub == OriginMethod.YesWithAnno) {
            file.appendText(
                """
                    |
                    |    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
                """.trimMargin()
            )
        }
        file.appendText(
            """
                    |
                    |    @NotNull
        """.trimMargin()
        )
        if (case.originMethodInSuper != OriginMethod.No) {
            file.appendText(
                """
                    |
                    |    @Override
            """.trimMargin()
            )
        }
        file.appendText(
            """
                    |
                    |    public String greeting(@Nullable String name) {
                    |        return Greeting.doGreeting(name);
                    |    }
        """.trimMargin()
        )
    }
    if (case.fallbackInSub) {
        val (anno, visibility) = if (case.fallbackInSuper) "@Override\n    " to "protected" else "" to "private"
        file.appendText(
            """
                    |
                    |
                    |    @NotNull
                    |    $anno$visibility String superClassFallback(@Nullable String name, @Nullable Throwable e) {
                    |        return TakeEffectAnno.SuperClassAnno + ":" + FallbackLocation.Sub + ":" + Greeting.doFallback(name, e);
                    |    }
                    |
                    |    @NotNull
                    |    $anno$visibility String superFallback(@Nullable String name, @Nullable Throwable e) {
                    |        return TakeEffectAnno.SuperMethodAnno + ":" + FallbackLocation.Sub + ":" + Greeting.doFallback(name, e);
                    |    }
                    |
                    |    @NotNull
                    |    $anno$visibility String classFallback(@Nullable String name, @Nullable Throwable e) {
                    |        return TakeEffectAnno.SubClassAnno + ":" + FallbackLocation.Sub + ":" + Greeting.doFallback(name, e);
                    |    }
                    |
                    |    @NotNull
                    |    $anno$visibility String fallback(@Nullable String name, @Nullable Throwable e) {
                    |        return TakeEffectAnno.SubMethodAnno + ":" + FallbackLocation.Sub + ":" + Greeting.doFallback(name, e);
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

fun generateKotlinParent(path: String, basePkg: String, case: Case, subLang: String) {
    val className = "ParentCase${case.sn}KotlinParentFor$subLang"
    val file = File("$path/$className.kt")
    if (file.exists()) file.delete()
    file.createNewFile()
    file.appendText(
        """
                    |// Generated by genParentsMatrix task, DO NOT MODIFY
                    |package $basePkg.demos.parents
                    |
                    |import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
        """.trimMargin()
    )
    if (case.fallbackInSuper || case.originMethodInSub == OriginMethod.No) {
        file.appendText(
            """
                    |
                    |import $basePkg.biz.Greeting
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |
                    |@Suppress("unused", "UNUSED_PARAMETER")
        """.trimMargin()
    )
    if (case.classAnnoOnSuper) {
        file.appendText(
            """
                    |
                    |@CircuitBreaker(name = "demo", fallbackMethod = "superClassFallback")
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |open class $className {
        """.trimMargin()
    )
    if (case.originMethodInSuper != OriginMethod.No) {
        if (case.originMethodInSuper == OriginMethod.YesWithAnno) {
            file.appendText(
                """
                    |
                    |    @CircuitBreaker(name = "demo", fallbackMethod = "superFallback")
                """.trimMargin()
            )
        }
        val `return` = if (case.originMethodInSub != OriginMethod.No) {
            "\"parent: hello ${"$"}name\""
        } else {
            "Greeting.doGreeting(name)"
        }
        file.appendText(
            """
                    |
                    |    open fun greeting(name: String?): String {
                    |        return $`return`
                    |    }
            """.trimMargin()
        )
    }
    if (case.fallbackInSuper) {
        val modifier = if (case.fallbackInSub) "protected open" else "private"
        file.appendText(
            """
                    |
                    |
                    |    $modifier fun superClassFallback(name: String?, e: Throwable?): String {
                    |        return "${"$"}{TakeEffectAnno.SuperClassAnno}:${"$"}{FallbackLocation.Super}:${"$"}{Greeting.doFallback(name, e)}"
                    |    }
                    |
                    |    $modifier fun superFallback(name: String?, e: Throwable?): String {
                    |        return "${"$"}{TakeEffectAnno.SuperMethodAnno}:${"$"}{FallbackLocation.Super}:${"$"}{Greeting.doFallback(name, e)}"
                    |    }
                    |
                    |    $modifier fun classFallback(name: String?, e: Throwable?): String {
                    |        return "${"$"}{TakeEffectAnno.SubClassAnno}:${"$"}{FallbackLocation.Super}:${"$"}{Greeting.doFallback(name, e)}"
                    |    }
                    |
                    |    $modifier fun fallback(name: String?, e: Throwable?): String {
                    |        return "${"$"}{TakeEffectAnno.SubMethodAnno}:${"$"}{FallbackLocation.Super}:${"$"}{Greeting.doFallback(name, e)}"
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

fun generateKotlinDemo(path: String, basePkg: String, case: Case, parentLang: String) {
    val className = "ParentCase${case.sn}${parentLang}ParentKotlinDemo"
    val file = File("$path/$className.kt")
    if (file.exists()) file.delete()
    file.createNewFile()
    file.appendText(
        """
                    |// Generated by genParentsMatrix task, DO NOT MODIFY
                    |package $basePkg.demos.parents
                    |
                    |import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
        """.trimMargin()
    )
    if (case.fallbackInSub || case.originMethodInSub != OriginMethod.No) {
        file.appendText(
            """
                    |
                    |import $basePkg.biz.Greeting
            """.trimMargin()
        )
    }
    file.appendText(
        """
                    |
                    |import org.springframework.stereotype.Component
                    |
                    |@Suppress("unused", "UNUSED_PARAMETER")
                    |@Component
        """.trimMargin()
    )
    if (case.classAnnoOnSub) {
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
                    |class $className : ParentCase${case.sn}${parentLang}ParentForKotlin() {
        """.trimMargin()
    )
    if (case.originMethodInSub != OriginMethod.No) {
        if (case.originMethodInSub == OriginMethod.YesWithAnno) {
            file.appendText(
                """
                    |
                    |    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
                """.trimMargin()
            )
        }
        val modifier = if (case.originMethodInSuper != OriginMethod.No) "override" else ""
        file.appendText(
            """
                    |
                    |    $modifier fun greeting(name: String?): String {
                    |        return Greeting.doGreeting(name)
                    |    }
                """.trimMargin()
        )
    }
    if (case.fallbackInSub) {
        val modifier = if (case.fallbackInSuper) "override" else "private"
        file.appendText(
            """
                    |
                    |
                    |    $modifier fun superClassFallback(name: String?, e: Throwable?): String {
                    |        return "${"$"}{TakeEffectAnno.SuperClassAnno}:${"$"}{FallbackLocation.Sub}:${"$"}{Greeting.doFallback(name, e)}"
                    |    }
                    |
                    |    $modifier fun superFallback(name: String?, e: Throwable?): String {
                    |        return "${"$"}{TakeEffectAnno.SuperMethodAnno}:${"$"}{FallbackLocation.Sub}:${"$"}{Greeting.doFallback(name, e)}"
                    |    }
                    |
                    |    $modifier fun classFallback(name: String?, e: Throwable?): String {
                    |        return "${"$"}{TakeEffectAnno.SubClassAnno}:${"$"}{FallbackLocation.Sub}:${"$"}{Greeting.doFallback(name, e)}"
                    |    }
                    |
                    |    $modifier fun fallback(name: String?, e: Throwable?): String {
                    |        return "${"$"}{TakeEffectAnno.SubMethodAnno}:${"$"}{FallbackLocation.Sub}:${"$"}{Greeting.doFallback(name, e)}"
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