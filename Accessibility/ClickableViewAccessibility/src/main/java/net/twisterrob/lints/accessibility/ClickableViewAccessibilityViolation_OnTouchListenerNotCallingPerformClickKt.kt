package net.twisterrob.lints.accessibility

import android.view.View

fun onTouchListenerNotCallingPerformClick(view: View) {
	view.setOnTouchListener { _, _ -> true }
	view.setOnTouchListener(View.OnTouchListener { _, _ -> true })
}
