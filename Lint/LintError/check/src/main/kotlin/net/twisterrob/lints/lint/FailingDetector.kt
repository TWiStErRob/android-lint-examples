package net.twisterrob.lints.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Context
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity

class FailingRegistry : IssueRegistry() {

	override val vendor: Vendor = Vendor(
		vendorName = "TWiStErRob",
		identifier = "android-lint-examples",
		feedbackUrl = "https://github.com/TWiStErRob/android-lint-examples/issues",
		contact = "https://github.com/TWiStErRob/android-lint-examples"
	)

	override val api: Int = CURRENT_API

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
