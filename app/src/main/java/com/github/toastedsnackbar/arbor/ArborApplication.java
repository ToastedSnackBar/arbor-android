package com.github.toastedsnackbar.arbor;

import android.app.Application;

import com.github.toastedsnackbar.arbor.content.ArborPreferences;

public class ArborApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ArborPreferences.init(getApplicationContext());
    }
}
