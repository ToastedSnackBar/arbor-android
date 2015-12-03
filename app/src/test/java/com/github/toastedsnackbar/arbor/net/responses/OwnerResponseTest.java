package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class OwnerResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        OwnerResponse response = new Gson().fromJson(MockResponses.OWNER, OwnerResponse.class);

        assertThat(response.getLogin()).isEqualTo("okamayana");
        assertThat(response.getUserId()).isEqualTo("3643607");
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        OwnerResponse response = new Gson().fromJson(MockResponses.OWNER, OwnerResponse.class);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        OwnerResponse parcelled = OwnerResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled.getLogin()).isEqualTo(response.getLogin());
        assertThat(parcelled.getUserId()).isEqualTo(response.getUserId());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        OwnerResponse[] responses = OwnerResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (OwnerResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
