package net.twisterrob.lints.correctness

import android.app.Fragment

class ValidFragmentViolationNonStaticKt {
	inner class Inner : Fragment()
}
