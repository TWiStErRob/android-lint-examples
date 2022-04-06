package net.twisterrob.lints.correctness

import android.app.Fragment

// JVM is unaware of this visibility, Android happily creates instances of this class.
internal class ValidFragmentValidInternalKt : Fragment() 
