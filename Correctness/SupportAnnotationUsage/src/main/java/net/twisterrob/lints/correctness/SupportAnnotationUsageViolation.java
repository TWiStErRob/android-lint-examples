package net.twisterrob.lints.correctness;

import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.HalfFloat;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;

public abstract class SupportAnnotationUsageViolation {

	@CheckResult
	abstract void noReturnValue();

	@IntRange(from = 2, to = 1)
	int wrongOrderRange;

	@Size(min = 2, max = 1)
	String wrongOrderSize;

	@Size(multiple = 0)
	String invalidMultiple;

	@Size(value = -1)
	String invalidSize;

	@ColorInt
	String colorNonInteger;

	@RequiresPermission(value = "multiple", allOf = "multiple", anyOf = "multiple")
	abstract void multiplePermissions();

	@RequiresPermission
	abstract void missingPermissions();

	@HalfFloat
	int invalidHalfFloat;

	@IdRes
	String invalidResource;
}
