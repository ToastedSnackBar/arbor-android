package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

public class IsFollowingResponse extends ApiResponse {

    public IsFollowingResponse() { }

    public IsFollowingResponse(Parcel source) {
        super(source);
    }

    public static final Creator<IsFollowingResponse> CREATOR = new Creator<IsFollowingResponse>() {

        @Override
        public IsFollowingResponse createFromParcel(Parcel source) {
            return new IsFollowingResponse(source);
        }

        @Override
        public IsFollowingResponse[] newArray(int size) {
            return new IsFollowingResponse[size];
        }
    };
}
