apply(plugin="com.diffplug.gradle.spotless")

spotless {
    java {
        target("**/*.java")
        trimTrailingWhitespace()
        removeUnusedImports()
        googleJavaFormat()
        endWithNewline()
    }
    kotlin {
        target ("**/*.kt")
        // optionally takes a version
        ktlint()
        // Optional user arguments can be set as such:
//        ktlint().userData(['indent_size': '2', 'continuation_indent_size' : '2'])
//        licenseHeaderFile ("../spotless.license.kt")
        trimTrailingWhitespace()
        endWithNewline()
//        ignoreErrorForPath("library/src/test/java/com/afollestad/vvalidator/form/FormTest.kt")
    }
    kotlinGradle {
        // same as kotlin, but for .gradle.kts files (defaults to '*.gradle.kts')
        target ("*.gradle.kts', 'additionalScripts/*.gradle.kts")

        ktlint()

        // Optional user arguments can be set as such:
//        ktlint().userData(['indent_size': '2', 'continuation_indent_size' : '2'])

        // doesn't support licenseHeader, because scripts don't have a package statement
        // to clearly mark where the license should go
    }
}
