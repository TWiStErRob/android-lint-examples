Project that reproduces every lint violation out there.

Goals
-----

 * simple examples showing each and every Lint
 * modules focused on single Lint check

Warning
-------
This project is not meant to show good practices, quite the opposite, code is written intentionally badly to reproduce the lint violations. That being said, I strive to use best practices and style whenever possible. Examples one should almost never do in production:
 * Uppercase Gradle module names  
   I chose to use un-standard naming so that it's extremely clear which module deals with what lint check. It also allows to automate easily.

(*Supporting code (like `build.gradle`s) were written with best intentions thought.*)

Setup
-----
The project was developed using Android Studio 3.3.1. Simply import the Gradle project.

Debugging lint
--------------
To see why it's so complicated:
 * https://youtrack.jetbrains.com/issue/IDEA-113525
 * https://intellij-support.jetbrains.com/hc/en-us/community/posts/206187849-Sharing-external-tool-config-via-version-control

### Single-click (more setup)
Need to set up an external tool once (can't share an External tool):
 * Create an External tool named "*Debug lint: gradlew lint (no daemon, debug)*" with exactly this name
 * Add it to the "*External Tools*" group with exactly this group name
 * **Program**: `$ProjectFileDir$/gradlew.bat`
 * **Arguments**: `lint --no-daemon -Dorg.gradle.debug=true`
 * **Working directory**: `$ProjectFileDir$`
 * Suggested: tick "Open console" and "Make active on stdout"

Running it is simple: debug "*Debug lint*" compound run configuration

### Less setup (complex start)
Every time you want to start you'll have to do these two actions:
 * run `gradlew --no-daemon -Dorg.gradle.debug=true lint`  
   (this execution will hang, waiting for debugger to attach)
   can be more specific about which module's lint you want to run (e.g. `:Correctness:AaptCrash:lint`)
 * in Android Studio debug the "*Attach to Gradle*" task

Reading
-------
 * What is lint? What does it?  
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
 * List of lint checks supported by Android Studio 3.3.1  
   [`.idea/inspectionProfiles/Project_Default.xml`](.idea/inspectionProfiles/Project_Default.xml)
