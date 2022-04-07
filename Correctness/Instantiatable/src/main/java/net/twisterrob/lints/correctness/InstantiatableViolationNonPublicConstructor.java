package net.twisterrob.lints.correctness;

public class InstantiatableViolationNonPublicConstructor {
	// REPORT false negative: there's no complaint if this constructor is default visible.
	private InstantiatableViolationNonPublicConstructor() {
	}
}
