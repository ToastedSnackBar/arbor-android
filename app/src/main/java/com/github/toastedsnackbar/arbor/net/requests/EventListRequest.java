package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.responses.events.EventListResponse;

import java.util.Map;
import java.util.Set;

public class EventListRequest extends ApiRequest<EventListResponse> {

    String mUrl;
    String mRequestId;

    public EventListRequest() {
        mUrl = ApiEndpoints.getUserReceivedEvents(ArborPreferences.getUsername());
        mRequestId = mUrl;
    }

    public EventListRequest(Parcel source) {
        mUrl = source.readString();
        mRequestId = source.readString();
    }

    public static final Creator<EventListRequest> CREATOR = new Creator<EventListRequest>() {
        @Override
        public EventListRequest createFromParcel(Parcel source) {
            return new EventListRequest(source);
        }

        @Override
        public EventListRequest[] newArray(int size) {
            return new EventListRequest[0];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUrl);
        dest.writeString(mRequestId);
    }

    @Override
    public String getRequestId() {
        return mRequestId;
    }

    @Override
    protected String getUrl() {
        return mUrl;
    }

    @Override
    protected Map<String, String> getProperties() {
        return null;
    }

    @Override
    protected boolean isAuthorizedRequest() {
        return true;
    }

    @Override
    protected String getRequestMethod() {
        return METHOD_GET;
    }

    @Override
    protected String getRequestEntity() {
        return null;
    }

    @Override
    protected Set<Integer> getAcceptedStatuses() {
        return null;
    }

    @Override
    protected Class<EventListResponse> getResponseClass() {
        return EventListResponse.class;
    }
}
