package com.github.toastedsnackbar.arbor.net.responses.events;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.responses.CommitResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PushEventPayloadResponse extends EventPayloadResponse {

    @SerializedName("push_id")
    private int mPushId;

    @SerializedName("size")
    private int mSize;

    @SerializedName("distinct_size")
    private int mDistinctSize;

    @SerializedName("ref")
    private String mRef;

    @SerializedName("head")
    private String mHead;

    @SerializedName("before")
    private String mBefore;

    @SerializedName("commits")
    private List<CommitResponse> mCommits;

    public int getPushId() {
        return mPushId;
    }

    public int getSize() {
        return mSize;
    }

    public int getDistinctSize() {
        return mDistinctSize;
    }

    public String getRef() {
        return mRef;
    }

    public String getHead() {
        return mHead;
    }

    public String getBefore() {
        return mBefore;
    }

    public List<CommitResponse> getCommits() {
        return mCommits;
    }

    public PushEventPayloadResponse(Parcel source) {
        super(source);

        mPushId = source.readInt();
        mSize = source.readInt();
        mDistinctSize = source.readInt();
        mRef = source.readString();
        mHead = source.readString();
        mBefore = source.readString();
        mCommits = new ArrayList<>();
        source.readTypedList(mCommits, CommitResponse.CREATOR);
    }

    public static final Creator<PushEventPayloadResponse> CREATOR =
            new Creator<PushEventPayloadResponse>() {

        @Override
        public PushEventPayloadResponse createFromParcel(Parcel source) {
            return new PushEventPayloadResponse(source);
        }

        @Override
        public PushEventPayloadResponse[] newArray(int size) {
            return new PushEventPayloadResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeInt(mPushId);
        dest.writeInt(mSize);
        dest.writeInt(mDistinctSize);
        dest.writeString(mRef);
        dest.writeString(mHead);
        dest.writeString(mBefore);
        dest.writeTypedList(mCommits);
    }
}
