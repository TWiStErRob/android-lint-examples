package net.twisterrob.lints.correctness;


import android.app.Fragment;

public class ValidFragmentViolationAnonymousJava {
	static Fragment newInstance() {
		return new Fragment() {
		};
	}
}
