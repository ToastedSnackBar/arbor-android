package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class OrganizationResponse extends ApiResponse {

    @SerializedName("id")
    private int mId;

    @SerializedName("login")
    private String mLogin;

    @SerializedName("gravatar_id")
    private String mGravatarId;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    public OrganizationResponse(Parcel source) {
        super(source);

        mId = source.readInt();
        mLogin = source.readString();
        mGravatarId = source.readString();
        mUrl = source.readString();
        mAvatarUrl = source.readString();
    }

    public int getId() {
        return mId;
    }

    public String getLogin() {
        return mLogin;
    }

    public String getGravatarId() {
        return mGravatarId;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public static final Creator<OrganizationResponse> CREATOR = new Creator<OrganizationResponse>() {

        @Override
        public OrganizationResponse createFromParcel(Parcel source) {
            return new OrganizationResponse(source);
        }

        @Override
        public OrganizationResponse[] newArray(int size) {
            return new OrganizationResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeInt(mId);
        dest.writeString(mLogin);
        dest.writeString(mGravatarId);
        dest.writeString(mUrl);
        dest.writeString(mAvatarUrl);
    }
}
