package net.twisterrob.lints.correctness;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

abstract class ValidFragmentValidAbstractJava extends Fragment {
	// abstract is fine, it's not instantiatable by JVM anyway

	// even if it's not public

	protected ValidFragmentValidAbstractJava(@NonNull String name) {
		// even if it has an invalid constructor
	}
}
