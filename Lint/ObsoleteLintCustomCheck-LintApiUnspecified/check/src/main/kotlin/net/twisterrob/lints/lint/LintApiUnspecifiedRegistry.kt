package net.twisterrob.lints.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.*

class LintApiUnspecifiedRegistry : IssueRegistry() {

	override val issues: List<Issue> = listOf()
}
