package net.twisterrob.lints.accessibility

import android.view.View

fun onTouchListenerNotCallingPerformClick(view: View) {
	// REPORT Kotlin lambdas and SAMs are not detected
	view.setOnTouchListener { _, _ -> true }
	view.setOnTouchListener(View.OnTouchListener { _, _ -> true })
}
