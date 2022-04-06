package net.twisterrob.lints.correctness

import android.app.Fragment

object ValidFragmentViolationAnonymousKt {
	fun newInstance() = object : Fragment() {}
}
