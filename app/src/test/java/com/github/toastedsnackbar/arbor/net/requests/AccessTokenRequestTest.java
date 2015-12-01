package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.ApiReceiver;
import com.github.toastedsnackbar.arbor.net.ApiReceiver.ReceiveResultListener;
import com.github.toastedsnackbar.arbor.net.ApiService;

import org.apache.http.client.methods.HttpPost;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.httpclient.FakeHttp;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class AccessTokenRequestTest {

    @Test
    public void parcelable_shouldCreateFromParcel() {
        AccessTokenRequest request = new AccessTokenRequest("code", "client_id", "secret", "state");
        Parcel parcel = Parcel.obtain();
        request.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        AccessTokenRequest recreatedRequest = AccessTokenRequest.CREATOR.createFromParcel(parcel);

        assertThat(recreatedRequest.mUrl).isEqualTo(request.mUrl);
        assertThat(recreatedRequest.mRequestEntity).isEqualTo(request.mRequestEntity);
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

    @Ignore
    @Test
    public void execute_shouldExecuteHttpRequestWithCorrectParams() {
        AccessTokenRequest request = new AccessTokenRequest("code", "client_id", "secret", "state");

        ReceiveResultListener listener = new ReceiveResultListener() {
            @Override
            public void onReceiveResult(int resultCode, Bundle resultData) {
            }
        };
        ApiReceiver receiver = new ApiReceiver(new Handler());
        receiver.setResultListener(listener);

        ApiService.executeRequest(RuntimeEnvironment.application, request, receiver);
        HttpPost sentRequest = (HttpPost) FakeHttp.getLatestSentHttpRequest();

        String expectedUrl = ApiEndpoints.getAccessTokenUrl();
        String actualUrl = sentRequest.getURI().toString();
        assertThat(actualUrl).isEqualTo(expectedUrl);
    }
}
