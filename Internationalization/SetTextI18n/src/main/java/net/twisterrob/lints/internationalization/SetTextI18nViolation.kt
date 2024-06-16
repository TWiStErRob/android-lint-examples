package net.twisterrob.lints.internationalization

import android.widget.TextView

fun literal(textView: TextView) {
	textView.text = "Hello"
}

fun numberFormat(textView: TextView, number: Int) {
	textView.text = number.toString()
}

fun concatenation(textView: TextView, prefix: String, suffix: String) {
	textView.text = prefix + suffix
}

fun concatenationTemplate(textView: TextView, prefix: String, suffix: String) {
	textView.text = "$prefix$suffix"
}
