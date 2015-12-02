package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryListResponse;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.RuntimeEnvironment;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest(ApiEndpoints.class)
public class RepositoryListRequestTest {

    @Rule
    public PowerMockRule mPowerMockRule = new PowerMockRule();

    @Test
    public void parcelable_shouldCreateFromParcel() {
        RepositoryListRequest request = new RepositoryListRequest();
        Parcel parcel = Parcel.obtain();
        request.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        RepositoryListRequest parcelled = RepositoryListRequest.CREATOR.createFromParcel
                (parcel);

        assertThat(parcelled.getUrl()).isEqualTo(request.getUrl());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        RepositoryListRequest[] requests = RepositoryListRequest.CREATOR.newArray(SIZE);
        assertThat(requests.length).isEqualTo(SIZE);

        for (RepositoryListRequest request : requests) {
            assertThat(request).isNull();
        }
    }

    @Test
    public void execute_shouldExecuteHttpRequestWithCorrectParams() throws IOException {
        MockResponse mockResponse = new MockResponse();
        mockResponse.setResponseCode(200);
        mockResponse.setBody(MOCK_RESPONSE_BODY);

        MockWebServer mockServer = new MockWebServer();
        mockServer.enqueue(mockResponse);
        mockServer.start();

        ArborPreferences.init(RuntimeEnvironment.application);
        ArborPreferences.setAccessToken("access_token");

        String mockUrl = mockServer.url("/user/repos").toString();
        PowerMockito.mockStatic(ApiEndpoints.class);
        Mockito.when(ApiEndpoints.getAuthUserReposUrl()).thenReturn(mockUrl);

        RepositoryListRequest request = new RepositoryListRequest();
        RepositoryListResponse response = request.execute();

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getItems().size()).isEqualTo(2);
    }

    private static final String MOCK_RESPONSE_BODY =
            "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"name\": \"coding-challenge\",\n" +
            "    \"full_name\": \"okamayana/coding-challenge\",\n" +
            "    \"owner\": {\n" +
            "      \"login\": \"okamayana\",\n" +
            "      \"id\": 3643607,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent" +
            ".com/u/3643607?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/okamayana\",\n" +
            "      \"html_url\": \"https://github.com/okamayana\",\n" +
            "      \"followers_url\": \"https://api.github" +
            ".com/users/okamayana/followers\",\n" +
            "      \"following_url\": \"https://api.github" +
            ".com/users/okamayana/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github" +
            ".com/users/okamayana/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github" +
            ".com/users/okamayana/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github" +
            ".com/users/okamayana/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github" +
            ".com/users/okamayana/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/okamayana/repos\",\n" +
            "      \"events_url\": \"https://api.github" +
            ".com/users/okamayana/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github" +
            ".com/users/okamayana/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false\n" +
            "    },\n" +
            "    \"private\": false,\n" +
            "    \"html_url\": \"https://github.com/okamayana/coding-challenge\",\n" +
            "    \"description\": \"\",\n" +
            "    \"fork\": false,\n" +
            "    \"url\": \"https://api.github.com/repos/okamayana/coding-challenge\",\n" +
            "    \"forks_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/forks\",\n" +
            "    \"keys_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/keys{/key_id}\",\n" +
            "    \"collaborators_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/collaborators{/collaborator}\",\n" +
            "    \"teams_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/teams\",\n" +
            "    \"hooks_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/hooks\",\n" +
            "    \"issue_events_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/issues/events{/number}\",\n" +
            "    \"events_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/events\",\n" +
            "    \"assignees_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/assignees{/user}\",\n" +
            "    \"branches_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/branches{/branch}\",\n" +
            "    \"tags_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/tags\",\n" +
            "    \"blobs_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/git/blobs{/sha}\",\n" +
            "    \"git_tags_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/git/tags{/sha}\",\n" +
            "    \"git_refs_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/git/refs{/sha}\",\n" +
            "    \"trees_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/git/trees{/sha}\",\n" +
            "    \"statuses_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/statuses/{sha}\",\n" +
            "    \"languages_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/languages\",\n" +
            "    \"stargazers_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/stargazers\",\n" +
            "    \"contributors_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/contributors\",\n" +
            "    \"subscribers_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/subscribers\",\n" +
            "    \"subscription_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/subscription\",\n" +
            "    \"commits_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/commits{/sha}\",\n" +
            "    \"git_commits_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/git/commits{/sha}\",\n" +
            "    \"comments_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/comments{/number}\",\n" +
            "    \"issue_comment_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/issues/comments{/number}\",\n" +
            "    \"contents_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/contents/{+path}\",\n" +
            "    \"compare_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/compare/{base}...{head}\",\n" +
            "    \"merges_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/merges\",\n" +
            "    \"archive_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/{archive_format}{/ref}\",\n" +
            "    \"downloads_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/downloads\",\n" +
            "    \"issues_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/issues{/number}\",\n" +
            "    \"pulls_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/pulls{/number}\",\n" +
            "    \"milestones_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/milestones{/number}\",\n" +
            "    \"notifications_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/notifications{?since,all," +
            "participating}\",\n" +
            "    \"labels_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/labels{/name}\",\n" +
            "    \"releases_url\": \"https://api.github" +
            ".com/repos/okamayana/coding-challenge/releases{/id}\",\n" +
            "    \"created_at\": \"2014-04-26T04:30:57Z\",\n" +
            "    \"updated_at\": \"2014-07-31T14:52:31Z\",\n" +
            "    \"pushed_at\": \"2014-04-28T05:53:00Z\",\n" +
            "    \"git_url\": \"git://github.com/okamayana/coding-challenge.git\",\n" +
            "    \"ssh_url\": \"git@github.com:okamayana/coding-challenge.git\",\n" +
            "    \"clone_url\": \"https://github.com/okamayana/coding-challenge.git\",\n" +
            "    \"svn_url\": \"https://github.com/okamayana/coding-challenge\",\n" +
            "    \"homepage\": \"\",\n" +
            "    \"size\": 404,\n" +
            "    \"stargazers_count\": 0,\n" +
            "    \"watchers_count\": 0,\n" +
            "    \"language\": \"Java\",\n" +
            "    \"has_issues\": false,\n" +
            "    \"has_downloads\": true,\n" +
            "    \"has_wiki\": true,\n" +
            "    \"has_pages\": false,\n" +
            "    \"forks_count\": 0,\n" +
            "    \"mirror_url\": null,\n" +
            "    \"open_issues_count\": 0,\n" +
            "    \"forks\": 0,\n" +
            "    \"open_issues\": 0,\n" +
            "    \"watchers\": 0,\n" +
            "    \"default_branch\": \"master\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 26778640,\n" +
            "    \"name\": \"ece358-lab2\",\n" +
            "    \"full_name\": \"okamayana/ece358-lab2\",\n" +
            "    \"owner\": {\n" +
            "      \"login\": \"okamayana\",\n" +
            "      \"id\": 3643607,\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent" +
            ".com/u/3643607?v=3\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/okamayana\",\n" +
            "      \"html_url\": \"https://github.com/okamayana\",\n" +
            "      \"followers_url\": \"https://api.github" +
            ".com/users/okamayana/followers\",\n" +
            "      \"following_url\": \"https://api.github" +
            ".com/users/okamayana/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github" +
            ".com/users/okamayana/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github" +
            ".com/users/okamayana/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github" +
            ".com/users/okamayana/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github" +
            ".com/users/okamayana/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/okamayana/repos\",\n" +
            "      \"events_url\": \"https://api.github" +
            ".com/users/okamayana/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github" +
            ".com/users/okamayana/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false\n" +
            "    },\n" +
            "    \"private\": false,\n" +
            "    \"html_url\": \"https://github.com/okamayana/ece358-lab2\",\n" +
            "    \"description\": \"\",\n" +
            "    \"fork\": false,\n" +
            "    \"url\": \"https://api.github.com/repos/okamayana/ece358-lab2\",\n" +
            "    \"forks_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/forks\",\n" +
            "    \"keys_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/keys{/key_id}\",\n" +
            "    \"collaborators_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/collaborators{/collaborator}\",\n" +
            "    \"teams_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/teams\",\n" +
            "    \"hooks_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/hooks\",\n" +
            "    \"issue_events_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/issues/events{/number}\",\n" +
            "    \"events_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/events\",\n" +
            "    \"assignees_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/assignees{/user}\",\n" +
            "    \"branches_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/branches{/branch}\",\n" +
            "    \"tags_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/tags\",\n" +
            "    \"blobs_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/git/blobs{/sha}\",\n" +
            "    \"git_tags_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/git/tags{/sha}\",\n" +
            "    \"git_refs_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/git/refs{/sha}\",\n" +
            "    \"trees_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/git/trees{/sha}\",\n" +
            "    \"statuses_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/statuses/{sha}\",\n" +
            "    \"languages_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/languages\",\n" +
            "    \"stargazers_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/stargazers\",\n" +
            "    \"contributors_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/contributors\",\n" +
            "    \"subscribers_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/subscribers\",\n" +
            "    \"subscription_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/subscription\",\n" +
            "    \"commits_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/commits{/sha}\",\n" +
            "    \"git_commits_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/git/commits{/sha}\",\n" +
            "    \"comments_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/comments{/number}\",\n" +
            "    \"issue_comment_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/issues/comments{/number}\",\n" +
            "    \"contents_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/contents/{+path}\",\n" +
            "    \"compare_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/compare/{base}...{head}\",\n" +
            "    \"merges_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/merges\",\n" +
            "    \"archive_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/{archive_format}{/ref}\",\n" +
            "    \"downloads_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/downloads\",\n" +
            "    \"issues_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/issues{/number}\",\n" +
            "    \"pulls_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/pulls{/number}\",\n" +
            "    \"milestones_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/milestones{/number}\",\n" +
            "    \"notifications_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/notifications{?since,all,participating}\"," +
            "\n" +
            "    \"labels_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/labels{/name}\",\n" +
            "    \"releases_url\": \"https://api.github" +
            ".com/repos/okamayana/ece358-lab2/releases{/id}\",\n" +
            "    \"created_at\": \"2014-11-17T21:42:08Z\",\n" +
            "    \"updated_at\": \"2014-11-17T21:47:40Z\",\n" +
            "    \"pushed_at\": \"2014-11-17T21:47:40Z\",\n" +
            "    \"git_url\": \"git://github.com/okamayana/ece358-lab2.git\",\n" +
            "    \"ssh_url\": \"git@github.com:okamayana/ece358-lab2.git\",\n" +
            "    \"clone_url\": \"https://github.com/okamayana/ece358-lab2.git\",\n" +
            "    \"svn_url\": \"https://github.com/okamayana/ece358-lab2\",\n" +
            "    \"homepage\": null,\n" +
            "    \"size\": 108,\n" +
            "    \"stargazers_count\": 0,\n" +
            "    \"watchers_count\": 0,\n" +
            "    \"language\": \"Java\",\n" +
            "    \"has_issues\": true,\n" +
            "    \"has_downloads\": true,\n" +
            "    \"has_wiki\": true,\n" +
            "    \"has_pages\": false,\n" +
            "    \"forks_count\": 0,\n" +
            "    \"mirror_url\": null,\n" +
            "    \"open_issues_count\": 0,\n" +
            "    \"forks\": 0,\n" +
            "    \"open_issues\": 0,\n" +
            "    \"watchers\": 0,\n" +
            "    \"default_branch\": \"master\"\n" +
            "  }\n" +
            "]";
}
