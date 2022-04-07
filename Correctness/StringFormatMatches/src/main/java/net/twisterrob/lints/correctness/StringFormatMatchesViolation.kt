package net.twisterrob.lints.correctness

import android.content.res.Resources
import net.twisterrob.lints.correctness.StringFormatMatches.R

fun format(res: Resources) = listOf(
	res.getString(R.string.invalid, "text"),
	res.getString(R.string.suspicious, 42),
	res.getString(R.string.mismatched_count, "text")
)
