package net.twisterrob.lints.correctness

import androidx.fragment.app.Fragment

object ValidFragmentViolationAnonymousKt {
	fun newInstance() = object : Fragment() {}
}
