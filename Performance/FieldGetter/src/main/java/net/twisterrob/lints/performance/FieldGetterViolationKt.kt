package net.twisterrob.lints.performance

@Suppress("MemberVisibilityCanBePrivate", "unused") // pretend it's used from somewhere else too
class FieldGetterViolationKt {
	@Suppress("RedundantGetter") // this should be clue to to the fix
	val field: Int = 0
		get() = field // force Kotlin to generate getter call

	fun callGetterInsteadOfUseField() {
		// Quite unrealistic, Kotlin knows how to optimize `.getField()` vs `.field`;
		// look at how much work is needed to get it do the wrong thing.
		field
	}
}
