package com.github.toastedsnackbar.arbor;

import android.app.Application;

import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;

public class ArborApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ArborPreferences.init(getApplicationContext());
        ApiEndpoints.init(getApplicationContext());
    }
}
