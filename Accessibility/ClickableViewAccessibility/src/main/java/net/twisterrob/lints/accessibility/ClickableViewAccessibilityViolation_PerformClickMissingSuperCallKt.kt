package net.twisterrob.lints.accessibility

import android.content.Context
import android.view.View

class ClickableViewAccessibilityViolation_PerformClickMissingSuperCallKt(
	context: Context
) : View(context) {

	override fun performClick(): Boolean = true
}
