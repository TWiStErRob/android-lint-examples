package net.twisterrob.lints.correctness;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ValidFragmentViolationNonDefaultJava extends Fragment {
	public ValidFragmentViolationNonDefaultJava(@NonNull String name) {
		// Note: this constructor AND class are reported as two separate issues.
	}
}
