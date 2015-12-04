package com.github.toastedsnackbar.arbor.net.requests;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryListResponse;
import com.google.gson.TypeAdapterFactory;

import java.util.Map;
import java.util.Set;

public class RepositoryListRequest extends ApiRequest<RepositoryListResponse> {

    private String mUrl;

    public RepositoryListRequest() {
        mUrl = ApiEndpoints.getAuthUserReposUrl();
    }

    public RepositoryListRequest(Parcel source) {
        mUrl = source.readString();
    }

    public static final Creator<RepositoryListRequest> CREATOR =
            new Creator<RepositoryListRequest>() {
        @Override
        public RepositoryListRequest createFromParcel(Parcel source) {
            return new RepositoryListRequest(source);
        }

        @Override
        public RepositoryListRequest[] newArray(int size) {
            return new RepositoryListRequest[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUrl);
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
        return ApiRequest.METHOD_GET;
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
    protected Class<RepositoryListResponse> getResponseClass() {
        return RepositoryListResponse.class;
    }

    @Override
    protected TypeAdapterFactory getTypeAdapterFactory() {
        return null;
    }
}
