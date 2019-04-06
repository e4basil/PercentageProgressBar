plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
//    kotlin("kapt")
}

android {
    compileSdkVersion(28)

    defaultConfig {
        minSdkVersion(15)
        targetSdkVersion(28)
        versionCode = 7
        versionName = "0.1.7"

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

apply(from="./scripts/bintrayConfig.gradle")