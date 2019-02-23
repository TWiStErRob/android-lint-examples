package net.twisterrob.lints.internationalization

import android.widget.TextView

fun literal(textView: TextView) {
	textView.text = "Hello"
}

fun numberFormat(textView: TextView, number: Int) {
	// REPORT PsiMethod calledMethod = ((UCallExpression) node).resolve() resolves to null
	// Is it because Int and Int? toString call is Any.toString and Any?.toString
	textView.text = number.toString()
}

fun concatenation(textView: TextView, prefix: String, suffix: String) {
	textView.text = prefix + suffix
}

fun concatenationTemplate(textView: TextView, prefix: String, suffix: String) {
	textView.text = "$prefix$suffix"
}
