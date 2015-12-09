package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

public class RepositoryListResponse extends ApiResponse {

    private List<RepositoryResponse> mItems;

    public RepositoryListResponse(List<RepositoryResponse> items) {
        mItems = items;
    }

    public RepositoryListResponse(Parcel source) {
        super(source);

        mItems = new ArrayList<>();
        source.readTypedList(mItems, RepositoryResponse.CREATOR);
    }

    public List<RepositoryResponse> getItems() {
        return mItems;
    }

    public static final Creator<RepositoryListResponse> CREATOR = new
            Creator<RepositoryListResponse>() {

        @Override
        public RepositoryListResponse createFromParcel(Parcel source) {
            return new RepositoryListResponse(source);
        }

        @Override
        public RepositoryListResponse[] newArray(int size) {
            return new RepositoryListResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeTypedList(mItems);
    }
}
