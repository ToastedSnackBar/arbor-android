package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class CommitResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        CommitResponse response = new Gson().fromJson(MockResponses.COMMIT, CommitResponse.class);

        assertThat(response).isNotNull();
        assertThat(response.getSha()).isEqualTo("sha");
        assertThat(response.isDistinct()).isTrue();
        assertThat(response.getUrl()).isEqualTo("url");
        assertThat(response.getMessage()).isEqualTo("message");

        AuthorResponse author = response.getAuthor();
        assertThat(author).isNotNull();
        assertThat(author.getEmail()).isEqualTo("email");
        assertThat(author.getName()).isEqualTo("name");
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        CommitResponse response = new Gson().fromJson(MockResponses.COMMIT, CommitResponse.class);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        CommitResponse parcelled = CommitResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getSha()).isEqualTo(response.getSha());
        assertThat(parcelled.isDistinct()).isEqualTo(response.isDistinct());
        assertThat(parcelled.getUrl()).isEqualTo(response.getUrl());
        assertThat(parcelled.getMessage()).isEqualTo(response.getMessage());

        AuthorResponse responseAuthor = response.getAuthor();
        AuthorResponse parcelledAuthor = parcelled.getAuthor();
        assertThat(parcelledAuthor).isNotNull();
        assertThat(parcelledAuthor.getEmail()).isEqualTo(responseAuthor.getEmail());
        assertThat(parcelledAuthor.getName()).isEqualTo(responseAuthor.getName());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        CommitResponse[] responses = CommitResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (CommitResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
