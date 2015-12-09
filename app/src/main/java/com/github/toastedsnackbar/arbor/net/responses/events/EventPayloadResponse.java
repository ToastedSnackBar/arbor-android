package com.github.toastedsnackbar.arbor.net.responses.events;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.responses.ApiResponse;

public abstract class EventPayloadResponse extends ApiResponse {

    public EventPayloadResponse(Parcel parcel) {
        super(parcel);
    }
}
