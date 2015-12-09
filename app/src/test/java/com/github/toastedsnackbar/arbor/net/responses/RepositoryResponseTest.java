package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class RepositoryResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        RepositoryResponse response = GsonHelper.fromJson(MockResponses.REPOSITORY,
                RepositoryResponse.class);

        assertThat(response.getName()).isEqualTo("coding-challenge");
        assertThat(response.getCreatedAt()).isEqualTo("2014-04-26T04:30:57Z");
        assertThat(response.getUpdatedAt()).isEqualTo("2014-07-31T14:52:31Z");
        assertThat(response.getStargazersCount()).isEqualTo(0);
        assertThat(response.getWatchersCount()).isEqualTo(0);
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        RepositoryResponse response = GsonHelper.fromJson(MockResponses.REPOSITORY,
                RepositoryResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        RepositoryResponse parcelled = RepositoryResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getStatusCode()).isEqualTo(response.getStatusCode());
        assertThat(parcelled.getName()).isEqualTo(response.getName());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        RepositoryResponse[] responses = RepositoryResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (RepositoryResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
