package com.github.toastedsnackbar.arbor.net.responses.events;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.responses.PageResponse;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryResponse;
import com.github.toastedsnackbar.arbor.net.responses.UserResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GollumEventPayloadResponse extends EventPayloadResponse {

    @SerializedName("pages")
    private List<PageResponse> mPages;

    @SerializedName("repository")
    private RepositoryResponse mRepository;

    @SerializedName("sender")
    private UserResponse mSender;

    public GollumEventPayloadResponse(Parcel source) {
        super(source);

        mPages = new ArrayList<>();
        source.readTypedList(mPages, PageResponse.CREATOR);
        mRepository = source.readParcelable(getClass().getClassLoader());
        mSender = source.readParcelable(getClass().getClassLoader());
    }

    public List<PageResponse> getPages() {
        return mPages;
    }

    public RepositoryResponse getRepository() {
        return mRepository;
    }

    public UserResponse getSender() {
        return mSender;
    }

    public static final Creator<GollumEventPayloadResponse> CREATOR =
            new Creator<GollumEventPayloadResponse>() {

        @Override
        public GollumEventPayloadResponse createFromParcel(Parcel source) {
            return new GollumEventPayloadResponse(source);
        }

        @Override
        public GollumEventPayloadResponse[] newArray(int size) {
            return new GollumEventPayloadResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeTypedList(mPages);
        dest.writeParcelable(mRepository, 0);
        dest.writeParcelable(mSender, 0);
    }
}
