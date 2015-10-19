package com.github.toastedsnackbar.arbor.net.requests.entities;

import com.github.toastedsnackbar.arbor.net.ApiEndpoints.Params;
import com.google.gson.annotations.SerializedName;

public class AccessTokenEntity {

    @SerializedName(Params.CODE)
    private String mCode;

    @SerializedName(Params.CLIENT_ID)
    private String mClientId;

    @SerializedName(Params.CLIENT_SECRET)
    private String mSecret;

    @SerializedName(Params.STATE)
    private String mState;

    public AccessTokenEntity(String code, String clientId, String secret, String state) {
        mCode = code;
        mClientId = clientId;
        mSecret = secret;
        mState = state;
    }
}
