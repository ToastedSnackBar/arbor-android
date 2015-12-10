package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.responses.IsFollowingResponse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AuthUserIsFollowingRequest extends ApiRequest<IsFollowingResponse> {

    private static final Set<Integer> ACCEPTED_STATUSES = new HashSet<>(Arrays.asList(204, 404));

    String mUrl;
    String mRequestId;

    public AuthUserIsFollowingRequest(String username) {
        mUrl = ApiEndpoints.getAuthUserIsFollowingUrl(username);
        mRequestId = mUrl;
    }

    public AuthUserIsFollowingRequest(Parcel source) {
        mUrl = source.readString();
        mRequestId = source.readString();
    }

    public static final Creator<AuthUserIsFollowingRequest> CREATOR =
            new Creator<AuthUserIsFollowingRequest>() {

        @Override
        public AuthUserIsFollowingRequest createFromParcel(Parcel source) {
            return new AuthUserIsFollowingRequest(source);
        }

        @Override
        public AuthUserIsFollowingRequest[] newArray(int size) {
            return new AuthUserIsFollowingRequest[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUrl);
        dest.writeString(mRequestId);
    }

    @Override
    public String getRequestId() {
        return mRequestId;
    }

    @Override
    protected String getUrl() {
        return mUrl;
    }

    @Override
    protected Map<String, String> getProperties() {
        return null;
    }

    @Override
    protected boolean isAuthorizedRequest() {
        return true;
    }

    @Override
    protected String getRequestMethod() {
        return METHOD_GET;
    }

    @Override
    protected String getRequestEntity() {
        return null;
    }

    @Override
    protected Set<Integer> getAcceptedStatuses() {
        return ACCEPTED_STATUSES;
    }

    @Override
    protected Class<IsFollowingResponse> getResponseClass() {
        return IsFollowingResponse.class;
    }
}
