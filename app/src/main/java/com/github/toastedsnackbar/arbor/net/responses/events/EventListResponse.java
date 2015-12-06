package com.github.toastedsnackbar.arbor.net.responses.events;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.responses.ApiResponse;

import java.util.ArrayList;
import java.util.List;

public class EventListResponse extends ApiResponse {

    private List<EventResponse> mItems;

    public EventListResponse(List<EventResponse> items) {
        mItems = items;
    }

    public EventListResponse(Parcel source) {
        super(source);

        mItems = new ArrayList<>();
        source.readTypedList(mItems, EventResponse.CREATOR);
    }

    public List<EventResponse> getItems() {
        return mItems;
    }

    public static final Creator<EventListResponse> CREATOR = new Creator<EventListResponse>() {

        @Override
        public EventListResponse createFromParcel(Parcel source) {
            return new EventListResponse(source);
        }

        @Override
        public EventListResponse[] newArray(int size) {
            return new EventListResponse[size];
        }
    };
}
