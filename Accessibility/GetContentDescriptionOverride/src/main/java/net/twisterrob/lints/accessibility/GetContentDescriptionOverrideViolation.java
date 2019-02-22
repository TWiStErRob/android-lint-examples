package net.twisterrob.lints.accessibility;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

public class GetContentDescriptionOverrideViolation extends View {

	public GetContentDescriptionOverrideViolation(@NonNull Context context) {
		super(context);
	}

	@Override
	public @NonNull CharSequence getContentDescription() {
		return super.getContentDescription();
	}
}
