package net.twisterrob.lints.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.Issue

class LintApiOlderRegistry : IssueRegistry() {

	override val vendor: Vendor = Vendor(
		vendorName = "TWiStErRob",
		identifier = "android-lint-examples",
		feedbackUrl = "https://github.com/TWiStErRob/android-lint-examples/issues",
		contact = "https://github.com/TWiStErRob/android-lint-examples"
	)

	override val issues: List<Issue> = listOf()

	override val api: Int = 0
}
