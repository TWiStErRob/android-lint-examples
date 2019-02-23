package net.twisterrob.lints.correctness;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

@Retention(RetentionPolicy.SOURCE)
@IntDef({1, 2, 1})
@interface UniqueConstantsViolation {
}
