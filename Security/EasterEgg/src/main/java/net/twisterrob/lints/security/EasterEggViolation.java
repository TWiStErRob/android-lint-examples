package net.twisterrob.lints.security;

public class EasterEggViolation {
	/*\u002a\u002f
	void easterEgg() {
		throw new IllegalArgumentException("Easter egg executing");
	}
	/**/
	
	void trigger() {
		easterEgg();
	}
}
