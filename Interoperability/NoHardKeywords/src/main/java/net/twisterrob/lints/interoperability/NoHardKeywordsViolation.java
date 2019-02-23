package net.twisterrob.lints.interoperability;

import androidx.annotation.NonNull;

public interface NoHardKeywordsViolation {
	 boolean in(@NonNull Iterable<String> things);
}
