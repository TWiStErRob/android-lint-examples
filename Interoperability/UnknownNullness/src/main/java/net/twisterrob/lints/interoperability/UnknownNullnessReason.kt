package net.twisterrob.lints.interoperability

fun usage(instance: UnknownNullnessViolation): String {
	val result = instance.returnNotAnnotated()
	// definite NullPointerException if it returns null, yet compiles
	return result.trim()
}
