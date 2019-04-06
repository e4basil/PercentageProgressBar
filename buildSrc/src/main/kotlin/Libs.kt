import kotlin.String

/**
 * Generated by https://github.com/jmfayard/buildSrcVersions
 *
 * Update this file with
 *   `$ ./gradlew buildSrcVersions` */
object Libs {
    /**
     * http://tools.android.com */
    const val constraint_layout: String = "com.android.support.constraint:constraint-layout:" +
            Versions.constraint_layout

    /**
     * https://developer.android.com/testing */
    const val espresso_core: String = "com.android.support.test.espresso:espresso-core:" +
            Versions.espresso_core

    /**
     * https://developer.android.com/testing */
    const val com_android_support_test_runner: String = "com.android.support.test:runner:" +
            Versions.com_android_support_test_runner

    /**
     * http://developer.android.com/tools/extras/support-library.html */
    const val appcompat_v7: String = "com.android.support:appcompat-v7:" +
            Versions.com_android_support

    /**
     * http://developer.android.com/tools/extras/support-library.html */
    const val support_annotations: String = "com.android.support:support-annotations:" +
            Versions.com_android_support

    /**
     * https://developer.android.com/studio */
    const val com_android_tools_build_gradle: String = "com.android.tools.build:gradle:" +
            Versions.com_android_tools_build_gradle

    /**
     * https://developer.android.com/studio */
    const val lint_gradle: String = "com.android.tools.lint:lint-gradle:" + Versions.lint_gradle

    /**
     * https://github.com/dcendents/android-maven-gradle-plugin */
    const val android_maven_gradle_plugin: String =
            "com.github.dcendents:android-maven-gradle-plugin:" +
            Versions.android_maven_gradle_plugin

    const val gradle_bintray_plugin: String = "com.jfrog.bintray.gradle:gradle-bintray-plugin:" +
            Versions.gradle_bintray_plugin

    const val de_fayard_buildsrcversions_gradle_plugin: String =
            "de.fayard.buildSrcVersions:de.fayard.buildSrcVersions.gradle.plugin:" +
            Versions.de_fayard_buildsrcversions_gradle_plugin

    /**
     * http://junit.org */
    const val junit: String = "junit:junit:" + Versions.junit

    /**
     * https://kotlinlang.org/ */
    const val kotlin_android_extensions: String =
            "org.jetbrains.kotlin:kotlin-android-extensions:" + Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_gradle_plugin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_stdlib_jdk7: String = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:" +
            Versions.org_jetbrains_kotlin
}
