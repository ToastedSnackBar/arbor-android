package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class AuthorResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        AuthorResponse response = new Gson().fromJson(MockResponses.AUTHOR, AuthorResponse.class);

        assertThat(response).isNotNull();
        assertThat(response.getEmail()).isEqualTo("email");
        assertThat(response.getName()).isEqualTo("name");
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        AuthorResponse response = new Gson().fromJson(MockResponses.AUTHOR, AuthorResponse.class);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        AuthorResponse parcelled = AuthorResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getEmail()).isEqualTo(response.getEmail());
        assertThat(parcelled.getName()).isEqualTo(response.getName());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        AuthorResponse[] responses = AuthorResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (AuthorResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
