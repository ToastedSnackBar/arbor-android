package com.github.toastedsnackbar.arbor.net.responses.events;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.responses.PullRequestResponse;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryResponse;
import com.github.toastedsnackbar.arbor.net.responses.UserResponse;
import com.google.gson.annotations.SerializedName;

public class PullRequestEventPayloadResponse extends EventPayloadResponse {
    
    @SerializedName("action")
    private String mAction;
    
    @SerializedName("number")
    private int mNumber;

    @SerializedName("pull_request")
    private PullRequestResponse mPullRequest;

    @SerializedName("repository")
    private RepositoryResponse mRepository;

    @SerializedName("sender")
    private UserResponse mSender;

    public PullRequestEventPayloadResponse(Parcel source) {
        super(source);

        mAction = source.readString();
        mNumber = source.readInt();
        mPullRequest = source.readParcelable(getClass().getClassLoader());
        mRepository = source.readParcelable(getClass().getClassLoader());
        mSender = source.readParcelable(getClass().getClassLoader());
    }

    public String getAction() {
        return mAction;
    }

    public int getNumber() {
        return mNumber;
    }

    public PullRequestResponse getPullRequest() {
        return mPullRequest;
    }

    public RepositoryResponse getRepository() {
        return mRepository;
    }

    public UserResponse getSender() {
        return mSender;
    }

    public static final Creator<PullRequestEventPayloadResponse> CREATOR = 
            new Creator<PullRequestEventPayloadResponse>() {
                
        @Override
        public PullRequestEventPayloadResponse createFromParcel(Parcel source) {
            return new PullRequestEventPayloadResponse(source);
        }

        @Override
        public PullRequestEventPayloadResponse[] newArray(int size) {
            return new PullRequestEventPayloadResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(mAction);
        dest.writeInt(mNumber);
        dest.writeParcelable(mPullRequest, 0);
        dest.writeParcelable(mRepository, 0);
        dest.writeParcelable(mSender, 0);
    }
}
