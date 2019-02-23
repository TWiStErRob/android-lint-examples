package net.twisterrob.lints.usability;

import android.view.Menu;
import android.view.MenuItem;

public class AlwaysShowActionViolation {
	void setUp(Menu menu) {
		menu.findItem(android.R.id.home).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
	}
}
