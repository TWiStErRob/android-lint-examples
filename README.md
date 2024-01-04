Project that reproduces every lint violation out there.

_See [`settings.gradle`](settings.gradle) for list of lint checks added in the project._

Goals
-----

 * simple examples demonstrating each and every Lint check violation
 * modules focused on single Lint check
 * get every possible report for each check  
   (each execution path in detectors, see [CONTRIBUTING.md](docs/CONTRIBUTING.md#Coverage))
 * discover bugs in `lint`  
   (flagged with `REPORT` or `REPORTED` comments, see [CONTRIBUTING.md](docs/CONTRIBUTING.md#Documentation))

Warning
-------
**This project is not meant to show good practices, quite the opposite, code is written intentionally badly to reproduce specific Lint check violations.**
 
That being said, I strive to use best practices and style whenever possible. Code that's not related to the lint check violation should be the best possible. For example supporting code (like `build.gradle`s) were written with best intentions.

Examples one should almost never do in production:

 * Blindly suppress a Lint warning as "irrelevant"  
   _I did it here to focus on a specific issue. Rest assured, there are other modules which violate those checks too._
 * Uppercase Gradle module names  
   _I chose to use non-standard naming so that it's extremely clear which module deals with what lint check. It also allows to automate easily (see how `lintOptions` and `lintVerifyCount` is set up)._
 * Uppercase Java/Kotlin package names  
   _I chose to use non-standard naming to have the check name occur in the module as text with exact text casing._


Setup & Debugging
-----------------
See [instructions](docs/DEVELOPMENT.md)

Reading
-------
 * What is lint? What does it do?  
   http://tools.android.com/lint/overview
 * What lint version belongs to what Android Gradle Plugin version?  
   There seems to be a correspondence: `23.0.0 + <AGP version>`.  
   e.g. AGP 3.0.0 = lint 26.0.0, AGP 3.3.2 = lint 26.3.2
 * List of lint checks with explanation  
   http://tools.android.com/tips/lint-checks
   ```shell
   lint --show
   ```
   See [`docs/lint/show (version).txt`](docs/lint).
 * List of lint checks (concise)  
   ```shell
   lint --list
   ```
   See [`docs/lint/list (version).txt`](docs/lint).
 * lint source code tests  
   [platform/tools/base/+/studio-master-dev/lint/libs/lint-tests](https://android.googlesource.com/platform/tools/base/+/studio-master-dev/lint/libs/lint-tests/src/test/java/com/android/tools/lint/checks)
 * List of lint checks supported by Android Studio 3.3.1  
   [`.idea/inspectionProfiles/Project_Default.xml`](.idea/inspectionProfiles/Project_Default.xml)
 * Lint categories (based on `lint-checks-26.0.0-dev.jar`)
   ```shell
   lint --show | grep 'Category:' | uniq --count | sort --reverse
   # Windows with grep and uniq helpers from cpp-w64devkit:
   lint --show | grep "Category:" | uniq -c | sort /R
   ```
   See [`docs/lint/categories (version).txt`](docs/lint).
