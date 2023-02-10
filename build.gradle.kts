
buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.6.10"

    repositories {
        google()
        maven("https://plugins.gradle.org/m2/")
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
//        classpath ("com.diffplug.spotless:spotless-plugin-gradle:3.21.1")


        classpath("io.github.gradle-nexus:publish-plugin:1.1.0")
    }
}



//allprojects {
//    plugins.withId("com.vanniktech.maven.publish") {
//        mavenPublish {
//            sonatypeHost = "S01"
//        }
//    }
//}

plugins {
    id("de.fayard.buildSrcVersions") version "0.7.0"
    id("com.diffplug.spotless") version "6.15.0"
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

apply {
    from("${rootDir}/scripts/publish-root.gradle")
}

task("cleanAll", Delete::class) {
    delete = setOf(rootProject.buildDir)
}

