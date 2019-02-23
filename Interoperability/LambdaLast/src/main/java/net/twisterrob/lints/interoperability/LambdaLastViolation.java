package net.twisterrob.lints.interoperability;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

public interface LambdaLastViolation {
	void samConversionCandidate(@NonNull SingleAbstractMethod lambda, int secondParamHides);

	// REPORT potential false positive: Can't reasonably move either of the lambdas last,
	// because none of them is more important than the other.
	// Think of a conversion/mapping method with two strategies and some data passed in.
	@SuppressLint("LambdaLast")
	void samConversionCandidate(
			@NonNull SingleAbstractMethod lambda,
			@NonNull SingleAbstractMethod lambda2,
			int secondParamHides
	);
}

interface SingleAbstractMethod {
	void doSomething();
}
