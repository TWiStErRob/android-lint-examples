package net.twisterrob.lints.accessibility;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

public class ClickableViewAccessibilityViolation_OnTouchListenerCustomViewMissingPerformClick {

	void setup(CustomViewWithoutPerformClick customView) {
		customView.setOnTouchListener((View view, MotionEvent event) -> view.performClick());
	}

	public static class CustomViewWithoutPerformClick extends View {
		public CustomViewWithoutPerformClick(@NonNull Context context) {
			super(context);
		}
	}
}
