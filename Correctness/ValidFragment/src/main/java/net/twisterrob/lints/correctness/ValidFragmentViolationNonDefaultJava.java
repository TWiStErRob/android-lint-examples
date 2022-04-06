package net.twisterrob.lints.correctness;

import android.app.Fragment;

import androidx.annotation.NonNull;

public class ValidFragmentViolationNonDefaultJava extends Fragment {
	public ValidFragmentViolationNonDefaultJava(@NonNull String name) {
		// Note: this constructor AND class are reported as two separate issues.
	}
}
