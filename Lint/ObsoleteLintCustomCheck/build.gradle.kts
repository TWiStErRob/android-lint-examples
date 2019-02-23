import groovy.lang.Closure
import java.util.jar.JarFile

apply {
	from(rootProject.file("gradle/module-check-lib.gradle"))
}

val expectedViolationCount: Closure<Unit> by ext
expectedViolationCount(4)

// Workaround for "Found more than one jar in the 'lintChecks' configuration."
val lintChecksJars by configurations.creating

dependencies {
	lintChecksJars(project("LintApiNewer"))
	lintChecksJars(project("LintApiOlder"))
	lintChecksJars(project("LintApiUnspecified"))
	lintChecksJars(project("UninstantiatableRegistry"))
}

// REPORT META-INF/services/com.android.tools.lint.client.api.IssueRegistry doesn't support multiple registries
// because com.android.tools.lint.client.api.JarFileIssueRegistry.Factory.get uses a cache per jar
val registryService = "com.android.tools.lint.client.api.IssueRegistry"

// generate a file to be consumed by this feature: https://groups.google.com/forum/#!topic/lint-dev/eCxw9PdTpVI
val lintChecksFatServices by tasks.registering {
	val file = project.buildDir.resolve("intermediates/lint-registry/$registryService")
	inputs.files(lintChecksJars)
	outputs.file(file)
	doLast {
		val serviceLocator = "META-INF/services/$registryService"
		val registries = lintChecksJars.files.map { lintChecksJar ->
			val jar = JarFile(lintChecksJar)
			val registry = jar.manifest.mainAttributes.getValue("Lint-Registry-v2")
			if (registry != null) {
				registry
			} else {
				val entry = jar.getJarEntry(serviceLocator)
				jar.getInputStream(entry).reader().use { it.readText() }
			}
		}
		file.writeText(registries.joinToString(System.lineSeparator()))
	}
}
val lintChecksFatJar by tasks.registering(Jar::class) {
	dependsOn(lintChecksFatServices)
	// don't emit manifest.attributes("Lint-Registry-v2": fqcn), so JarFileIssueRegistry will look at
	// META-INF/services/com.android.tools.lint.client.api.IssueRegistry
	baseName = "lint-checks"
	classifier = "fat"
	from(configurations["lintChecksJars"].map { zipTree(it) })
	from(lintChecksFatServices) {
		into("META-INF/services")
	}
}

val lintChecks by configurations

dependencies {
	lintChecks(files(lintChecksFatJar))
}
