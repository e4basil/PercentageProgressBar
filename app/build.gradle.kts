plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
//    kotlin("kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.android.basi.progressapp"
        minSdkVersion(15)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

        consumerProguardFiles("proguard-file.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
//            proguardFiles(getDefaultProguardFile("proguard-android.txt"))
//            val files = rootProject.file("proguard")
//                .listFiles()
//                .filter { it.name.startsWith("proguard") }
//                .toTypedArray()
//
//            proguardFiles(*files)

        }

//        create("debugMini") {
//            initWith(getByName("debug"))
//            isMinifyEnabled = true
//            isShrinkResources = true
//            isUseProguard = true
//            proguardFiles(getDefaultProguardFile("proguard-android.txt"))
//
//            val files = rootProject.file("proguard")
//                .listFiles()
//                .filter { it.name.startsWith("proguard") }
//                .toTypedArray()
//
//            proguardFiles(*files)
//            matchingFallbacks = listOf("debug")
//
//        }


//        create("debugAdvance") {
//            initWith(getByName("debug"))
//            isMinifyEnabled = true
//            isShrinkResources = true
//            isUseProguard = true
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
//            val files = rootProject.file("proguard")
//                .listFiles()
//                .filter { it.name.startsWith("proguard") }
//                .toTypedArray()
//
//            proguardFiles(*files)
//            matchingFallbacks = listOf("debug")
//        }

    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":progressbar"))
    implementation(kotlin("stdlib-jdk7", Versions.org_jetbrains_kotlin))
//    implementation("com.android.support:appcompat-v7:28.0.0")
    implementation(Libs.appcompat_v7)
//    implementation("com.android.support:support-annotations:28.0.0")
    implementation(Libs.support_annotations)
//    implementation("com.android.support.constraint:constraint-layout:1.1.3")
    implementation(Libs.constraint_layout)

//    testImplementation("junit:junit:4.12")
    testImplementation(Libs.junit)
//    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation(Libs.com_android_support_test_runner)
//    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
    androidTestImplementation(Libs.espresso_core)
}
