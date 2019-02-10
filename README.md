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
