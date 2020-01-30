package net.twisterrob.lints.correctness;

public class InstantiatableViolationNonPublicClass {
	private static class Inner {
		// There's no other way to make a class private. Only inner classes can be private.
		// REPORT Instantiatable somehow private class still ends up being non-private in ASM
		// if ((classNode.access & Opcodes.ACC_PRIVATE) != 0) is not true for this class
		// because the visibility is hidden in (ClassNode.innerClasses[0] as InnerClassNode).access

		public Inner() {
			// Explicitly make this constructor public to prevent false positive.
			// Implicit default constructor otherwise automatically matches declared class visibility.
		}
	}
}
