Project that reproduces every lint violation out there.

_See [`settings.gradle`](settings.gradle) for list of lint checks added in the project._

Goals
-----

 * simple examples showing each and every Lint
 * modules focused on single Lint check
 * get every possible report for each check  
   (each execution path in detectors)
 * discover bugs in lint  
   (flagged with `REPORT` or `REPORTED` comments)

Warning
-------
This project is not meant to show good practices, quite the opposite, code is written intentionally badly to reproduce the lint violations. That being said, I strive to use best practices and style whenever possible. Examples one should almost never do in production:
 * Uppercase Gradle module names  
   I chose to use non-standard naming so that it's extremely clear which module deals with what lint check. It also allows to automate easily (see how `lintOptions` and `lintVerifyCount` is set up).

(*Supporting code (like `build.gradle`s) were written with best intentions thought.*)

Setup
-----
The project was developed using Android Studio 3.3.1. Simply import the Gradle project.

Maintenance
-----------
Adding a new check automatically:
```
gradlew createModule -PcheckCategory=Correctness -PcheckName=AdapterViewChildren
```

Running modes
-------------

### `lints.check.only.specific`
One can set this flag (`true`|`false`) via `gradlew -P` or change it in `gradle.properties`. This is specific to this project.
It helps to run only the relevant lint check on each module, which greatly helps to reduce false positive breakpoint hits when debugging detectors, for example. It should also speed up running `:lint` on the project, although I only observed a 2-4 second speedup in a <30 second build.

Debugging lint
--------------

### Quick
_This approach should work in every project._

Every time you want to debug you'll have to do these actions:
 1. run `gradlew --no-daemon -Dorg.gradle.debug=true lint`  
   (this execution will hang, waiting for debugger to attach)
   can be more specific about which module's lint you want to run (e.g. `:Usability:Autofill:lint`)
 1. in Android Studio put a breakpoint somewhere  
   (e.g. on the `report(...)` call in `AutofillDetector.java`)
 1. in Android Studio debug the "*Attach to Gradle*" task
 1. wait for the build to progress to lint and hit breakpoint

### Single-click (more setup)
_This approach is tied to this project._

Need to set up an external tool once (can't share an External tool):
 * Create an External tool named "*Debug lint: gradlew lint (no daemon, debug)*" with exactly this name
   * Add it to the "*External Tools*" group with exactly this group name
   * **Program**: `$ProjectFileDir$/gradlew.bat`
   * **Arguments**: `lint --no-daemon -Dorg.gradle.debug=true`
   * **Working directory**: `$ProjectFileDir$`
   * Suggested: tick "Open console" and "Make active on stdout"

Running it is simple: debug "*Debug lint*" compound run configuration

To see why this approach is so complicated:
 * https://youtrack.jetbrains.com/issue/IDEA-113525
 * https://intellij-support.jetbrains.com/hc/en-us/community/posts/206187849-Sharing-external-tool-config-via-version-control
 
Reading
-------
 * What is lint? What does it do?  
   http://tools.android.com/lint/overview
 * List of lint checks with explanation  
   http://tools.android.com/tips/lint-checks
   ```shell
   lint --show
   ```
 * List of lint checks (concise)  
   ```shell
   lint --list
   ```
 * lint source code tests
   https://android.googlesource.com/platform/tools/base/+/studio-master-dev/lint/libs/lint-tests/src/test/java/com/android/tools/lint/checks
 * List of lint checks supported by Android Studio 3.3.1  
   [`.idea/inspectionProfiles/Project_Default.xml`](.idea/inspectionProfiles/Project_Default.xml)
 * Lint categories (based on `lint-checks-26.0.0-dev.jar`)
   ```shell
   lint --show | grep 'Category:' | uniq --count | sort --reverse
   ```
   result manually re-sorted to account for nested categories (total: 313):
   ```
   176 Category: Correctness
    11 Category: Correctness:Messages
     2 Category: Correctness:Chrome OS
    14 Category: Usability
    18 Category: Usability:Icons
     6 Category: Usability:Typography
    37 Category: Security
    35 Category: Performance
     5 Category: Internationalization
     4 Category: Internationalization:Bidirectional Text
     5 Category: Accessibility
   ```
