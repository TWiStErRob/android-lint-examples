package net.twisterrob.lints.accessibility

import android.content.Context
import android.view.MotionEvent
import android.view.View

fun callSetOnTouchListenerOnViewWithoutPerformClick(customView: CustomViewWithoutPerformClick) {
	customView.setOnTouchListener { view: View, _: MotionEvent -> view.performClick() }
}

class CustomViewWithoutPerformClick(context: Context) : View(context)
