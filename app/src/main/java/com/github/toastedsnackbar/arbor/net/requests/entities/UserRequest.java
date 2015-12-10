package com.github.toastedsnackbar.arbor.net.requests.entities;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.requests.ApiRequest;
import com.github.toastedsnackbar.arbor.net.responses.UserResponse;

import java.util.Map;
import java.util.Set;

public class UserRequest extends ApiRequest<UserResponse> {

    private String mUrl;
    private String mRequestId;

    public UserRequest(String username) {
        mUrl = ApiEndpoints.getUserUrl(username);
        mRequestId = mUrl;
    }

    public UserRequest(Parcel source) {
        mUrl = source.readString();
        mRequestId = source.readString();
    }

    public static final Creator<UserRequest> CREATOR = new Creator<UserRequest>() {

        @Override
        public UserRequest createFromParcel(Parcel source) {
            return new UserRequest(source);
        }

        @Override
        public UserRequest[] newArray(int size) {
            return new UserRequest[size];
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
        return false;
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
        return null;
    }

    @Override
    protected Class<UserResponse> getResponseClass() {
        return UserResponse.class;
    }
}
