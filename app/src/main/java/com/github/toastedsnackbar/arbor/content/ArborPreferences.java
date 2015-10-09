package com.github.toastedsnackbar.arbor.content;

import android.content.Context;
import android.content.SharedPreferences;

public class ArborPreferences {

    private static final String NAME = "arbor_preferences";

    private static final String KEY_USERNAME = "username";
    private static final String KEY_ACCESS_TOKEN = "access_token";

    private static ArborPreferences sInstance;
    private SharedPreferences mPreferences;

    private ArborPreferences(Context context) {
        mPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        if (sInstance == null) sInstance = new ArborPreferences(context);
    }

    public ArborPreferences getsInstance() {
        return sInstance;
    }

    public String getUsername() {
        return getString(KEY_USERNAME);
    }

    public String getAccessToken() {
        return getString(KEY_ACCESS_TOKEN);
    }

    public void setUsername(String username) {
        putString(KEY_USERNAME, username);
    }

    public void setAccessToken(String accessToken) {
        putString(KEY_ACCESS_TOKEN, accessToken);
    }

    private String getString(final String key) {
        return mPreferences.getString(key, "");
    }

    private void putString(final String key, final String value) {
        mPreferences.edit().putString(key, value).apply();
    }
}
