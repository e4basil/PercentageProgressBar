plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdk = 28

    defaultConfig {
        minSdk = 15
        targetSdk = 31
//        versionCode = 8
//        versionName = "0.1.8"

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", Versions.org_jetbrains_kotlin))
    implementation(Libs.appcompat_v7)
    implementation(Libs.support_annotations)
    implementation(Libs.constraint_layout)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.com_android_support_test_runner)
    androidTestImplementation(Libs.espresso_core)
}


apply(from = "$rootDir/spotless.gradle")
apply(from = "$rootDir/scripts/publish-module.gradle")

