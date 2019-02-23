package net.twisterrob.lints.interoperability;

import androidx.annotation.Nullable;

public class KotlinPropertyAccessViolation extends API {

	public void setNonPublic(@Nullable String value) {
	}

	@Nullable String getNonPublic() {
		return null;
	}


	public void setStatic(@Nullable String value) {
	}

	public static @Nullable String getStatic() {
		return null;
	}


	public void setMismatchedType(@Nullable String value) {
	}

	public int getMismatchedType() {
		return 0;
	}


	public void setInherited(@Nullable Integer value) {
	}

	@Override
	public @Nullable Integer getInherited() {
		return null;
	}


	public void setIsWrongSetter(boolean value) {
	}

	public boolean isWrongSetter() {
		return false;
	}


	public void setWrongGetter(boolean value) {
	}

	public boolean wrongGetter() {
		return false;
	}
}

