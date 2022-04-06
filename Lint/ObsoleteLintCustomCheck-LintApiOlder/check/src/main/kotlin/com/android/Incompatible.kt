package com.android

class Incompatible {
	companion object {
		init {
			error("Fake incompatibility to throw com.android.tools.lint.client.api.LintJarVerifier.")
		}
	}
}
