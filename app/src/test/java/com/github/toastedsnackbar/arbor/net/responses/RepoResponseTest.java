package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class RepoResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        RepoResponse response = GsonHelper.fromJson(MockResponses.REPO, RepoResponse.class);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1);
        assertThat(response.getName()).isEqualTo("name");
        assertThat(response.getUrl()).isEqualTo("url");
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        RepoResponse response = GsonHelper.fromJson(MockResponses.REPO, RepoResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        RepoResponse parcelled = RepoResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getStatusCode()).isEqualTo(response.getStatusCode());
        assertThat(parcelled.getId()).isEqualTo(response.getId());
        assertThat(parcelled.getName()).isEqualTo(response.getName());
        assertThat(parcelled.getUrl()).isEqualTo(response.getUrl());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        RepoResponse[] responses = RepoResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (RepoResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
