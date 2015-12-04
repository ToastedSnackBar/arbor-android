package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryListResponse;
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
import org.robolectric.RuntimeEnvironment;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest(ApiEndpoints.class)
public class RepositoryListRequestTest {

    @Rule
    public PowerMockRule mPowerMockRule = new PowerMockRule();

    @Test
    public void parcelable_shouldCreateFromParcel() {
        RepositoryListRequest request = new RepositoryListRequest();
        Parcel parcel = Parcel.obtain();
        request.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        RepositoryListRequest parcelled = RepositoryListRequest.CREATOR.createFromParcel
                (parcel);

        assertThat(parcelled.getUrl()).isEqualTo(request.getUrl());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        RepositoryListRequest[] requests = RepositoryListRequest.CREATOR.newArray(SIZE);
        assertThat(requests.length).isEqualTo(SIZE);

        for (RepositoryListRequest request : requests) {
            assertThat(request).isNull();
        }
    }

    @Test
    public void execute_shouldExecuteHttpRequestWithCorrectParams() throws IOException {
        MockResponse mockResponse = new MockResponse();
        mockResponse.setResponseCode(200);
        mockResponse.setBody(MockResponses.REPOSITORY_LIST);

        MockWebServer mockServer = new MockWebServer();
        mockServer.enqueue(mockResponse);
        mockServer.start();

        ArborPreferences.init(RuntimeEnvironment.application);
        ArborPreferences.setAccessToken("access_token");

        GsonHelper.init();

        String mockUrl = mockServer.url("/user/repos").toString();
        PowerMockito.mockStatic(ApiEndpoints.class);
        Mockito.when(ApiEndpoints.getAuthUserReposUrl()).thenReturn(mockUrl);

        RepositoryListRequest request = new RepositoryListRequest();
        RepositoryListResponse response = request.execute();

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getItems().size()).isEqualTo(2);
    }
}
