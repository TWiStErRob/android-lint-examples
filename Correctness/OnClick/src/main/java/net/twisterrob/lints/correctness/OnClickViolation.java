package net.twisterrob.lints.correctness;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static net.twisterrob.lints.correctness.OnClick.R.layout;

public class OnClickViolation extends Activity {

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layout.view);
	}

	public void existingCorrectHandler(@NonNull View v) {
	}

	public void missingViewParameter() {
	}

	public void extraParameter(@NonNull View v, int position) {
	}

	void notVisibleEnough(@NonNull View v) {
	}
}
