package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class PullRequestResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        PullRequestResponse response = GsonHelper.fromJson(MockResponses.PULL_REQUEST,
                PullRequestResponse.class);
        response.setStatusCode(200);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getUrl()).isEqualTo("url");
        assertThat(response.getHtmlUrl()).isEqualTo("html_url");
        assertThat(response.getDiffUrl()).isEqualTo("diff_url");
        assertThat(response.getPatchUrl()).isEqualTo("patch_url");
        assertThat(response.getIssueUrl()).isEqualTo("issue_url");
        assertThat(response.getCommitsUrl()).isEqualTo("commits_url");
        assertThat(response.getReviewCommentsUrl()).isEqualTo("review_comments_url");
        assertThat(response.getReviewCommentUrl()).isEqualTo("review_comment_url");
        assertThat(response.getCommentsUrl()).isEqualTo("comments_url");
        assertThat(response.getStatusesUrl()).isEqualTo("statuses_url");
        assertThat(response.getNumber()).isEqualTo(2);
        assertThat(response.getState()).isEqualTo("state");
        assertThat(response.getTitle()).isEqualTo("title");
        assertThat(response.getBody()).isEqualTo("body");
        assertThat(response.getAssignee()).isNotNull();
        assertThat(response.getMilestone()).isNotNull();
        assertThat(response.isLocked()).isTrue();
        assertThat(response.getCreatedAt()).isEqualTo("created_at");
        assertThat(response.getUpdatedAt()).isEqualTo("updated_at");
        assertThat(response.getClosedAt()).isEqualTo("closed_at");
        assertThat(response.getMergedAt()).isEqualTo("merged_at");
        assertThat(response.getHead()).isNotNull();
        assertThat(response.getBase()).isNotNull();
        assertThat(response.getUser()).isNotNull();
        assertThat(response.getMergeCommitSha()).isEqualTo("merge_commit_sha");
        assertThat(response.isMerged()).isTrue();
        assertThat(response.isMergeable()).isTrue();
        assertThat(response.getMergedBy()).isNotNull();
        assertThat(response.getCommentCount()).isEqualTo(3);
        assertThat(response.getCommitCount()).isEqualTo(4);
        assertThat(response.getAdditionCount()).isEqualTo(5);
        assertThat(response.getDeletionCount()).isEqualTo(6);
        assertThat(response.getChangedFileCount()).isEqualTo(7);
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        PullRequestResponse response = GsonHelper.fromJson(MockResponses.PULL_REQUEST,
                PullRequestResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);
        
        parcel.setDataPosition(0);
        PullRequestResponse parcelled = PullRequestResponse.CREATOR.createFromParcel(parcel);
        
        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getId()).isEqualTo(response.getId());
        assertThat(parcelled.getUrl()).isEqualTo(response.getUrl());
        assertThat(parcelled.getHtmlUrl()).isEqualTo(response.getHtmlUrl());
        assertThat(parcelled.getDiffUrl()).isEqualTo(response.getDiffUrl());
        assertThat(parcelled.getPatchUrl()).isEqualTo(response.getPatchUrl());
        assertThat(parcelled.getIssueUrl()).isEqualTo(response.getIssueUrl());
        assertThat(parcelled.getCommitsUrl()).isEqualTo(response.getCommitsUrl());
        assertThat(parcelled.getReviewCommentsUrl()).isEqualTo(response.getReviewCommentsUrl());
        assertThat(parcelled.getReviewCommentUrl()).isEqualTo(response.getReviewCommentUrl());
        assertThat(parcelled.getCommentsUrl()).isEqualTo(response.getCommentsUrl());
        assertThat(parcelled.getStatusesUrl()).isEqualTo(response.getStatusesUrl());
        assertThat(parcelled.getNumber()).isEqualTo(response.getNumber());
        assertThat(parcelled.getState()).isEqualTo(response.getState());
        assertThat(parcelled.getTitle()).isEqualTo(response.getTitle());
        assertThat(parcelled.getBody()).isEqualTo(response.getBody());
        assertThat(parcelled.getAssignee()).isNotNull();
        assertThat(parcelled.getMilestone()).isNotNull();
        assertThat(parcelled.isLocked()).isEqualTo(response.isLocked());
        assertThat(parcelled.getCreatedAt()).isEqualTo(response.getCreatedAt());
        assertThat(parcelled.getUpdatedAt()).isEqualTo(response.getUpdatedAt());
        assertThat(parcelled.getClosedAt()).isEqualTo(response.getClosedAt());
        assertThat(parcelled.getMergedAt()).isEqualTo(response.getMergedAt());
        assertThat(parcelled.getHead()).isNotNull();
        assertThat(parcelled.getBase()).isNotNull();
        assertThat(parcelled.getUser()).isNotNull();
        assertThat(parcelled.getMergeCommitSha()).isEqualTo(response.getMergeCommitSha());
        assertThat(parcelled.isMerged()).isEqualTo(response.isMerged());
        assertThat(parcelled.isMergeable()).isEqualTo(response.isMergeable());
        assertThat(parcelled.getMergedBy()).isNotNull();
        assertThat(parcelled.getCommentCount()).isEqualTo(response.getCommentCount());
        assertThat(parcelled.getCommitCount()).isEqualTo(response.getCommitCount());
        assertThat(parcelled.getAdditionCount()).isEqualTo(response.getAdditionCount());
        assertThat(parcelled.getDeletionCount()).isEqualTo(response.getDeletionCount());
        assertThat(parcelled.getChangedFileCount()).isEqualTo(response.getChangedFileCount());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        PullRequestResponse[] responses = PullRequestResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (PullRequestResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
