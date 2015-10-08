package com.github.toastedsnackbar.arbor.net;

import android.net.Uri;

import java.util.Map;

public class ApiEndpoints {

    private static final String BASE = "https://api.github.com";

    private static final String USERS = BASE + "/users";
    private static final String USER = USERS + "/%s";
    private static final String AUTH_USER = BASE + "/user";

    private static final String USER_REPOS = USER + "/repos";
    private static final String AUTH_USER_REPOS = AUTH_USER + "/repos";

    public static String getUsersUrl() {
        return buildUrl(USERS);
    }

    public static String getUserUrl(String username) {
        return buildUrl(String.format(USER, username));
    }

    public static String getAuthUserUrl() {
        return buildUrl(AUTH_USER);
    }

    public static String getUserRepos(String username) {
        return buildUrl(String.format(USER_REPOS, username));
    }

    public static String getAuthUserRepos() {
        return buildUrl(AUTH_USER_REPOS);
    }

    private static String buildUrl(String url) {
        return buildUrl(url, null);
    }

    private static String buildUrl(String url, Map<String, String> params) {
        Uri.Builder builder = Uri.parse(url).buildUpon();

        if (params != null) {
            for (String key : params.keySet()) {
                String value = params.get(key);
                builder.appendQueryParameter(key, value);
            }
        }

        return builder.build().toString();
    }
}
