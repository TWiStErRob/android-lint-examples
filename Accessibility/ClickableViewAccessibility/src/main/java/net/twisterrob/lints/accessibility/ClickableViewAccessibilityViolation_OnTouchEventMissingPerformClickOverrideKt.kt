package net.twisterrob.lints.accessibility

import android.content.Context
import android.view.MotionEvent
import android.view.View

class ClickableViewAccessibilityViolation_OnTouchEventMissingPerformClickOverrideKt(
	context: Context
) : View(context) {

	@Suppress("RedundantOverride")
	override fun onTouchEvent(event: MotionEvent): Boolean {
		return super.onTouchEvent(event)
	}
}
