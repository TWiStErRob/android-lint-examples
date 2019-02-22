package net.twisterrob.lints.accessibility;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

public class ClickableViewAccessibilityViolation_PerformClickMissingSuperCall extends View {
	public ClickableViewAccessibilityViolation_PerformClickMissingSuperCall(
			@NonNull Context context) {
		super(context);
	}

	@Override
	public boolean performClick() {
		return true;
	}
}
