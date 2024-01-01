package com.android;

/**
 * This class is used to simulate an incompatibility with Lint.
 * <p>
 * This interface will be used in a check JAR at compile time, but will be missing at runtime.
 * This exists to trigger com.android.tools.lint.client.api.LintJarVerifier validation.
 * {@code LintJarVerifier} checks for something that starts with {@code com.android.} in {@code LintJarVerifier#isRelevantApi}.
 * This interface will trigger that relevancy check because it's in the right package.
 * {@code LintJarVerifier#getClass} will try to load the implementing class,
 * and fail verification, because this class will not be on the classpath of Lint.
 */
public class MissingAndroidSuperClass {
}
