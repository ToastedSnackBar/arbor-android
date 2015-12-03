package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class RepositoryListResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        RepositoryListResponse response = new Gson().fromJson(MockResponses.REPOSITORY_LIST,
                RepositoryListResponse.class);

        assertThat(response.getItems().size()).isEqualTo(2);
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        RepositoryListResponse response = new Gson().fromJson(MockResponses.REPOSITORY_LIST,
                RepositoryListResponse.class);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        RepositoryListResponse parcelled = RepositoryListResponse.CREATOR.createFromParcel(parcel);

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
