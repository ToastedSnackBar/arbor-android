# Arbor for Android [![Build Status](https://travis-ci.org/ToastedSnackBar/arbor-android.svg?branch=master)](https://travis-ci.org/ToastedSnackBar/arbor-android)

## Description

A free and open source GitHub mobile client for Android. Powered by GitHub API v3.

## Project setup

We recommend doing both of the following sections. For example, to be able to build your project locally directly though Android Studio, you will need to follow the second set.

### Travis-CI builds

To be able to build the project via the Travis-CI shell with the following script:

```bash
./gradlew clean test
```

You will need to add the following system environment variables to Travis-CI.

Note that the values in this example are intentionally obscured. Please do not track this file!:

```bash
$ export ARBOR_CLIENT_ID=[secure]
$ export ARBOR_CLIENT_SECRET=[secure]
$ export ARBOR_CLIENT_STATE=[secure]
```

### Local machine builds

To be able to build the project on your local machine via the command line or directly from Android Studio, you will need to add the following properties into `gradle.properties`. This file is untracked by Git, so you might need to create it.

Note that the values in this example are intentionally obscured as well. Please do not track this file!

```properties
# Project-wide Gradle settings.

# IDE (e.g. Android Studio) users:
# Gradle settings configured through the IDE *will override*
# any settings specified in this file.

# For more details on how to configure your build environment visit
# http://www.gradle.org/docs/current/userguide/build_environment.html

# Specifies the JVM arguments used for the daemon process.
# The setting is particularly useful for tweaking memory settings.
# Default value: -Xmx10248m -XX:MaxPermSize=256m
# org.gradle.jvmargs=-Xmx2048m -XX:MaxPermSize=512m -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8

# When configured, Gradle will run in incubating parallel mode.
# This option should only be used with decoupled projects. More details, visit
# http://www.gradle.org/docs/current/userguide/multi_project_builds.html#sec:decoupled_projects
# org.gradle.parallel=true

systemProp.ARBOR_CLIENT_ID=[secure]
systemProp.ARBOR_CLIENT_SECRET=[secure]
systemProp.ARBOR_CLIENT_STATE=[secure]
```
