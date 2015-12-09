package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class BranchResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        BranchResponse response = GsonHelper.fromJson(MockResponses.BRANCH, BranchResponse.class);

        assertThat(response).isNotNull();
        assertThat(response.getLabel()).isEqualTo("label");
        assertThat(response.getRef()).isEqualTo("ref");
        assertThat(response.getSha()).isEqualTo("sha");
        assertThat(response.getUser()).isNotNull();
        assertThat(response.getRepo()).isNotNull();
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        BranchResponse response = GsonHelper.fromJson(MockResponses.BRANCH, BranchResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        BranchResponse parcelled = BranchResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getStatusCode()).isEqualTo(response.getStatusCode());
        assertThat(parcelled.getLabel()).isEqualTo(response.getLabel());
        assertThat(parcelled.getRef()).isEqualTo(response.getRef());
        assertThat(parcelled.getSha()).isEqualTo(response.getSha());
        assertThat(parcelled.getUser()).isNotNull();
        assertThat(parcelled.getRepo()).isNotNull();
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        BranchResponse[] responses = BranchResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (BranchResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
