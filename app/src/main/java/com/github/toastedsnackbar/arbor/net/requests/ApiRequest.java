package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcelable;

import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.responses.ApiResponse;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class ApiRequest<T extends ApiResponse> implements Parcelable {

    public static final String METHOD_POST = "POST";
    public static final String METHOD_PATCH = "PATCH";

    private static final Set<String> DEFAULT_ENTITY_METHODS = new LinkedHashSet<>(Arrays.asList(
            METHOD_POST, METHOD_PATCH));

    private static final Set<Integer> DEFAULT_ACCEPTED_STATUSES = new LinkedHashSet<>(Arrays.asList(
            200, 201));

    private static final String KEY_METHOD_OVERRIDE = "X-HTTP-Method-Override";

    public T execute() throws IOException {
        URL url = new URL(getUrl());

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);

        setRequestMethod(connection);
        addRequestProperties(connection);
        setRequestEntity(connection);

        T response = null;
        try {
            connection.connect();
            int statusCode = connection.getResponseCode();

            if (shouldAcceptStatusCode(statusCode)) {
                response = parseResponse(connection);
                response.setStatusCode(statusCode);
            }
        } finally {
            connection.disconnect();
        }

        return response;
    }

    private T parseResponse(HttpURLConnection connection) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        reader.close();

        return new Gson().fromJson(stringBuilder.toString(), getResponseClass());
    }

    private void setRequestMethod(HttpURLConnection connection)
            throws ProtocolException {
        String requestMethod = getRequestMethod();

        if (METHOD_PATCH.equals(requestMethod)) {
            connection.addRequestProperty(KEY_METHOD_OVERRIDE, METHOD_PATCH);
        } else {
            connection.setRequestMethod(requestMethod);
        }
    }

    private void addRequestProperties(HttpURLConnection connection) {
        if (isAuthorizedRequest()) {
            String accessToken = ArborPreferences.getInstance().getAccessToken();
            connection.addRequestProperty("Authorization", "token " + accessToken);
        }

        for (String key : ApiEndpoints.DEFAULT_HEADERS.keySet()) {
            connection.addRequestProperty(key, ApiEndpoints.DEFAULT_HEADERS.get(key));
        }

        Map<String, String> properties = getProperties();
        if (properties == null) return;
        for (String key : properties.keySet()) {
            connection.addRequestProperty(key, properties.get(key));
        }
    }

    private void setRequestEntity(HttpURLConnection connection) throws IOException {
        String entity = getRequestEntity();
        if (getEntityMethods().contains(getRequestMethod()) && entity != null) {
            OutputStream os = null;

            try {
                os = connection.getOutputStream();
                os.write(entity.getBytes());
            } finally {
                if (os != null) os.close();
            }
        }
    }

    private boolean shouldAcceptStatusCode(int statusCode) {
        boolean acceptDefault = DEFAULT_ACCEPTED_STATUSES.contains(statusCode);
        if (acceptDefault) return true;

        Set<Integer> acceptedStatuses = getAcceptedStatuses();
        return acceptedStatuses != null && acceptedStatuses.contains(statusCode);
    }

    private Set<String> getEntityMethods() {
        return DEFAULT_ENTITY_METHODS;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected abstract String getUrl();

    protected abstract Map<String, String> getProperties();

    protected abstract boolean isAuthorizedRequest();

    protected abstract String getRequestMethod();

    protected abstract String getRequestEntity();

    protected abstract Set<Integer> getAcceptedStatuses();

    protected abstract Class<T> getResponseClass();
}