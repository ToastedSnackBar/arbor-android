package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class MilestoneResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        MilestoneResponse response = GsonHelper.fromJson(MockResponses.MILESTONE,
                MilestoneResponse.class);

        assertThat(response).isNotNull();
        assertThat(response.getUrl()).isEqualTo("url");
        assertThat(response.getHtmlUrl()).isEqualTo("html_url");
        assertThat(response.getLabelsUrl()).isEqualTo("labels_url");
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getNumber()).isEqualTo(2);
        assertThat(response.getState()).isEqualTo("state");
        assertThat(response.getTitle()).isEqualTo("title");
        assertThat(response.getDescription()).isEqualTo("description");
        assertThat(response.getCreator()).isNotNull();
        assertThat(response.getOpenIssueCount()).isEqualTo(4);
        assertThat(response.getClosedIssueCount()).isEqualTo(5);
        assertThat(response.getCreatedAt()).isEqualTo("created_at");
        assertThat(response.getUpdatedAt()).isEqualTo("updated_at");
        assertThat(response.getClosedAt()).isEqualTo("closed_at");
        assertThat(response.getDueOn()).isEqualTo("due_on");
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        MilestoneResponse response = GsonHelper.fromJson(MockResponses.MILESTONE,
                MilestoneResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        MilestoneResponse parcelled = MilestoneResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getStatusCode()).isEqualTo(response.getStatusCode());
        assertThat(parcelled.getUrl()).isEqualTo(response.getUrl());
        assertThat(parcelled.getHtmlUrl()).isEqualTo(response.getHtmlUrl());
        assertThat(parcelled.getLabelsUrl()).isEqualTo(response.getLabelsUrl());
        assertThat(parcelled.getId()).isEqualTo(response.getId());
        assertThat(parcelled.getNumber()).isEqualTo(response.getNumber());
        assertThat(parcelled.getState()).isEqualTo(response.getState());
        assertThat(parcelled.getTitle()).isEqualTo(response.getTitle());
        assertThat(parcelled.getDescription()).isEqualTo(response.getDescription());
        assertThat(parcelled.getCreator()).isNotNull();
        assertThat(parcelled.getOpenIssueCount()).isEqualTo(response.getOpenIssueCount());
        assertThat(parcelled.getClosedIssueCount()).isEqualTo(response.getClosedIssueCount());
        assertThat(parcelled.getCreatedAt()).isEqualTo(response.getCreatedAt());
        assertThat(parcelled.getUpdatedAt()).isEqualTo(response.getUpdatedAt());
        assertThat(parcelled.getClosedAt()).isEqualTo(response.getClosedAt());
        assertThat(parcelled.getDueOn()).isEqualTo(response.getDueOn());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        MilestoneResponse[] responses = MilestoneResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (MilestoneResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
