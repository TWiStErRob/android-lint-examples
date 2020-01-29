Setup
-----
The project was developed using Android Studio 3.3.1. Simply import the Gradle project.


Running modes
-------------

### `lints.check.only.specific`
One can set this flag (`true`|`false`) via `gradlew -P` or change it in `gradle.properties`. This is specific to this project.
It helps to run only the relevant lint check on each module, which greatly helps to reduce false positive breakpoint hits when debugging detectors, for example. It should also speed up running `:lint` on the project, although I only observed a 2-4 second speedup in a <30 second build.


### hack `settings.gradle`
When debugging or adding a new check it is recommended to disable most modules so the project only contains a single lint check's module. This speeds up Gradle configuration time and gives a quick turnaround on testing/debugging.

Simple comment out all lines except the one you're interested in:
```gradle
//include ':Category1:IrrelevantCheck1'
include ':Category:ImportantCheck'
//include ':Category2:IrrelevantCheck2'
```
_Note: `include ':Category'` is not necessary, it's implicitly imported by Gradle._


Debugging lint
--------------
Note: remember to make sure `:lint` will run by calling `...:cleanLint` in the same build.

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


Writing custom checks
---------------------
See [`module-custom-check.gradle`](gradle/module-custom-check.gradle) for an example project setup that can help writing your own checks.

_It's worth looking at existing checks. One can find them easily with a full text search (IDEA: Edit > Find > Find in Path...), searching for `"CheckName"` including quotes, because it'll match the lint API `Issue` definition._

Simple example to use as starting points for different types of checks:
 * XML Attributes and resolving values only in IDE (not in Gradle): AllCaps
 * multiphase lint execution: BackButton
