package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class OrganizationResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        OrganizationResponse response = GsonHelper.fromJson(MockResponses.ORGANIZATION,
                OrganizationResponse.class);
        response.setStatusCode(200);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1);
        assertThat(response.getLogin()).isEqualTo("login");
        assertThat(response.getGravatarId()).isEqualTo("gravatar_id");
        assertThat(response.getUrl()).isEqualTo("url");
        assertThat(response.getAvatarUrl()).isEqualTo("avatar_url");
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        OrganizationResponse response = GsonHelper.fromJson(MockResponses.ORGANIZATION,
                OrganizationResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        OrganizationResponse parcelled = OrganizationResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getStatusCode()).isEqualTo(response.getStatusCode());
        assertThat(parcelled.getId()).isEqualTo(response.getId());
        assertThat(parcelled.getLogin()).isEqualTo(response.getLogin());
        assertThat(parcelled.getGravatarId()).isEqualTo(response.getGravatarId());
        assertThat(parcelled.getUrl()).isEqualTo(response.getUrl());
        assertThat(parcelled.getAvatarUrl()).isEqualTo(response.getAvatarUrl());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        OrganizationResponse[] responses = OrganizationResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (OrganizationResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
