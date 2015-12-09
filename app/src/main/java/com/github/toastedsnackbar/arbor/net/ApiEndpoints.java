package com.github.toastedsnackbar.arbor.net;

import android.content.Context;
import android.net.Uri;

import com.github.toastedsnackbar.arbor.R;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApiEndpoints {

    public static final String SERVER_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static final Map<String, String> DEFAULT_HEADERS = getDefaultHeaders();

    private static final String CLIENT_SCOPE = "user,public_repo,repo,notifications,gist";

    private final String mClientId;
    private final String mClientSecret;
    private final String mClientState;

    public static class Params {
        public static final String SCOPE = "scope";
        public static final String CLIENT_ID = "client_id";
        public static final String STATE = "state";
        public static final String CODE = "code";
        public static final String CLIENT_SECRET = "client_secret";
    }

    private static class Urls {
        public static final String CLIENT_REDIRECT_URL = "https://www.google.com/";
        public static final String CLIENT_OAUTH_URL = "https://github.com/login/oauth/authorize";
        public static final String CLIENT_TOKEN_URL = "https://github.com/login/oauth/access_token";
        public static final String CLIENT_REGISTER_URL = "https://github.com/join";

        public static final String BASE = "https://api.github.com";

        public static final String USERS = BASE + "/users";
        public static final String USER = USERS + "/%s";

        public static final String AUTH_USER = BASE + "/user";
        public static final String USER_REPOS = USER + "/repos";

        public static final String AUTH_USER_REPOS = AUTH_USER + "/repos";

        public static final String USER_RECEIVED_EVENTS = USER + "/received_events";
    }

    private static class Headers {
        public static final String KEY_CONTENT_TYPE = "Content-Type";
        public static final String KEY_ACCEPT = "Accept";

        public static final String VALUE_CONTENT_TYPE_JSON = "application/json";
        public static final String VALUE_ACCEPT_API_VERSION = "application/vnd.github.v3+json";
        public static final String VALUE_ACCEPT_JSON = "application/json";
    }

    private static ApiEndpoints sInstance;

    public static void init(Context context) {
        if (sInstance == null) sInstance = new ApiEndpoints(context);
    }

    private ApiEndpoints(Context context) {
        ApiConfig apiConfig = getApiConfig(context);

        mClientId = apiConfig.clientId;
        mClientSecret = apiConfig.clientSecret;
        mClientState = apiConfig.clientState;
    }

    public static String getClientId() {
        return getInstance().mClientId;
    }

    public static String getClientSecret() {
        return getInstance().mClientSecret;
    }

    public static String getClientState() {
        return getInstance().mClientState;
    }

    private static ApiEndpoints getInstance() {
        if (sInstance == null) throw new IllegalStateException("ApiEndpoints not initialized.");
        return sInstance;
    }

    public static String getOAuthUrl() {
        Map<String, String> params = new HashMap<>();
        params.put(Params.SCOPE, CLIENT_SCOPE);
        params.put(Params.STATE, getClientState());
        params.put(Params.CLIENT_ID, getClientId());

        return buildUrl(Urls.CLIENT_OAUTH_URL, params);
    }

    public static String getAccessTokenUrl() {
        return buildUrl(Urls.CLIENT_TOKEN_URL);
    }

    public static String getRedirectUrl() {
        return Urls.CLIENT_REDIRECT_URL;
    }

    public static String getRegisterUrl() {
        return Urls.CLIENT_REGISTER_URL;
    }

    public static String getUsersUrl() {
        return buildUrl(Urls.USERS);
    }

    public static String getUserUrl(String username) {
        return buildUrl(String.format(Urls.USER, username));
    }

    public static String getAuthUserUrl() {
        return buildUrl(Urls.AUTH_USER);
    }

    public static String getUserReposUrl(String username) {
        return buildUrl(String.format(Urls.USER_REPOS, username));
    }

    public static String getAuthUserReposUrl() {
        return buildUrl(Urls.AUTH_USER_REPOS);
    }

    public static String getUserReceivedEvents(String username) {
        return buildUrl(String.format(Urls.USER_RECEIVED_EVENTS, username));
    }

    private static Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put(Headers.KEY_ACCEPT, Headers.VALUE_ACCEPT_API_VERSION);
        headers.put(Headers.KEY_ACCEPT, Headers.VALUE_ACCEPT_JSON);
        headers.put(Headers.KEY_CONTENT_TYPE, Headers.VALUE_CONTENT_TYPE_JSON);

        return headers;
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

    private ApiConfig getApiConfig(Context context) {
        String apiConfigString = getApiConfigString(context);
        return new Gson().fromJson(apiConfigString, ApiConfig.class);
    }

    private String getApiConfigString(Context context) {
        InputStream in = context.getResources().openRawResource(R.raw.api_config);
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        StringBuilder builder = new StringBuilder();

        try {
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Unable to read api_config.json");
        }

        return builder.toString();
    }

    private static class ApiConfig {

        @SerializedName("client_id")
        public String clientId;

        @SerializedName("client_secret")
        public String clientSecret;

        @SerializedName("client_state")
        public String clientState;
    }
}
