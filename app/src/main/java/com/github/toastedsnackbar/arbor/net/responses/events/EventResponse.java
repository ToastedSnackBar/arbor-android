package com.github.toastedsnackbar.arbor.net.responses.events;

import android.os.Parcel;

import com.github.toastedsnackbar.arbor.net.responses.ActorResponse;
import com.github.toastedsnackbar.arbor.net.responses.ApiResponse;
import com.github.toastedsnackbar.arbor.net.responses.OrganizationResponse;
import com.github.toastedsnackbar.arbor.net.responses.RepoResponse;
import com.google.gson.annotations.SerializedName;

public class EventResponse extends ApiResponse {

    @SerializedName("id")
    private String mId;

    @SerializedName("type")
    private EventType mType;

    @SerializedName("public")
    private boolean mIsPublic;

    @SerializedName("payload")
    private EventPayloadResponse mPayload;

    @SerializedName("repo")
    private RepoResponse mRepo;

    @SerializedName("actor")
    private ActorResponse mActor;

    @SerializedName("org")
    private OrganizationResponse mOrganization;

    @SerializedName("created_at")
    private String mCreatedAt;

    public EventResponse(Parcel source) {
        super(source);

        mId = source.readString();
        mType = (EventType) source.readSerializable();
        mIsPublic = source.readByte() != 0;
        mPayload = (EventPayloadResponse) source.readSerializable();
        mRepo = (RepoResponse) source.readSerializable();
        mActor = (ActorResponse) source.readSerializable();
        mOrganization = (OrganizationResponse) source.readSerializable();
        mCreatedAt = source.readString();
    }

    public String getId() {
        return mId;
    }

    public EventType getType() {
        return mType;
    }

    public boolean isIsPublic() {
        return mIsPublic;
    }

    public EventPayloadResponse getPayload() {
        return mPayload;
    }

    public RepoResponse getRepo() {
        return mRepo;
    }

    public ActorResponse getActor() {
        return mActor;
    }

    public OrganizationResponse getOrganization() {
        return mOrganization;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public static final Creator<EventResponse> CREATOR = new Creator<EventResponse>() {
        @Override
        public EventResponse createFromParcel(Parcel source) {
            return new EventResponse(source);
        }

        @Override
        public EventResponse[] newArray(int size) {
            return new EventResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(mId);
        dest.writeSerializable(mType);
        dest.writeByte((byte) (mIsPublic ? 1 : 0));
        dest.writeParcelable(mPayload, 0);
        dest.writeParcelable(mRepo, 0);
        dest.writeParcelable(mActor, 0);
        dest.writeParcelable(mOrganization, 0);
        dest.writeString(mCreatedAt);    }
}
