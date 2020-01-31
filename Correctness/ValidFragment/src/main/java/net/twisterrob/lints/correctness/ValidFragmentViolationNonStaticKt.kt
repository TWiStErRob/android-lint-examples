package net.twisterrob.lints.correctness

import androidx.fragment.app.Fragment

class ValidFragmentViolationNonStaticKt {
	inner class Inner : Fragment()
}
