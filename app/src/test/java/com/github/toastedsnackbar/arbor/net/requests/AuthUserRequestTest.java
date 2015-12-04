package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest(ApiEndpoints.class)
public class AuthUserRequestTest {

    @Rule
    public PowerMockRule mPowerMockRule = new PowerMockRule();

    @Test
    public void parcelable_shouldCreateFromParcel() {
        AuthUserRequest request = new AuthUserRequest();
        Parcel parcel = Parcel.obtain();
        request.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);
        AuthUserRequest parcelled = AuthUserRequest.CREATOR.createFromParcel(parcel);

        assertThat(parcelled).isNotNull();
        assertThat(parcelled.getRequestId()).isEqualTo(request.getRequestId());
        assertThat(parcelled.getUrl()).isEqualTo(request.getUrl());
    }

    @Test
    public void parcelable_shouldCreateArrayFromParcel() {
        final int SIZE = 10;

        AuthUserRequest[] requests = AuthUserRequest.CREATOR.newArray(SIZE);
        assertThat(requests.length).isEqualTo(SIZE);

        for (AuthUserRequest request : requests) {
            assertThat(request).isNull();
        }
    }
}
