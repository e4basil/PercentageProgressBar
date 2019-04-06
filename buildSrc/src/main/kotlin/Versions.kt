import kotlin.String

/**
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
    const val constraint_layout: String = "1.1.3" 

    const val espresso_core: String = "3.0.2" 

    const val com_android_support_test_runner: String = "1.0.2" 

    const val com_android_support: String = "28.0.0" 

    const val com_android_tools_build_gradle: String = "3.3.2" 

    const val lint_gradle: String = "26.3.2" 

    const val android_maven_gradle_plugin: String = "2.1" 

    const val gradle_bintray_plugin: String = "1.8.4" 

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.3.2" 

    const val junit: String = "4.12" 

    const val org_jetbrains_kotlin: String = "1.3.21" 

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "4.10.1"

        const val currentVersion: String = "5.3.1"

        const val nightlyVersion: String = "5.5-20190406000105+0000"

        const val releaseCandidate: String = ""
    }
}
