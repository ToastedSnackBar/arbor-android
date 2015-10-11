package com.github.toastedsnackbar.arbor.net;

import android.net.Uri;

import java.util.HashMap;
import java.util.Map;

public class ApiEndpoints {

    private static final String CLIENT_ID = "b573f060b42730edf91e";
    private static final String CLIENT_SECRET = "b573f060b42730edf91e";
    private static final String SCOPE = "user,public_repo,repo,notifications,gist";
    private static final String STATE = "1e31b439642ef73721067652dc0ffb15";
    private static final String REDIRECT = "https://www.google.com/";
    private static final String ACCESS_TOKEN = "https://github.com/login/oauth/access_token";
    private static final String OAUTH = "https://github.com/login/oauth/authorize";

    private static final String BASE = "https://api.github.com";

    private static final String USERS = BASE + "/users";
    private static final String USER = USERS + "/%s";

    private static final String AUTH_USER = BASE + "/user";
    private static final String USER_REPOS = USER + "/repos";

    private static final String AUTH_USER_REPOS = AUTH_USER + "/repos";

    public static String getOAuthUrl() {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", CLIENT_ID);
        params.put("scope", SCOPE);
        params.put("state", STATE);

        return buildUrl(OAUTH, params);
    }

    public static String getAccessTokenUrl(String code) {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", CLIENT_ID);
        params.put("client_secret", CLIENT_SECRET);
        params.put("code", code);
        params.put("state", STATE);

        return buildUrl(ACCESS_TOKEN, params);
    }

    public static String getRedirectUrl() {
        return REDIRECT;
    }

    public static String getUsersUrl() {
        return buildUrl(USERS);
    }

    public static String getUserUrl(String username) {
        return buildUrl(String.format(USER, username));
    }

    public static String getAuthUserUrl() {
        return buildUrl(AUTH_USER);
    }

    public static String getUserReposUrl(String username) {
        return buildUrl(String.format(USER_REPOS, username));
    }

    public static String getAuthUserReposUrl() {
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
