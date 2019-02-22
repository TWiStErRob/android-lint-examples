package net.twisterrob.lints.accessibility;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

public class ClickableViewAccessibilityViolation_OnTouchEventMissingPerformClickCall extends View {
	public ClickableViewAccessibilityViolation_OnTouchEventMissingPerformClickCall(
			@NonNull Context context) {
		super(context);
	}

	@Override
	public boolean onTouchEvent(@NonNull MotionEvent event) {
		return super.onTouchEvent(event);
	}

	@Override
	public boolean performClick() {
		return super.performClick();
	}
}
