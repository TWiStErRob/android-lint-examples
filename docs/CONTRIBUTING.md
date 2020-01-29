This document is meant to record conventions used in this project.

Style
-----

Use the project style to format code as committed in `.idea` folder.

For checks to be consistently structured, use the automatic script (`:crateModule` tasl) to add them, for example:
```
gradlew createModule -PcheckCategory=Correctness -PcheckName=AdapterViewChildren
```


Commits
-------
Commit messages should fall into these categories:
 * `lint:CheckName`  
   (a new one if there's no explanation)
 * `lint:CheckName short explanation of what changed`
 * `docs:short explanation of what changed`  
   when changing `.md` files or adding dumps
 * `build:short explanation of what changed`  
   when changing `build.gradle`, `settings.gradle`, `buildSrc`


Coverage
--------

Each module is supposed to show a single Lint warning's violations.

Each `context.report(VIOLATION, ...)` statement in `Detector`s should be covered by an example. If one has a dynamic message, try to cover reasonably many paths of the generated message.

Each different resource type (layout, xml, menu, Java, Kotlin, Gradle) should be covered, if they can be violation in slightly different ways. (see for example MissingRegistered)

For simple checks there may be only one way to mess it up, so `expectedViolationCount(1)` is the default.
In case of multiple violations in a module, add:
```gradle
expectedViolationCount(x /*type1*/ + y /*type2*/)
```
and try to split the number of violations into groups.
For example `1 /*java*/ + 1 /*kotlin*/` or `5 /*manifest*/ + 2 /*layout*/`.

If a violation requires some extreme setup it may be necessary to introduce multiple modules. In this case use `:LintCheckName-ScenarioTitle` as the module name and update `AndroidManifest.xml` to:
```xml
<manifest package="net.twisterrob.lints.lint.LintCheckName.ScenarioTitle" />
```
Also create a `:LintCheckName` folder with just a `README.md` to explain why that check cannot be reproduced in a single module.

*See [`:Lint:ObsoleteLintCustomCheck`](../Lint) as an example.*


Focus
-----

Suppress Lint warnings that are not related to violation, the report should only contain violations that are the same as the module name. Only suppress, if the fix isn't trivial.


Documentation
-------------

If there are violations that are not being reported in the Lint results, but are known bad, comment where it's reproduced.

Use the following comment if there's already a bug/feature request reported.
```comment
REPORTED LintCheckName not working https://issuetracker.google.com/issues/123456789
```

For the module's Gradle script, include a comment that shows how many violations should be reported by lint for that module.
```gradle
// REPORT LintCheckName should be x /*type1*/ + y /*type2*/
expectedViolationCount(...)
```

For content-sensitive XML elements (e.g. `<string>`) comment missing violation on top of the element:
```xml
<outer>
	<!-- REPORT LintCheckName ns:attr is not supported,
	            with some potential detailed explanation. -->
	<inner ns:attr="value">non-free-form-content</inner>
</outer>
```

For free-form XML elements (e.g. layouts) comment missing violation inside the element:
```xml
<outer>
	<inner
		ns:attr="value"
		>
		<!-- REPORT LintCheckName ns:attr is not supported,
		            with some potential detailed explanation. -->
		<additional potential="content" />
	</inner>
</outer>
```

If an unrelated lint check is ignored for a specific check, document why:
```xml
<Layout
		xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:tools="http://schemas.android.com/tools"
		android:id="@+id/layout"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		tools:ignore="IrrelevantCheck1,IrrelevantCheck2"
		>
	<!-- lint:IrrelevantCheck1 irrelevant for this violation -->
	<!-- lint:IrrelevantCheck2 irrelevant for this violation -->
</Layout>
```
