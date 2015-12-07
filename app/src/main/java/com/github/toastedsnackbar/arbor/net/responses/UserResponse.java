package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class UserResponse extends ApiResponse {

    @SerializedName("login")
    private String mLogin;

    @SerializedName("id")
    private int mId;

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

    @SerializedName("name")
    private String mName;

    @SerializedName("company")
    private String mCompany;

    @SerializedName("blog")
    private String mBlogUrl;

    @SerializedName("location")
    private String mLocation;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("hireable")
    private boolean mIsHireable;

    @SerializedName("bio")
    private String mBio;

    @SerializedName("public_repos")
    private int mPublicRepoCount;

    @SerializedName("public_gists")
    private int mPublicGistCount;

    @SerializedName("followers")
    private int mFollowerCount;

    @SerializedName("following")
    private int mFollowingCount;

    @SerializedName("created_at")
    private String mCreatedAt;

    @SerializedName("updated_at")
    private String mUpdatedAt;

    @SerializedName("total_private_repos")
    private int mTotalPrivateRepoCount;

    @SerializedName("owned_private_repos")
    private int mOwnedPrivateRepoCount;

    @SerializedName("private_gists")
    private int mPrivateGistCount;

    @SerializedName("disk_usage")
    private int mDiskUsage;

    @SerializedName("collaborators")
    private int mCollaboratorCount;

    @SerializedName("plan")
    private PlanResponse mPlan;

    public UserResponse(Parcel source) {
        super(source);

        mLogin = source.readString();
        mId = source.readInt();
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
        mName = source.readString();
        mCompany = source.readString();
        mBlogUrl = source.readString();
        mLocation = source.readString();
        mEmail = source.readString();
        mIsHireable = source.readByte() != 0;
        mBio = source.readString();
        mPublicRepoCount = source.readInt();
        mPublicGistCount = source.readInt();
        mFollowerCount = source.readInt();
        mFollowingCount = source.readInt();
        mCreatedAt = source.readString();
        mUpdatedAt = source.readString();
        mTotalPrivateRepoCount = source.readInt();
        mOwnedPrivateRepoCount = source.readInt();
        mPrivateGistCount = source.readInt();
        mDiskUsage = source.readInt();
        mCollaboratorCount = source.readInt();
        mPlan = source.readParcelable(getClass().getClassLoader());
    }

    public String getLogin() {
        return mLogin;
    }

    public int getId() {
        return mId;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public String getGravatarId() {
        return mGravatarId;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public String getFollowersUrl() {
        return mFollowersUrl;
    }

    public String getFollowingUrl() {
        return mFollowingUrl;
    }

    public String getGistsUrl() {
        return mGistsUrl;
    }

    public String getStarredUrl() {
        return mStarredUrl;
    }

    public String getSubscriptionsUrl() {
        return mSubscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return mOrganizationsUrl;
    }

    public String getReposUrl() {
        return mReposUrl;
    }

    public String getEventsUrl() {
        return mEventsUrl;
    }

    public String getReceivedEventsUrl() {
        return mReceivedEventsUrl;
    }

    public String getType() {
        return mType;
    }

    public boolean isIsSiteAdmin() {
        return mIsSiteAdmin;
    }

    public String getName() {
        return mName;
    }

    public String getCompany() {
        return mCompany;
    }

    public String getBlogUrl() {
        return mBlogUrl;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getEmail() {
        return mEmail;
    }

    public boolean isHireable() {
        return mIsHireable;
    }

    public String getBio() {
        return mBio;
    }

    public int getPublicRepoCount() {
        return mPublicRepoCount;
    }

    public int getPublicGistCount() {
        return mPublicGistCount;
    }

    public int getFollowerCount() {
        return mFollowerCount;
    }

    public int getFollowingCount() {
        return mFollowingCount;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public int getTotalPrivateRepoCount() {
        return mTotalPrivateRepoCount;
    }

    public int getOwnedPrivateRepoCount() {
        return mOwnedPrivateRepoCount;
    }

    public int getPrivateGistCount() {
        return mPrivateGistCount;
    }

    public int getDiskUsage() {
        return mDiskUsage;
    }

    public int getCollaboratorCount() {
        return mCollaboratorCount;
    }

    public PlanResponse getPlan() {
        return mPlan;
    }

    public static final Creator<UserResponse> CREATOR = new Creator<UserResponse>() {

        @Override
        public UserResponse createFromParcel(Parcel source) {
            return new UserResponse(source);
        }

        @Override
        public UserResponse[] newArray(int size) {
            return new UserResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(mLogin);
        dest.writeInt(mId);
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
        dest.writeString(mName);
        dest.writeString(mCompany);
        dest.writeString(mBlogUrl);
        dest.writeString(mLocation);
        dest.writeString(mEmail);
        dest.writeByte((byte) (mIsHireable ? 1 : 0));
        dest.writeString(mBio);
        dest.writeInt(mPublicRepoCount);
        dest.writeInt(mPublicGistCount);
        dest.writeInt(mFollowerCount);
        dest.writeInt(mFollowingCount);
        dest.writeString(mCreatedAt);
        dest.writeString(mUpdatedAt);
        dest.writeInt(mTotalPrivateRepoCount);
        dest.writeInt(mOwnedPrivateRepoCount);
        dest.writeInt(mPrivateGistCount);
        dest.writeInt(mDiskUsage);
        dest.writeInt(mCollaboratorCount);
        dest.writeParcelable(mPlan, 0);
    }
}
