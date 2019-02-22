package net.twisterrob.lints.accessibility;

import android.view.MotionEvent;
import android.view.View;

public class ClickableViewAccessibilityViolation_OnTouchListenerNotCallingPerformClick {

	void anonymousInnerClass(View view) {
		//noinspection Convert2Lambda
		view.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				return true;
			}
		});
	}

	void lambda(View view) {
		view.setOnTouchListener((View touchedView, MotionEvent event) -> true);
	}
}
