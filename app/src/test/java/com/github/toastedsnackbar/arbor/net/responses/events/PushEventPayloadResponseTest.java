package com.github.toastedsnackbar.arbor.net.responses.events;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;
import com.github.toastedsnackbar.arbor.net.responses.AuthorResponse;
import com.github.toastedsnackbar.arbor.net.responses.CommitResponse;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class PushEventPayloadResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        PushEventPayloadResponse response = GsonHelper.fromJson(MockResponses.PAYLOAD_PUSH_EVENT,
                PushEventPayloadResponse.class);

        assertThat(response).isNotNull();
        assertThat(response.getPushId()).isEqualTo(1);
        assertThat(response.getSize()).isEqualTo(1);
        assertThat(response.getDistinctSize()).isEqualTo(1);
        assertThat(response.getRef()).isEqualTo("ref");
        assertThat(response.getHead()).isEqualTo("head");
        assertThat(response.getBefore()).isEqualTo("before");

        List<CommitResponse> commits = response.getCommits();
        assertThat(commits).isNotNull();
        assertThat(commits.size()).isEqualTo(2);

        CommitResponse firstCommit = commits.get(0);
        assertThat(firstCommit.getSha()).isEqualTo("sha");
        assertThat(firstCommit.getMessage()).isEqualTo("message");
        assertThat(firstCommit.isDistinct()).isTrue();
        assertThat(firstCommit.getUrl()).isEqualTo("url");

        CommitResponse secondCommit = commits.get(1);
        assertThat(secondCommit.getSha()).isEqualTo("sha2");
        assertThat(secondCommit.getMessage()).isEqualTo("message2");
        assertThat(secondCommit.isDistinct()).isTrue();
        assertThat(secondCommit.getUrl()).isEqualTo("url2");

        AuthorResponse firstAuthor = firstCommit.getAuthor();
        assertThat(firstAuthor).isNotNull();
        assertThat(firstAuthor.getEmail()).isEqualTo("email");
        assertThat(firstAuthor.getName()).isEqualTo("name");

        AuthorResponse secondAuthor = secondCommit.getAuthor();
        assertThat(secondAuthor).isNotNull();
        assertThat(secondAuthor.getEmail()).isEqualTo("email2");
        assertThat(secondAuthor.getName()).isEqualTo("name2");
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        PushEventPayloadResponse response = GsonHelper.fromJson(MockResponses.PAYLOAD_PUSH_EVENT,
                PushEventPayloadResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        PushEventPayloadResponse parcelled = PushEventPayloadResponse.CREATOR.createFromParcel(
                parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getStatusCode()).isEqualTo(response.getStatusCode());
        assertThat(parcelled.getPushId()).isEqualTo(response.getPushId());
        assertThat(parcelled.getSize()).isEqualTo(response.getSize());
        assertThat(parcelled.getDistinctSize()).isEqualTo(response.getDistinctSize());
        assertThat(parcelled.getRef()).isEqualTo(response.getRef());
        assertThat(parcelled.getHead()).isEqualTo(response.getHead());
        assertThat(parcelled.getBefore()).isEqualTo(response.getBefore());

        List<CommitResponse> commits = response.getCommits();
        List<CommitResponse> parcelledCommits = parcelled.getCommits();
        assertThat(parcelledCommits).isNotNull();
        assertThat(parcelledCommits.size()).isEqualTo(2);

        CommitResponse firstCommit = commits.get(0);
        CommitResponse parcelledFirstCommit = parcelledCommits.get(0);
        assertThat(parcelledFirstCommit.getSha()).isEqualTo(firstCommit.getSha());
        assertThat(parcelledFirstCommit.getMessage()).isEqualTo(firstCommit.getMessage());
        assertThat(parcelledFirstCommit.isDistinct()).isEqualTo(firstCommit.isDistinct());
        assertThat(parcelledFirstCommit.getUrl()).isEqualTo(firstCommit.getUrl());

        CommitResponse secondCommit = commits.get(1);
        CommitResponse parcelledSecondCommit = parcelledCommits.get(1);
        assertThat(parcelledSecondCommit.getSha()).isEqualTo(secondCommit.getSha());
        assertThat(parcelledSecondCommit.getMessage()).isEqualTo(secondCommit.getMessage());
        assertThat(parcelledSecondCommit.isDistinct()).isEqualTo(secondCommit.isDistinct());
        assertThat(parcelledSecondCommit.getUrl()).isEqualTo(secondCommit.getUrl());

        AuthorResponse firstAuthor = firstCommit.getAuthor();
        AuthorResponse parcelledFirstAuthor = parcelledFirstCommit.getAuthor();
        assertThat(parcelledFirstAuthor.getEmail()).isEqualTo(firstAuthor.getEmail());
        assertThat(parcelledFirstAuthor.getName()).isEqualTo(firstAuthor.getName());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        PushEventPayloadResponse[] responses = PushEventPayloadResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (PushEventPayloadResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
