package com.github.toastedsnackbar.arbor.net;

import com.github.toastedsnackbar.arbor.ArborTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

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
        String correctUrl = "https://github.com/login/oauth/authorize?" +
                "scope=user%5C%2Cpublic_repo%5C%2Crepo%5C%2Cdelete_repo%5C%2C" +
                "notifications%5C%2Cgist&state=1e31b439642ef73721067652dc0ffb15&" +
                "client_id=b573f060b42730edf91e";
        String actualUrl = ApiEndpoints.getOAuthUrl();

        assertThat(actualUrl).isEqualTo(correctUrl);
    }
}
