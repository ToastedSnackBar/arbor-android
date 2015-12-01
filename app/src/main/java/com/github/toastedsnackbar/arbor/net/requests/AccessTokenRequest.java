package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.requests.entities.AccessTokenEntity;
import com.github.toastedsnackbar.arbor.net.responses.AccessTokenResponse;
import com.google.gson.Gson;

import java.util.Map;
import java.util.Set;

public class AccessTokenRequest extends ApiRequest<AccessTokenResponse> {

    private String mUrl;
    private String mRequestEntity;

    public AccessTokenRequest(String code, String clientId, String secret, String state) {
        mUrl = ApiEndpoints.getAccessTokenUrl();

        AccessTokenEntity entity = new AccessTokenEntity(code, clientId, secret, state);
        mRequestEntity = new Gson().toJson(entity);
    }

    public AccessTokenRequest(Parcel source) {
        mUrl = source.readString();
        mRequestEntity = source.readString();
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
    }

    @Override
    protected String getUrl() {
        return mUrl;
    }

    @Override
    protected String getRequestMethod() {
        return ApiRequest.METHOD_POST;
    }

    @Override
    protected String getRequestEntity() {
        return mRequestEntity;
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
    protected Set<Integer> getAcceptedStatuses() {
        return null;
    }

    @Override
    protected Class<AccessTokenResponse> getResponseClass() {
        return AccessTokenResponse.class;
    }
}
