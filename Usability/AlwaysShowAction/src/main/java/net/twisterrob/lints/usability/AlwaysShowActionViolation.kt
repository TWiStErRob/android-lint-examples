package net.twisterrob.lints.usability

import android.view.Menu
import android.view.MenuItem

fun setUp(menu: Menu) {
	menu.findItem(android.R.id.home).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
}
