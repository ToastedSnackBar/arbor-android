package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;
import com.github.toastedsnackbar.arbor.net.requests.entities.AccessTokenEntity;
import com.github.toastedsnackbar.arbor.net.responses.AccessTokenResponse;

import java.util.Map;
import java.util.Set;

public class AccessTokenRequest extends ApiRequest<AccessTokenResponse> {

    String mUrl;
    String mRequestEntity;
    String mRequestId;

    public AccessTokenRequest(String code, String clientId, String secret, String state) {
        mUrl = ApiEndpoints.getAccessTokenUrl();

        AccessTokenEntity entity = new AccessTokenEntity(code, clientId, secret, state);
        mRequestEntity = GsonHelper.toJson(entity);

        mRequestId = mUrl;
    }

    public AccessTokenRequest(Parcel source) {
        mUrl = source.readString();
        mRequestEntity = source.readString();
        mRequestId = source.readString();
    }

    public static final Creator<AccessTokenRequest> CREATOR = new Creator<AccessTokenRequest>() {

        @Override
        public AccessTokenRequest createFromParcel(Parcel source) {
            return new AccessTokenRequest(source);
        }

        @Override
        public AccessTokenRequest[] newArray(int size) {
            return new AccessTokenRequest[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUrl);
        dest.writeString(mRequestEntity);
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
        return METHOD_POST;
    }

    @Override
    protected String getRequestEntity() {
        return mRequestEntity;
    }

    @Override
    protected Set<Integer> getAcceptedStatuses() {
        return null;
    }

    @Override
    protected Class<AccessTokenResponse> getResponseClass() {
        return AccessTokenResponse.class;
    }
}
