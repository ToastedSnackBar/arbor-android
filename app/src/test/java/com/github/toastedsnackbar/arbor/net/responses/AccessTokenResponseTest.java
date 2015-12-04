package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class AccessTokenResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        AccessTokenResponse response = GsonHelper.fromJson(MockResponses.ACCESS_TOKEN,
                AccessTokenResponse.class);

        assertThat(response.getAccessToken()).isEqualTo("mock_access_token");
        assertThat(response.getTokenType()).isEqualTo("mock_token_type");
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        AccessTokenResponse response = GsonHelper.fromJson(MockResponses.ACCESS_TOKEN,
                AccessTokenResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        AccessTokenResponse parcelled = AccessTokenResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getStatusCode()).isEqualTo(response.getStatusCode());
        assertThat(parcelled.getAccessToken()).isEqualTo(response.getAccessToken());
        assertThat(parcelled.getTokenType()).isEqualTo(response.getTokenType());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        AccessTokenResponse[] responses = AccessTokenResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (AccessTokenResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
