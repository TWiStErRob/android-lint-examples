package net.twisterrob.lints.correctness

import android.app.Fragment

// REPORT JVM is unaware of this visibility, Android happily creates instances of this class.
internal class ValidFragmentViolationInternalKt : Fragment() 
