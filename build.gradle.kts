// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.1.3")
        classpath(kotlin("gradle-plugin", version = "1.3.41"))
//        classpath ("com.diffplug.spotless:spotless-plugin-gradle:3.21.1")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files

        // Required plugins added to classpath to facilitate pushing to Jcenter/Bintray
        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
    }
}

plugins {
    id("de.fayard.buildSrcVersions") version "0.3.2"
    id("com.diffplug.gradle.spotless") version "3.21.1"
}


allprojects {
    repositories {
        google()
        jcenter()
    }


}
//tasks {
//    register("Javadoc") {
//        enabled = false
//    }
//
//}
task("cleanAll", Delete::class) {
    delete = setOf(rootProject.buildDir)
}

ext {
    // validator Library Info
    val libVersionCode = 7
    val libVersionName = "0.1.7"
    val libPomUrl = "https://github.com/e4basil/PercentageProgressBar"
    val libGithubRepo = "e4basil/PercentageProgressBar"
    val libModuleName = "percentageprogressbar"
    val libModuleDesc = "Android library for simple Percentage Progress Bar"
    val libBintrayName = "PercentageProgressBar"


//    gradlew clean build install bintrayUpload -Ppublish=true -PjavadocFlag=true

}

