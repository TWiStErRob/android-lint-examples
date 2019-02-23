package net.twisterrob.lints.internationalization

import java.util.*

private val ConstantLocaleViolation_TopLevel = Locale.getDefault()

class ConstantLocaleViolation_Companion {
	companion object {
		private val SUSPICIOUS_STORAGE = Locale.getDefault()
	}
}

object ConstantLocaleViolation_Object {
	private val SUSPICIOUS_STORAGE = Locale.getDefault()
}
