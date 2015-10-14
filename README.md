# Arbor for Android

<p align="right">
    [![Build Status](https://travis-ci.org/ToastedSnackBar/arbor-android.svg?branch=master)](https://travis-ci.org/ToastedSnackBar/arbor-android) [![Coverage Status](https://coveralls.io/repos/ToastedSnackBar/arbor-android/badge.svg?branch=105683680&service=github)](https://coveralls.io/github/ToastedSnackBar/arbor-android?branch=105683680)
</p>

## Description

A free and open source GitHub mobile client for Android. Powered by GitHub API v3.

## Project setup

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
systemProp.ARBOR_CLIENT_ID=[secure]
systemProp.ARBOR_CLIENT_SECRET=[secure]
systemProp.ARBOR_CLIENT_STATE=[secure]
```
