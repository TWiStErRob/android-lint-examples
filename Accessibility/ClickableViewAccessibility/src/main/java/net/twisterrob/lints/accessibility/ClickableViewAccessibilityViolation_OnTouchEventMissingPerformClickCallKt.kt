package net.twisterrob.lints.accessibility

import android.content.Context
import android.view.MotionEvent
import android.view.View

class ClickableViewAccessibilityViolation_OnTouchEventMissingPerformClickCallKt(
	context: Context
) : View(context) {

	@Suppress("RedundantOverride")
	override fun onTouchEvent(event: MotionEvent): Boolean = super.onTouchEvent(event)

	@Suppress("RedundantOverride")
	override fun performClick(): Boolean = super.performClick()
}
