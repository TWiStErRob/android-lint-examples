package net.twisterrob.lints.correctness

import android.view.View
import net.twisterrob.lints.correctness.InvalidR2Usage.R2

fun useR2(view: View) {
	view.findViewById<View>(R2.id.title)
}
