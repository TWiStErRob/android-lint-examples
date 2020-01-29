package net.twisterrob.lints.correctness;

class MissingRegisteredViolation {
	// REPORT MissingRegistered there must be code in the project, otherwise RecyclerView is missing:
	// ../../src/main/res/layout/missing_layout_manager.xml:1:
	// Class referenced in the layout file, androidx.recyclerview.widget.RecyclerView,
	// was not found in the project or the libraries
	// 1 <androidx.recyclerview.widget.RecyclerView
}
