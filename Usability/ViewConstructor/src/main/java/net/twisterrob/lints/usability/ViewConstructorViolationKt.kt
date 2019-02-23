package net.twisterrob.lints.usability

import android.content.Context
import android.view.View

class ViewConstructorViolationKt(
	context: Context,
	val extra: String
) : View(context)
