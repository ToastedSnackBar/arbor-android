package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.responses.AccessTokenResponse;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessTokenRequest extends ApiRequest<AccessTokenResponse> {

    private static final Set<Integer> ACCEPTED_RESPONSE_CODES = new HashSet<>(Arrays.asList(200));
    private static final String URL = ApiEndpoints.getOAuthUrl();

    private String mCode;
    private String mClientId;
    private String mSecret;
    private String mState;

    public AccessTokenRequest(String code, String clientId, String secret, String state) {
        mCode = code;
        mClientId = clientId;
        mSecret = secret;
        mState = state;
    }

    public AccessTokenRequest(Parcel source) {
        mCode = source.readString();
        mClientId = source.readString();
        mSecret = source.readString();
        mState = source.readString();
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
        dest.writeString(mCode);
        dest.writeString(mClientId);
        dest.writeString(mSecret);
        dest.writeString(mState);
    }

    @Override
    protected String getUrl() {
        return URL;
    }

    @Override
    protected String getRequestMethod() {
        return ApiRequest.METHOD_POST;
    }

    @Override
    protected String getRequestEntity() {
        AccessTokenEntity entity = new AccessTokenEntity(mCode, mClientId, mSecret, mState);
        return new Gson().toJson(entity);
    }

    @Override
    protected Map<String, String> getProperties() {
        return null;
    }

    @Override
    protected Set<Integer> getAcceptedResponseCodes() {
        return ACCEPTED_RESPONSE_CODES;
    }

    @Override
    protected Class<AccessTokenResponse> getResponseClass() {
        return AccessTokenResponse.class;
    }

    private static class AccessTokenEntity {

        @SerializedName("code")
        private String mCode;

        @SerializedName("client_id")
        private String mClientId;

        @SerializedName("client_secret")
        private String mSecret;

        @SerializedName("state")
        private String mState;

        public AccessTokenEntity(String code, String clientId, String secret, String state) {
            mCode = code;
            mClientId = clientId;
            mSecret = secret;
            mState = state;
        }
    }
}
