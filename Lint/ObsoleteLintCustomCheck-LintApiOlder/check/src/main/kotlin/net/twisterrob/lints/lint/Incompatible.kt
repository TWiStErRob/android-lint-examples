package net.twisterrob.lints.lint

import com.android.MissingAndroidSuperClass

/**
 * This class is used to simulate an incompatibility with Lint.
 *
 * It will be loaded via reflection and fail validation:
 * > java.lang.ClassNotFoundException: com.android.MissingAndroidSuperClass
 *
 * @see MissingAndroidSuperClass for more details
 */
@Suppress("unused")
class Incompatible : MissingAndroidSuperClass()
