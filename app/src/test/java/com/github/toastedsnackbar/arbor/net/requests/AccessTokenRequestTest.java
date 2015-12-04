package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants;
import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;
import com.github.toastedsnackbar.arbor.net.responses.AccessTokenResponse;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest(ApiEndpoints.class)
public class AccessTokenRequestTest {

    @Rule
    public PowerMockRule mPowerMockRule = new PowerMockRule();

    @Test
    public void parcelable_shouldCreateFromParcel() {
        AccessTokenRequest request = new AccessTokenRequest("code", "client_id", "secret", "state");
        Parcel parcel = Parcel.obtain();
        request.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        AccessTokenRequest parcelled = AccessTokenRequest.CREATOR.createFromParcel(parcel);

        assertThat(parcelled.getUrl()).isEqualTo(request.getUrl());
        assertThat(parcelled.getRequestEntity()).isEqualTo(request.getRequestEntity());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        AccessTokenRequest[] requests = AccessTokenRequest.CREATOR.newArray(SIZE);
        assertThat(requests.length).isEqualTo(SIZE);

        for (AccessTokenRequest request : requests) {
            assertThat(request).isNull();
        }
    }

    @Test
    public void execute_shouldExecuteHttpRequestWithCorrectParams() throws IOException {
        MockResponse mockResponse = new MockResponse();
        mockResponse.setResponseCode(200);
        mockResponse.setBody(MockResponses.ACCESS_TOKEN);

        MockWebServer mockServer = new MockWebServer();
        mockServer.enqueue(mockResponse);
        mockServer.start();

        String mockUrl = mockServer.url("/login/oauth/access_token").toString();
        PowerMockito.mockStatic(ApiEndpoints.class);
        Mockito.when(ApiEndpoints.getAccessTokenUrl()).thenReturn(mockUrl);

        GsonHelper.init();

        AccessTokenRequest request = new AccessTokenRequest("code", "client_id", "secret", "state");
        AccessTokenResponse response = request.execute();

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getAccessToken()).isEqualTo("mock_access_token");
        assertThat(response.getTokenType()).isEqualTo("mock_token_type");
    }
}
