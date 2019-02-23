package net.twisterrob.lints.internationalization;

import android.widget.TextView;

public class SetTextI18nViolation {

	void literal(TextView textView) {
		textView.setText("Hello");
	}

	void numberFormat(TextView textView, Integer number) {
		textView.setText(number.toString());
	}

	void concatenation(TextView textView, String prefix, String suffix) {
		textView.setText(prefix + suffix);
	}
}
