package net.twisterrob.lints.performance;

public class FieldGetterViolationJava {
	private int field;

	public int getField() {
		return field;
	}

	void callGetterInsteadOfUseField() {
		int result = getField();
	}
}
