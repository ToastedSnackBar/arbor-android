package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class RepoResponse extends ApiResponse {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("url")
    private String mUrl;

    public RepoResponse(Parcel source) {
        super(source);

        mId = source.readInt();
        mName = source.readString();
        mUrl = source.readString();
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getUrl() {
        return mUrl;
    }

    public static Creator<RepoResponse> CREATOR = new Creator<RepoResponse>() {

        @Override
        public RepoResponse createFromParcel(Parcel source) {
            return new RepoResponse(source);
        }

        @Override
        public RepoResponse[] newArray(int size) {
            return new RepoResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeString(mUrl);
    }
}
