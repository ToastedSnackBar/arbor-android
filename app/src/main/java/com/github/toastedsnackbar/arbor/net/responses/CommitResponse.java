package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class CommitResponse extends ApiResponse {

    @SerializedName("sha")
    private String mSha;

    @SerializedName("author")
    private AuthorResponse mAuthor;

    @SerializedName("message")
    private String mMessage;

    @SerializedName("distinct")
    private boolean mIsDistinct;

    @SerializedName("url")
    private String mUrl;

    public CommitResponse(Parcel source) {
        super(source);

        mSha = source.readString();
        mAuthor = source.readParcelable(getClass().getClassLoader());
        mMessage = source.readString();
        mIsDistinct = source.readByte() != 0;
        mUrl = source.readString();
    }

    public String getSha() {
        return mSha;
    }

    public AuthorResponse getAuthor() {
        return mAuthor;
    }

    public String getMessage() {
        return mMessage;
    }

    public boolean isDistinct() {
        return mIsDistinct;
    }

    public String getUrl() {
        return mUrl;
    }

    public static final Creator<CommitResponse> CREATOR = new Creator<CommitResponse>() {

        @Override
        public CommitResponse createFromParcel(Parcel source) {
            return new CommitResponse(source);
        }

        @Override
        public CommitResponse[] newArray(int size) {
            return new CommitResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(mSha);
        dest.writeParcelable(mAuthor, 0);
        dest.writeString(mMessage);
        dest.writeByte((byte) (mIsDistinct ? 1 : 0));
        dest.writeString(mUrl);
    }
}
