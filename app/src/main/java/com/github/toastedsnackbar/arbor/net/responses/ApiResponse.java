package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class ApiResponse implements Parcelable {

    private int mStatusCode = -1;

    public ApiResponse(Parcel source) {
        mStatusCode = source.readInt();
    }

    public void setStatusCode(int statusCode) {
        mStatusCode = statusCode;
    }

    public int getStatusCode() {
        return mStatusCode;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mStatusCode);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
