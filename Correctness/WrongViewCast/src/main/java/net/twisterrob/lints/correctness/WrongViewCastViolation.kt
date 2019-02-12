package net.twisterrob.lints.correctness

import android.content.Context
import android.view.View
import android.widget.RelativeLayout
import net.twisterrob.lints.correctness.WrongViewCast.R

class WrongViewCastViolationView(context: Context) : View(context) {
	private lateinit var explicitField: RelativeLayout
	private lateinit var implicitField: RelativeLayout

	// REPORT none of these are actually resolved from console because resource id is not found
	@Suppress("UNUSED_VARIABLE")
	fun bind(view: View) {
		// REPORT not handled in ViewTypeDetector.kt
		implicitField = findViewById(R.id.root)
		explicitField = findViewById(R.id.root) as RelativeLayout
		val implicitLocal: RelativeLayout = findViewById(R.id.root)
		val explicitLocal = findViewById(R.id.root) as RelativeLayout

		// REPORT not handled in ViewTypeDetector.kt
		implicitField = view.findViewById(R.id.root)
		explicitField = view.findViewById(R.id.root) as RelativeLayout
		// REPORT not handled in ViewTypeDetector.kt
		val implicitLocalView: RelativeLayout = view.findViewById(R.id.root)
		val explicitLocalView = view.findViewById(R.id.root) as RelativeLayout
	}
}
