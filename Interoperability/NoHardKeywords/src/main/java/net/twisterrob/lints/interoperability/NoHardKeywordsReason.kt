package net.twisterrob.lints.interoperability

fun caller(instance: NoHardKeywordsViolation, data: List<String>) {
	check(instance.`in`(data))
}
