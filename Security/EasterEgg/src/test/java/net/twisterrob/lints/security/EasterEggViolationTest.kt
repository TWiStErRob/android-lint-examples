package net.twisterrob.lints.security

import org.junit.Test
import kotlin.test.assertFailsWith

class EasterEggViolationTest {

	/**
	 * to prove it compiles and commented-looking code executes
	 */
	@Test
	fun `check EasterEgg actually executed`() {
		assertFailsWith<IllegalArgumentException>("Easter egg executing") {
			EasterEggViolation().trigger()
		}
	}
}
