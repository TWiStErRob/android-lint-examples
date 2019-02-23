package net.twisterrob.lints.usability;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

public class ViewConstructorViolation extends View {
	public ViewConstructorViolation(@NonNull Context context, @NonNull String extra) {
		super(context);
	}
}
