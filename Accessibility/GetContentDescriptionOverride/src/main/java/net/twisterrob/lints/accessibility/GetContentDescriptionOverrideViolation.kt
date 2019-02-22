package net.twisterrob.lints.accessibility

import android.content.Context
import android.view.View

class GetContentDescriptionOverrideViolationKt(context: Context) : View(context) {

	@Suppress("RedundantOverride")
	override fun getContentDescription(): CharSequence = super.getContentDescription()
}
