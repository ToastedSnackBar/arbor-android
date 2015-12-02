package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class RepositoryResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        RepositoryResponse response = new Gson().fromJson(MOCK_RESPONSE_BODY,
                RepositoryResponse.class);

        assertThat(response.getName()).isEqualTo("coding-challenge");
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        RepositoryResponse response = new Gson().fromJson(MOCK_RESPONSE_BODY,
                RepositoryResponse.class);
        Parcel parcel = Parcel.obtain();
        response.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        RepositoryResponse parcelled = RepositoryResponse.CREATOR.createFromParcel(parcel);

        assertThat(parcelled.getName()).isEqualTo(response.getName());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        RepositoryResponse[] responses = RepositoryResponse.CREATOR.newArray(SIZE);
        assertThat(responses.length).isEqualTo(SIZE);

        for (RepositoryResponse response : responses) {
            assertThat(response).isNull();
        }
    }

    private static final String MOCK_RESPONSE_BODY =
            "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"coding-challenge\",\n" +
            "  \"full_name\": \"okamayana\\/coding-challenge\",\n" +
            "  \"owner\": {\n" +
            "    \"login\": \"okamayana\",\n" +
            "    \"id\": 3643607,\n" +
            "    \"avatar_url\": \"https:\\/\\/avatars.githubusercontent" +
            ".com\\/u\\/3643607?v=3\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https:\\/\\/api.github.com\\/users\\/okamayana\",\n" +
            "    \"html_url\": \"https:\\/\\/github.com\\/okamayana\",\n" +
            "    \"followers_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/followers\",\n" +
            "    \"following_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/following{\\/other_user}\",\n" +
            "    \"gists_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/gists{\\/gist_id}\",\n" +
            "    \"starred_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/starred{\\/owner}{\\/repo}\",\n" +
            "    \"subscriptions_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/subscriptions\",\n" +
            "    \"organizations_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/orgs\",\n" +
            "    \"repos_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/repos\",\n" +
            "    \"events_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/events{\\/privacy}\",\n" +
            "    \"received_events_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  },\n" +
            "  \"private\": false,\n" +
            "  \"html_url\": \"https:\\/\\/github.com\\/okamayana\\/coding-challenge\",\n" +
            "  \"description\": \"\",\n" +
            "  \"fork\": false,\n" +
            "  \"url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\",\n" +
            "  \"forks_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/forks\",\n" +
            "  \"keys_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/keys{\\/key_id}\",\n" +
            "  \"collaborators_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/collaborators{\\/collaborator" +
            "}\",\n" +
            "  \"teams_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/teams\",\n" +
            "  \"hooks_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/hooks\",\n" +
            "  \"issue_events_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/issues\\/events{\\/number}\"," +
            "\n" +
            "  \"events_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/events\",\n" +
            "  \"assignees_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/assignees{\\/user}\",\n" +
            "  \"branches_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/branches{\\/branch}\",\n" +
            "  \"tags_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/tags\",\n" +
            "  \"blobs_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/blobs{\\/sha}\",\n" +
            "  \"git_tags_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/tags{\\/sha}\",\n" +
            "  \"git_refs_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/refs{\\/sha}\",\n" +
            "  \"trees_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/trees{\\/sha}\",\n" +
            "  \"statuses_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/statuses\\/{sha}\",\n" +
            "  \"languages_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/languages\",\n" +
            "  \"stargazers_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/stargazers\",\n" +
            "  \"contributors_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/contributors\",\n" +
            "  \"subscribers_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/subscribers\",\n" +
            "  \"subscription_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/subscription\",\n" +
            "  \"commits_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/commits{\\/sha}\",\n" +
            "  \"git_commits_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/commits{\\/sha}\",\n" +
            "  \"comments_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/comments{\\/number}\",\n" +
            "  \"issue_comment_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/issues\\/comments{\\/number" +
            "}\",\n" +
            "  \"contents_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/contents\\/{+path}\",\n" +
            "  \"compare_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/compare\\/{base}...{head}\",\n" +
            "  \"merges_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/merges\",\n" +
            "  \"archive_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/{archive_format}{\\/ref}\",\n" +
            "  \"downloads_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/downloads\",\n" +
            "  \"issues_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/issues{\\/number}\",\n" +
            "  \"pulls_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/pulls{\\/number}\",\n" +
            "  \"milestones_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/milestones{\\/number}\",\n" +
            "  \"notifications_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/notifications{?since,all," +
            "participating}\",\n" +
            "  \"labels_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/labels{\\/name}\",\n" +
            "  \"releases_url\": \"https:\\/\\/api.github" +
            ".com\\/repos\\/okamayana\\/coding-challenge\\/releases{\\/id}\",\n" +
            "  \"created_at\": \"2014-04-26T04:30:57Z\",\n" +
            "  \"updated_at\": \"2014-07-31T14:52:31Z\",\n" +
            "  \"pushed_at\": \"2014-04-28T05:53:00Z\",\n" +
            "  \"git_url\": \"git:\\/\\/github.com\\/okamayana\\/coding-challenge.git\"," +
            "\n" +
            "  \"ssh_url\": \"git@github.com:okamayana\\/coding-challenge.git\",\n" +
            "  \"clone_url\": \"https:\\/\\/github.com\\/okamayana\\/coding-challenge" +
            ".git\",\n" +
            "  \"svn_url\": \"https:\\/\\/github.com\\/okamayana\\/coding-challenge\",\n" +
            "  \"homepage\": \"\",\n" +
            "  \"size\": 404,\n" +
            "  \"stargazers_count\": 0,\n" +
            "  \"watchers_count\": 0,\n" +
            "  \"language\": \"Java\",\n" +
            "  \"has_issues\": false,\n" +
            "  \"has_downloads\": true,\n" +
            "  \"has_wiki\": true,\n" +
            "  \"has_pages\": false,\n" +
            "  \"forks_count\": 0,\n" +
            "  \"mirror_url\": null,\n" +
            "  \"open_issues_count\": 0,\n" +
            "  \"forks\": 0,\n" +
            "  \"open_issues\": 0,\n" +
            "  \"watchers\": 0,\n" +
            "  \"default_branch\": \"master\"\n" +
            "}";
}
