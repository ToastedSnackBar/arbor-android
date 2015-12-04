package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.responses.AuthUserResponse;

import java.util.Map;
import java.util.Set;

public class AuthUserRequest extends ApiRequest {

    String mUrl;
    String mRequestId;

    public AuthUserRequest() {
        mUrl = ApiEndpoints.getAuthUserUrl();
        mRequestId = mUrl;
    }

    public AuthUserRequest(Parcel source) {
        mUrl = source.readString();
        mRequestId = source.readString();
    }

    public static final Creator<AuthUserRequest> CREATOR = new Creator<AuthUserRequest>() {
        @Override
        public AuthUserRequest createFromParcel(Parcel source) {
            return new AuthUserRequest(source);
        }

        @Override
        public AuthUserRequest[] newArray(int size) {
            return new AuthUserRequest[size];
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
        return null;
    }

    @Override
    protected Class getResponseClass() {
        return AuthUserResponse.class;
    }
}
