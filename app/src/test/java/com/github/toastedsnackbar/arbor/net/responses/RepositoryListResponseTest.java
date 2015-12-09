package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class RepositoryListResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        RepositoryListResponse response = GsonHelper.fromJson(MockResponses.REPOSITORY_LIST,
                RepositoryListResponse.class);

        assertThat(response.getItems().size()).isEqualTo(2);
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        RepositoryListResponse response = GsonHelper.fromJson(MockResponses.REPOSITORY_LIST,
                RepositoryListResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        RepositoryListResponse parcelled = RepositoryListResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getStatusCode()).isEqualTo(response.getStatusCode());
        assertThat(parcelled.getItems().size()).isEqualTo(response.getItems().size());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        RepositoryListResponse[] responses = RepositoryListResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (RepositoryListResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
