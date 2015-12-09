package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class PlanResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        PlanResponse response = GsonHelper.fromJson(MockResponses.PLAN, PlanResponse.class);

        assertThat(response).isNotNull();
        assertThat(response.getName()).isEqualTo("name");
        assertThat(response.getSpace()).isEqualTo(1);
        assertThat(response.getPrivateRepoCount()).isEqualTo(1);
        assertThat(response.getCollaboratorCount()).isEqualTo(1);
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        PlanResponse response = GsonHelper.fromJson(MockResponses.PLAN, PlanResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        PlanResponse parcelled = PlanResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getStatusCode()).isEqualTo(response.getStatusCode());
        assertThat(parcelled.getName()).isEqualTo(response.getName());
        assertThat(parcelled.getSpace()).isEqualTo(response.getSpace());
        assertThat(parcelled.getPrivateRepoCount()).isEqualTo(response.getPrivateRepoCount());
        assertThat(parcelled.getCollaboratorCount()).isEqualTo(response.getCollaboratorCount());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        PlanResponse[] responses = PlanResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (PlanResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
