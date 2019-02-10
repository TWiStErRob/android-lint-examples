package net.twisterrob.lints.correctness;

import androidx.annotation.NonNull;

public class SyntheticAccessorViolation {
	private String privateField = "access me, if you dare";

	static class Inner {
		static void usePrivateField(@NonNull SyntheticAccessorViolation instance) {
			System.out.println(instance.privateField);
		}
	}
}
