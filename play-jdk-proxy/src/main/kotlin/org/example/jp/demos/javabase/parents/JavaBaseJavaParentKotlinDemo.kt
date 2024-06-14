package org.example.jp.demos.javabase.parents

// kotlin spring 插件只会 open 有对应注解的类。这里需要手动 open ，否则编译后仍然是 final 的，会因为无法被 cglib 代理，启动报错。

open class JavaBaseJavaParentKotlinDemo : JavaBaseJavaParentForKotlin()
