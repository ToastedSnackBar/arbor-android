package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class PlanResponse extends ApiResponse {

    @SerializedName("name")
    private String mName;

    @SerializedName("space")
    private int mSpace;

    @SerializedName("private_repos")
    private int mPrivateRepoCount;

    @SerializedName("collaborators")
    private int mCollaboratorCount;

    public PlanResponse(Parcel source) {
        super(source);

        mName = source.readString();
        mSpace = source.readInt();
        mPrivateRepoCount = source.readInt();
        mCollaboratorCount = source.readInt();
    }

    public String getName() {
        return mName;
    }

    public int getSpace() {
        return mSpace;
    }

    public int getPrivateRepoCount() {
        return mPrivateRepoCount;
    }

    public int getCollaboratorCount() {
        return mCollaboratorCount;
    }

    public static final Creator<PlanResponse> CREATOR = new Creator<PlanResponse>() {

        @Override
        public PlanResponse createFromParcel(Parcel source) {
            return new PlanResponse(source);
        }

        @Override
        public PlanResponse[] newArray(int size) {
            return new PlanResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(mName);
        dest.writeInt(mSpace);
        dest.writeInt(mPrivateRepoCount);
        dest.writeInt(mCollaboratorCount);
    }
}
