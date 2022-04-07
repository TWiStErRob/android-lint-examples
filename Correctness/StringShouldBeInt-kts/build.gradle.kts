plugins {
	// REPORT reverting this to manual fun breaks the detector
	// Force Kotlin DSL fun android(block: com.android.build.gradle.LibraryExtension.() -> Unit) = configure(block)
	id("com.android.library")
}
apply(from = rootProject.file("gradle/module-check-lib.gradle"))
val expectedViolationCount: groovy.lang.Closure<Any?> by project.extra

// REPORT doesn't work with setters, only with method calls
expectedViolationCount(2 /*compile*/ + 1 /*min*/ + 1 /*target*/)

// Need to disable execution path, otherwise Gradle configuration phase would fail.
if (@Suppress("ConstantConditionIf") false) {
	// REPORT doesn't work with configure<com.android.build.gradle.LibraryExtension> { compileSdkVersion("29") }
	android {
		compileSdkVersion("29")
		compileSdkVersion = "29"

		defaultConfig {
			minSdkVersion("14")
			setMinSdkVersion("14")

			targetSdkVersion("28")
			setTargetSdkVersion("28")
		}
	}
}
