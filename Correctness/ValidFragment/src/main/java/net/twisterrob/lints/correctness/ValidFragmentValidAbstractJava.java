package net.twisterrob.lints.correctness;


import android.app.Fragment;

import androidx.annotation.NonNull;

abstract class ValidFragmentValidAbstractJava extends Fragment {
	// abstract is fine, it's not instantiatable by JVM anyway

	// even if it's not public

	protected ValidFragmentValidAbstractJava(@NonNull String name) {
		// even if it has an invalid constructor
	}
}
