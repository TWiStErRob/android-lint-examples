package net.twisterrob.lints.correctness;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;

import net.twisterrob.lints.correctness.WrongViewCast.R;

public class WrongViewCastViolation extends Activity {
	RelativeLayout explicitField;
	RelativeLayout implicitField;

	@SuppressWarnings("RedundantCast")
	void bind(View view) {
		implicitField = findViewById(R.id.root);
		explicitField = (RelativeLayout) findViewById(R.id.root);
		RelativeLayout implicitLocal = findViewById(R.id.root);
		RelativeLayout explicitLocal = (RelativeLayout) findViewById(R.id.root);

		// REPORT not handled in ViewTypeDetector.kt
		implicitField = view.findViewById(R.id.root);
		explicitField = (RelativeLayout) view.findViewById(R.id.root);
		// REPORT not handled in ViewTypeDetector.kt
		RelativeLayout implicitLocalView = view.findViewById(R.id.root);
		RelativeLayout explicitLocalView = (RelativeLayout) view.findViewById(R.id.root);
	}
}
