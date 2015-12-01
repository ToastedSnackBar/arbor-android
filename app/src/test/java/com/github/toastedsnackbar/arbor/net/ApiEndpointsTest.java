package com.github.toastedsnackbar.arbor.net;

import android.content.Context;

import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.R;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(ArborTestRunner.class)
public class ApiEndpointsTest {

    @Test
    public void getUserUrl_shouldReturnCorrectUrl() {
        String correctUrl = "https://api.github.com/users/username";
        String actualUrl = ApiEndpoints.getUserUrl("username");

        assertThat(actualUrl).isEqualTo(correctUrl);
    }

    @Test
    public void getUsersUrl_shouldReturnCorrectUrl() {
        String correctUrl = "https://api.github.com/users";
        String actualUrl = ApiEndpoints.getUsersUrl();

        assertThat(actualUrl).isEqualTo(correctUrl);
    }

    @Test
    public void getAuthUserUrl_shouldReturnCorrectUrl() {
        String correctUrl = "https://api.github.com/user";
        String actualUrl = ApiEndpoints.getAuthUserUrl();

        assertThat(actualUrl).isEqualTo(correctUrl);
    }

    @Test
    public void getUserReposUrl_shouldReturnCorrectUrl() {
        String correctUrl = "https://api.github.com/users/username/repos";
        String actualUrl = ApiEndpoints.getUserReposUrl("username");

        assertThat(actualUrl).isEqualTo(correctUrl);
    }

    @Test
    public void getAuthUserReposUrl_shouldReturnCorrectUrl() {
        String correctUrl = "https://api.github.com/user/repos";
        String actualUrl = ApiEndpoints.getAuthUserReposUrl();

        assertThat(actualUrl).isEqualTo(correctUrl);
    }

    @Test
    public void getOAuthUrl_shouldReturnCorrectUrl() {
        String correctUrl = getCorrectOAuthUrl(RuntimeEnvironment.application);
        String actualUrl = ApiEndpoints.getOAuthUrl();

        assertThat(actualUrl).isEqualTo(correctUrl);
    }

    @Test
    public void getRegisterUrl_shouldReturnCorrectUrl() {
        String correctUrl = "https://github.com/join";
        String actualUrl = ApiEndpoints.getRegisterUrl();

        assertThat(actualUrl).isEqualTo(correctUrl);
    }

    private String getCorrectOAuthUrl(Context context) {
        ApiConfig apiConfig = getApiConfig(context);

        return "https://github.com/login/oauth/authorize" + "?" +
                "scope=user%2Cpublic_repo%2Crepo%2Cnotifications%2Cgist" + "&" +
                "state=" + apiConfig.clientState + "&" +
                "client_id=" + apiConfig.clientId;
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

        @SerializedName("client_state")
        public String clientState;
    }
}
