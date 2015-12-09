package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class MilestoneResponse extends ApiResponse {

    @SerializedName("url")
    private String mUrl;

    @SerializedName("html_url")
    private String mHtmlUrl;

    @SerializedName("labels_url")
    private String mLabelsUrl;

    @SerializedName("id")
    private long mId;

    @SerializedName("number")
    private int mNumber;

    @SerializedName("state")
    private String mState;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("creator")
    private UserResponse mCreator;

    @SerializedName("open_issues")
    private int mOpenIssueCount;

    @SerializedName("closed_issues")
    private int mClosedIssueCount;

    @SerializedName("created_at")
    private String mCreatedAt;

    @SerializedName("updated_at")
    private String mUpdatedAt;

    @SerializedName("closed_at")
    private String mClosedAt;

    @SerializedName("due_on")
    private String mDueOn;

    public MilestoneResponse(Parcel source) {
        super(source);

        mUrl = source.readString();
        mHtmlUrl = source.readString();
        mLabelsUrl = source.readString();
        mId = source.readLong();
        mNumber = source.readInt();
        mState = source.readString();
        mTitle = source.readString();
        mDescription = source.readString();
        mCreator = source.readParcelable(getClass().getClassLoader());
        mOpenIssueCount = source.readInt();
        mClosedIssueCount = source.readInt();
        mCreatedAt = source.readString();
        mUpdatedAt = source.readString();
        mClosedAt = source.readString();
        mDueOn = source.readString();
    }

    public String getUrl() {
        return mUrl;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public String getLabelsUrl() {
        return mLabelsUrl;
    }

    public long getId() {
        return mId;
    }

    public int getNumber() {
        return mNumber;
    }

    public String getState() {
        return mState;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public UserResponse getCreator() {
        return mCreator;
    }

    public int getOpenIssueCount() {
        return mOpenIssueCount;
    }

    public int getClosedIssueCount() {
        return mClosedIssueCount;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public String getClosedAt() {
        return mClosedAt;
    }

    public String getDueOn() {
        return mDueOn;
    }

    public static final Creator<MilestoneResponse> CREATOR = new Creator<MilestoneResponse>() {

        @Override
        public MilestoneResponse createFromParcel(Parcel source) {
            return new MilestoneResponse(source);
        }

        @Override
        public MilestoneResponse[] newArray(int size) {
            return new MilestoneResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(mUrl);
        dest.writeString(mHtmlUrl);
        dest.writeString(mLabelsUrl);
        dest.writeLong(mId);
        dest.writeInt(mNumber);
        dest.writeString(mState);
        dest.writeString(mTitle);
        dest.writeString(mDescription);
        dest.writeParcelable(mCreator, 0);
        dest.writeInt(mOpenIssueCount);
        dest.writeInt(mClosedIssueCount);
        dest.writeString(mCreatedAt);
        dest.writeString(mUpdatedAt);
        dest.writeString(mClosedAt);
        dest.writeString(mDueOn);
    }
}
