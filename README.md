# Arbor for Android [![Build Status](https://travis-ci.org/ToastedSnackBar/arbor-android.svg?branch=master)](https://travis-ci.org/ToastedSnackBar/arbor-android)

## Description

A free and open source GitHub mobile client for Android. Powered by GitHub API v3.

## Project setup

We recommend doing both of the following sections. For example, to be able to build your project locally directly though Android Studio, you will need to follow the second set.

### Command-line builds

To be able to build the project via the command line, like so:

```bash
./gradlew clean test
```

You will need to add the following system environment variables. Note that the values in this example are intentionally obscured. Please do not track this file!:

```bash
$ export ARBOR_CLIENT_ID=[secure]
$ export ARBOR_CLIENT_SECRET=[secure]
$ export ARBOR_CLIENT_STATE=[secure]
```

### Android Studio builds

You will need to add the following properties into `gradle.properties`. Note tat the values in this example are intentionally obscured as well. Please do not track this file!

```properties
systemProp.ARBOR_CLIENT_ID=[secure]
systemProp.ARBOR_CLIENT_SECRET=[secure]
systemProp.ARBOR_CLIENT_STATE=[secure]
```
