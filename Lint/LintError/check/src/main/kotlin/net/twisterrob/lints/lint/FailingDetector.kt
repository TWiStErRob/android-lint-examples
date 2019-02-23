package net.twisterrob.lints.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.*

class FailingRegistry : IssueRegistry() {

	override val api: Int = com.android.tools.lint.detector.api.CURRENT_API

	override val issues: List<Issue> = listOf(FailingDetector.ISSUE)
}

class FailingDetector : Detector() {

	override fun beforeCheckRootProject(context: Context) =
		error("Trigger LintError for ${context.file}")

	companion object {
		val ISSUE = Issue.create(
			"FailingCheck",
			"Just fails",
			"Throws an exception to make sure a LintError is triggered.",
			Category.LINT,
			10,
			Severity.FATAL,
			Implementation(
				FailingDetector::class.java,
				Scope.EMPTY
			)
		)
	}
}
