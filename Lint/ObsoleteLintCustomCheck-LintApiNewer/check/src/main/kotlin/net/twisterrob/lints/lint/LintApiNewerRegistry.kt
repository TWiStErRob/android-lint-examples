package net.twisterrob.lints.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.*

class LintApiNewerRegistry : IssueRegistry() {

	override val issues: List<Issue> = emptyList()

	override val api: Int = Int.MAX_VALUE
}
