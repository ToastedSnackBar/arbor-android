package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

public class UserListResponse extends ApiResponse {

    private List<UserResponse> mItems;

    public UserListResponse(List<UserResponse> items) {
        mItems = items;
    }

    public UserListResponse(Parcel source) {
        super(source);

        mItems = new ArrayList<>();
        source.readTypedList(mItems, UserResponse.CREATOR);
    }

    public List<UserResponse> getItems() {
        return mItems;
    }

    public static final Creator<UserListResponse> CREATOR = new Creator<UserListResponse>() {

        @Override
        public UserListResponse createFromParcel(Parcel source) {
            return new UserListResponse(source);
        }

        @Override
        public UserListResponse[] newArray(int size) {
            return new UserListResponse[size];
        }
    };
}
