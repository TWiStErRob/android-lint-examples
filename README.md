Project that reproduces every lint violation out there.

Warning
-------
This project is not meant to show good practices, quite the opposite, code is written intentionally badly to reproduce the lint violations. That being said, I strive to use best practices and style whenever possible. Examples one should almost never do in production:
 * Uppercase Gradle module names  
   I chose to use un-standard naming so that it's extremely clear which module deals with what lint check. It also allows to automate easily.

(*Supporting code (like `build.gradle`s) were written with best intentions thought.*)

Goals
-----

 * simple examples showing each and every Lint
 * modules focused on single Lint check

Setup
-----
The project was developed using Android Studio 3.3.1. Simply import the Gradle project.

Reading
-------
 * What is lint? What does it?  
   http://tools.android.com/lint/overview
 * List of lint checks with explanation (`lint --show`) 
   http://tools.android.com/tips/lint-checks
 * List of lint checks (concise): `lint --list`
