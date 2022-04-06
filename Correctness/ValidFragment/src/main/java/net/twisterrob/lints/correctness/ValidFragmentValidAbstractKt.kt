package net.twisterrob.lints.correctness

import android.app.Fragment

// abstract is fine, it's not instantiatable by JVM anyway
// even if it's not public
internal abstract class ValidFragmentValidAbstractKt
// even if it has an invalid constructor
protected constructor(@Suppress("UNUSED_PARAMETER") name: String) : Fragment() 
