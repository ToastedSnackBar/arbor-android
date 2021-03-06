package com.github.toastedsnackbar.arbor.content;

import android.content.Context;
import android.content.SharedPreferences;

public class ArborPreferences {

    private static final String NAME = "arbor_preferences";

    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_AVATAR_URL = "avatar_url";

    private static ArborPreferences sInstance;
    private SharedPreferences mPreferences;

    private ArborPreferences(Context context) {
        mPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        if (sInstance == null) sInstance = new ArborPreferences(context);
    }

    private static ArborPreferences getInstance() {
        if (sInstance == null) throw new IllegalStateException("ArborPreferences not initialized");
        return sInstance;
    }

    public static void clear() {
        getInstance().mPreferences.edit().clear().commit();
    }

    public static String getAccessToken() {
        return getString(KEY_ACCESS_TOKEN);
    }

    public static String getUsername() {
        return getString(KEY_USERNAME);
    }

    public static String getEmail() {
        return getString(KEY_EMAIL);
    }

    public static String getAvatarUrl() {
        return getString(KEY_AVATAR_URL);
    }

    public static void setAccessToken(String accessToken) {
        putString(KEY_ACCESS_TOKEN, accessToken);
    }

    public static void setUsername(String username) {
        putString(KEY_USERNAME, username);
    }

    public static void setEmail(String email) {
        putString(KEY_EMAIL, email);
    }

    public static void setAvatarUrl(String avatarUrl) {
        putString(KEY_AVATAR_URL, avatarUrl);
    }

    private static String getString(final String key) {
        return getInstance().mPreferences.getString(key, "");
    }

    private static void putString(final String key, final String value) {
        getInstance().mPreferences.edit().putString(key, value).commit();
    }
}
