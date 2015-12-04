package com.github.toastedsnackbar.arbor.net.responses.events;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class PushEventResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        EventResponse response = GsonHelper.fromJson(MockResponses.EVENT_PUSH, EventResponse.class);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo("id");
        assertThat(response.getType()).isEqualTo(EventType.PUSH);
        assertThat(response.isIsPublic()).isTrue();
        assertThat(response.getPayload()).isNotNull();
        assertThat(response.getPayload()).isInstanceOf(PushEventPayloadResponse.class);
        assertThat(response.getRepo()).isNotNull();
        assertThat(response.getActor()).isNotNull();
        assertThat(response.getOrganization()).isNotNull();
        assertThat(response.getCreatedAt()).isEqualTo("created_at");
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        EventResponse response = GsonHelper.fromJson(MockResponses.EVENT_PUSH, EventResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        EventResponse parcelled = EventResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getStatusCode()).isEqualTo(response.getStatusCode());
        assertThat(parcelled.getId()).isEqualTo(response.getId());
        assertThat(parcelled.getType()).isEqualTo(response.getType());
        assertThat(parcelled.isIsPublic()).isEqualTo(response.isIsPublic());
        assertThat(parcelled.getPayload()).isNotNull();
        assertThat(parcelled.getPayload()).isInstanceOf(PushEventPayloadResponse.class);
        assertThat(parcelled.getRepo()).isNotNull();
        assertThat(parcelled.getActor()).isNotNull();
        assertThat(parcelled.getOrganization()).isNotNull();
        assertThat(parcelled.getCreatedAt()).isEqualTo(response.getCreatedAt());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        PushEventPayloadResponse[] responses = PushEventPayloadResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (PushEventPayloadResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
