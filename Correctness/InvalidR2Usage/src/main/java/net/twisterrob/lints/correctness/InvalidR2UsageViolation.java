package net.twisterrob.lints.correctness;

import android.view.View;

import net.twisterrob.lints.correctness.InvalidR2Usage.R2;

public class InvalidR2UsageViolation {
	void useR2(View view) {
		view.findViewById(R2.id.title);
	}
}
