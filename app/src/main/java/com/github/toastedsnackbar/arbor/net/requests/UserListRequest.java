package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.responses.UserListResponse;

import java.util.Map;
import java.util.Set;

public class UserListRequest extends ApiRequest<UserListResponse> {

    String mUrl;
    String mRequestId;
    boolean mIsAuthorized;

    public UserListRequest(String url, boolean isAuthorized) {
        mUrl = url;
        mRequestId = mUrl;
        mIsAuthorized = isAuthorized;
    }

    public UserListRequest(Parcel source) {
        mUrl = source.readString();
        mRequestId = source.readString();
        mIsAuthorized = source.readByte() != 0;
    }

    public static final Creator<UserListRequest> CREATOR = new Creator<UserListRequest>() {

        @Override
        public UserListRequest createFromParcel(Parcel source) {
            return new UserListRequest(source);
        }

        @Override
        public UserListRequest[] newArray(int size) {
            return new UserListRequest[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUrl);
        dest.writeString(mRequestId);
        dest.writeByte((byte) (mIsAuthorized ? 1 : 0));
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
        return mIsAuthorized;
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
    protected Class<UserListResponse> getResponseClass() {
        return UserListResponse.class;
    }
}
