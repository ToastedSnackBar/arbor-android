package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class AccessTokenResponse extends ApiResponse {

    @SerializedName("access_token")
    private String mAccessToken;

    @SerializedName("scope")
    private String mScope;

    @SerializedName("token_type")
    private String mTokenType;

    public AccessTokenResponse(Parcel source) {
        super(source);

        mAccessToken = source.readString();
        mScope = source.readString();
        mTokenType = source.readString();
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public String getTokenType() {
        return mTokenType;
    }

    public static final Creator<AccessTokenResponse> CREATOR = new Creator<AccessTokenResponse>() {

        @Override
        public AccessTokenResponse createFromParcel(Parcel source) {
            return new AccessTokenResponse(source);
        }

        @Override
        public AccessTokenResponse[] newArray(int size) {
            return new AccessTokenResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(mAccessToken);
        dest.writeString(mScope);
        dest.writeString(mTokenType);
    }
}
