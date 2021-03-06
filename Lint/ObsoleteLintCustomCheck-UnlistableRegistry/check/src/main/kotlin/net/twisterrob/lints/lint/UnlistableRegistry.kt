package net.twisterrob.lints.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue

class UnlistableRegistry : IssueRegistry() {

	override val issues: List<Issue> get() = error("Cannot load issues")
}
