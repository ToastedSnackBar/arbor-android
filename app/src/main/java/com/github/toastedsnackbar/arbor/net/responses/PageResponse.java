package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class PageResponse extends ApiResponse {

    @SerializedName("page_name")
    private String mPageName;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("summary")
    private String mSummary;

    @SerializedName("action")
    private String mAction;

    @SerializedName("sha")
    private String mSha;

    @SerializedName("html_url")
    private String mHtmlUrl;
    
    public PageResponse(Parcel source) {
        super(source);
        
        mPageName = source.readString();
        mTitle = source.readString();
        mSummary = source.readString();
        mAction = source.readString();
        mSha = source.readString();
        mHtmlUrl = source.readString();
    }

    public String getPageName() {
        return mPageName;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSummary() {
        return mSummary;
    }

    public String getAction() {
        return mAction;
    }

    public String getSha() {
        return mSha;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public static final Creator<PageResponse> CREATOR = new Creator<PageResponse>() {

        @Override
        public PageResponse createFromParcel(Parcel source) {
            return new PageResponse(source);
        }

        @Override
        public PageResponse[] newArray(int size) {
            return new PageResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(mPageName);
        dest.writeString(mTitle);
        dest.writeString(mSummary);
        dest.writeString(mAction);
        dest.writeString(mSha);
        dest.writeString(mHtmlUrl);
    }
}
