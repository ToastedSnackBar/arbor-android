package com.github.toastedsnackbar.arbor.net.responses.events;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;
import com.github.toastedsnackbar.arbor.net.responses.OwnerResponse;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class PullRequestEventPayloadResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        PullRequestEventPayloadResponse response = GsonHelper.fromJson(
                MockResponses.PAYLOAD_PULL_REQUEST, PullRequestEventPayloadResponse.class);
        response.setStatusCode(200);

        assertThat(response).isNotNull();
        assertThat(response.getAction()).isEqualTo("action");
        assertThat(response.getNumber()).isEqualTo(1);
        assertThat(response.getPullRequest()).isNotNull();
        assertThat(response.getRepository()).isNotNull();
        assertThat(response.getSender()).isNotNull();
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        PullRequestEventPayloadResponse response = GsonHelper.fromJson(
                MockResponses.PAYLOAD_PULL_REQUEST, PullRequestEventPayloadResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        PullRequestEventPayloadResponse parcelled = PullRequestEventPayloadResponse
                .CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getStatusCode()).isEqualTo(response.getStatusCode());
        assertThat(parcelled.getAction()).isEqualTo(response.getAction());
        assertThat(parcelled.getNumber()).isEqualTo(response.getNumber());
        assertThat(parcelled.getPullRequest()).isNotNull();
        assertThat(parcelled.getRepository()).isNotNull();
        assertThat(parcelled.getSender()).isNotNull();
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        PullRequestEventPayloadResponse[] responses =
                PullRequestEventPayloadResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (PullRequestEventPayloadResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
