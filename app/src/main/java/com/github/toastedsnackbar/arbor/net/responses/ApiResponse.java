package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

public abstract class ApiResponse implements Parcelable {

    private int mStatusCode = -1;
    private long mObtainedAt = -1L;

    public ApiResponse() {}

    public ApiResponse(Parcel source) {
        mStatusCode = source.readInt();
        mObtainedAt = source.readLong();
    }

    public void setStatusCode(int statusCode) {
        mStatusCode = statusCode;
    }

    public void setObtainedAt(long responseTime) {
        mObtainedAt = responseTime;
    }

    public int getStatusCode() {
        return mStatusCode;
    }

    public long getObtainedAt() {
        return mObtainedAt;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mStatusCode);
        dest.writeLong(mObtainedAt);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
