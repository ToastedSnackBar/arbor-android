package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class UserResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        UserResponse response = GsonHelper.fromJson(MockResponses.AUTH_USER,
                UserResponse.class);

        assertThat(response).isNotNull();
        assertThat(response.getLogin()).isEqualTo("login");
        assertThat(response.getId()).isEqualTo(1);
        assertThat(response.getAvatarUrl()).isEqualTo("avatar_url");
        assertThat(response.getGravatarId()).isEqualTo("gravatar_id");
        assertThat(response.getUrl()).isEqualTo("url");
        assertThat(response.getHtmlUrl()).isEqualTo("html_url");
        assertThat(response.getFollowersUrl()).isEqualTo("followers_url");
        assertThat(response.getFollowingUrl()).isEqualTo("following_url");
        assertThat(response.getGistsUrl()).isEqualTo("gists_url");
        assertThat(response.getStarredUrl()).isEqualTo("starred_url");
        assertThat(response.getSubscriptionsUrl()).isEqualTo("subscriptions_url");
        assertThat(response.getOrganizationsUrl()).isEqualTo("organizations_url");
        assertThat(response.getReposUrl()).isEqualTo("repos_url");
        assertThat(response.getEventsUrl()).isEqualTo("events_url");
        assertThat(response.getReceivedEventsUrl()).isEqualTo("received_events_url");
        assertThat(response.getType()).isEqualTo("type");
        assertThat(response.isIsSiteAdmin()).isTrue();
        assertThat(response.getName()).isEqualTo("name");
        assertThat(response.getCompany()).isEqualTo("company");
        assertThat(response.getBlogUrl()).isEqualTo("blog");
        assertThat(response.getLocation()).isEqualTo("location");
        assertThat(response.getEmail()).isEqualTo("email");
        assertThat(response.isHireable()).isTrue();
        assertThat(response.getBio()).isEqualTo("bio");
        assertThat(response.getPublicRepoCount()).isEqualTo(1);
        assertThat(response.getPublicGistCount()).isEqualTo(2);
        assertThat(response.getFollowerCount()).isEqualTo(3);
        assertThat(response.getFollowingCount()).isEqualTo(4);
        assertThat(response.getCreatedAt()).isEqualTo("created_at");
        assertThat(response.getUpdatedAt()).isEqualTo("updated_at");
        assertThat(response.getTotalPrivateRepoCount()).isEqualTo(5);
        assertThat(response.getOwnedPrivateRepoCount()).isEqualTo(6);
        assertThat(response.getPrivateGistCount()).isEqualTo(7);
        assertThat(response.getDiskUsage()).isEqualTo(8);
        assertThat(response.getCollaboratorCount()).isEqualTo(9);
        assertThat(response.getPlan()).isNotNull();
    }
    
    @Test
    public void parcelable_shouldCreateFromParcel() {
        UserResponse response = GsonHelper.fromJson(MockResponses.AUTH_USER,
                UserResponse.class);
        response.setStatusCode(200);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);
        
        parcel.setDataPosition(0);
        UserResponse parcelled = UserResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getStatusCode()).isEqualTo(response.getStatusCode());
        assertThat(parcelled.getLogin()).isEqualTo(response.getLogin());
        assertThat(parcelled.getId()).isEqualTo(response.getId());
        assertThat(parcelled.getAvatarUrl()).isEqualTo(response.getAvatarUrl());
        assertThat(parcelled.getGravatarId()).isEqualTo(response.getGravatarId());
        assertThat(parcelled.getUrl()).isEqualTo(response.getUrl());
        assertThat(parcelled.getHtmlUrl()).isEqualTo(response.getHtmlUrl());
        assertThat(parcelled.getFollowersUrl()).isEqualTo(response.getFollowersUrl());
        assertThat(parcelled.getFollowingUrl()).isEqualTo(response.getFollowingUrl());
        assertThat(parcelled.getGistsUrl()).isEqualTo(response.getGistsUrl());
        assertThat(parcelled.getStarredUrl()).isEqualTo(response.getStarredUrl());
        assertThat(parcelled.getSubscriptionsUrl()).isEqualTo(response.getSubscriptionsUrl());
        assertThat(parcelled.getOrganizationsUrl()).isEqualTo(response.getOrganizationsUrl());
        assertThat(parcelled.getReposUrl()).isEqualTo(response.getReposUrl());
        assertThat(parcelled.getEventsUrl()).isEqualTo(response.getEventsUrl());
        assertThat(parcelled.getReceivedEventsUrl()).isEqualTo(response.getReceivedEventsUrl());
        assertThat(parcelled.getType()).isEqualTo(response.getType());
        assertThat(parcelled.isIsSiteAdmin()).isEqualTo(response.isIsSiteAdmin());
        assertThat(parcelled.getName()).isEqualTo(response.getName());
        assertThat(parcelled.getCompany()).isEqualTo(response.getCompany());
        assertThat(parcelled.getBlogUrl()).isEqualTo(response.getBlogUrl());
        assertThat(parcelled.getLocation()).isEqualTo(response.getLocation());
        assertThat(parcelled.getEmail()).isEqualTo(response.getEmail());
        assertThat(parcelled.isHireable()).isEqualTo(response.isHireable());
        assertThat(parcelled.getBio()).isEqualTo(response.getBio());
        assertThat(parcelled.getPublicRepoCount()).isEqualTo(response.getPublicRepoCount());
        assertThat(parcelled.getPublicGistCount()).isEqualTo(response.getPublicGistCount());
        assertThat(parcelled.getFollowerCount()).isEqualTo(response.getFollowerCount());
        assertThat(parcelled.getFollowingCount()).isEqualTo(response.getFollowingCount());
        assertThat(parcelled.getCreatedAt()).isEqualTo(response.getCreatedAt());
        assertThat(parcelled.getUpdatedAt()).isEqualTo(response.getUpdatedAt());
        assertThat(parcelled.getTotalPrivateRepoCount()).isEqualTo(response.getTotalPrivateRepoCount());
        assertThat(parcelled.getOwnedPrivateRepoCount()).isEqualTo(response.getOwnedPrivateRepoCount());
        assertThat(parcelled.getPrivateGistCount()).isEqualTo(response.getPrivateGistCount());
        assertThat(parcelled.getDiskUsage()).isEqualTo(response.getDiskUsage());
        assertThat(parcelled.getCollaboratorCount()).isEqualTo(response.getCollaboratorCount());
        assertThat(parcelled.getPlan()).isNotNull();
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        UserResponse[] responses = UserResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (UserResponse response : responses) {
            assertThat(response).isNull();
        }
    }
}
