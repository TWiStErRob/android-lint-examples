package net.twisterrob.lints.interoperability;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface UnknownNullnessViolation {

	String returnNotAnnotated();

	void paramNotAnnotated(String param);

	@Override
	@Nullable String toString();

	@Override
	boolean equals(@NonNull Object obj);
}
