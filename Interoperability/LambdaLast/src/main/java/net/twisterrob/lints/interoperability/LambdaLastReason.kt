package net.twisterrob.lints.interoperability

fun usageDemonstration(instance: LambdaLastViolation, param: Int) {
	instance.samConversionCandidate({}, param)
	// instead of
	//instance.samConversionCandidate(param) {}
}
