package net.twisterrob.lints.correctness;


import androidx.fragment.app.Fragment;

public class ValidFragmentViolationAnonymousJava {
	static Fragment newInstance() {
		return new Fragment() {
		};
	}
}
