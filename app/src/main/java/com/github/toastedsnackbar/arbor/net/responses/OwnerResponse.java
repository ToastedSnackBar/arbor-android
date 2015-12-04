package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class OwnerResponse extends ApiResponse {

    @SerializedName("id")
    private String mUserId;

    @SerializedName("login")
    private String mLogin;

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("gravatar_id")
    private String mGravatarId;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("html_url")
    private String mHtmlUrl;

    @SerializedName("followers_url")
    private String mFollowersUrl;

    @SerializedName("following_url")
    private String mFollowingUrl;

    @SerializedName("gists_url")
    private String mGistsUrl;

    @SerializedName("starred_url")
    private String mStarredUrl;

    @SerializedName("subscriptions_url")
    private String mSubscriptionsUrl;

    @SerializedName("organizations_url")
    private String mOrganizationsUrl;

    @SerializedName("repos_url")
    private String mReposUrl;

    @SerializedName("events_url")
    private String mEventsUrl;

    @SerializedName("received_events_url")
    private String mReceivedEventsUrl;

    @SerializedName("type")
    private String mType;

    @SerializedName("site_admin")
    private boolean mIsSiteAdmin;

    public OwnerResponse(Parcel source) {
        super(source);

        mUserId = source.readString();
        mLogin = source.readString();
        mAvatarUrl = source.readString();
        mGravatarId = source.readString();
        mUrl = source.readString();
        mHtmlUrl = source.readString();
        mFollowersUrl = source.readString();
        mFollowingUrl = source.readString();
        mGistsUrl = source.readString();
        mStarredUrl = source.readString();
        mSubscriptionsUrl = source.readString();
        mOrganizationsUrl = source.readString();
        mReposUrl = source.readString();
        mEventsUrl = source.readString();
        mReceivedEventsUrl = source.readString();
        mType = source.readString();
        mIsSiteAdmin = source.readByte() != 0;
    }

    public String getLogin() {
        return mLogin;
    }

    public String getUserId() {
        return mUserId;
    }

    public static Creator<OwnerResponse> CREATOR = new Creator<OwnerResponse>() {

        @Override
        public OwnerResponse createFromParcel(Parcel source) {
            return new OwnerResponse(source);
        }

        @Override
        public OwnerResponse[] newArray(int size) {
            return new OwnerResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(mUserId);
        dest.writeString(mLogin);
        dest.writeString(mAvatarUrl);
        dest.writeString(mGravatarId);
        dest.writeString(mUrl);
        dest.writeString(mHtmlUrl);
        dest.writeString(mFollowersUrl);
        dest.writeString(mFollowingUrl);
        dest.writeString(mGistsUrl);
        dest.writeString(mStarredUrl);
        dest.writeString(mSubscriptionsUrl);
        dest.writeString(mOrganizationsUrl);
        dest.writeString(mReposUrl);
        dest.writeString(mEventsUrl);
        dest.writeString(mReceivedEventsUrl);
        dest.writeString(mType);
        dest.writeByte((byte) (mIsSiteAdmin ? 1 : 0));
    }
}
