package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class OwnerResponseTest {

    @Test
    public void gson_shouldParseCorrectly() {
        OwnerResponse response = new Gson().fromJson(MOCK_RESPONSE_BODY, OwnerResponse.class);

        assertThat(response.getLogin()).isEqualTo("okamayana");
        assertThat(response.getUserId()).isEqualTo("3643607");
    }

    @Test
    public void parcelable_shouldCreateFromParcel() {
        OwnerResponse response = new Gson().fromJson(MOCK_RESPONSE_BODY, OwnerResponse.class);
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

    private static final String MOCK_RESPONSE_BODY =
            "{\n" +
            "  \"login\": \"okamayana\",\n" +
            "  \"id\": 3643607,\n" +
            "  \"avatar_url\": \"https:\\/\\/avatars.githubusercontent" +
            ".com\\/u\\/3643607?v=3\",\n" +
            "  \"gravatar_id\": \"\",\n" +
            "  \"url\": \"https:\\/\\/api.github.com\\/users\\/okamayana\",\n" +
            "  \"html_url\": \"https:\\/\\/github.com\\/okamayana\",\n" +
            "  \"followers_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/followers\",\n" +
            "  \"following_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/following{\\/other_user}\",\n" +
            "  \"gists_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/gists{\\/gist_id}\",\n" +
            "  \"starred_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/starred{\\/owner}{\\/repo}\",\n" +
            "  \"subscriptions_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/subscriptions\",\n" +
            "  \"organizations_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/orgs\",\n" +
            "  \"repos_url\": \"https:\\/\\/api.github.com\\/users\\/okamayana\\/repos\"," +
            "\n" +
            "  \"events_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/events{\\/privacy}\",\n" +
            "  \"received_events_url\": \"https:\\/\\/api.github" +
            ".com\\/users\\/okamayana\\/received_events\",\n" +
            "  \"type\": \"User\",\n" +
            "  \"site_admin\": false\n" +
            "}";
}
