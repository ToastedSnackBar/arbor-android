package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class BranchResponse extends ApiResponse {
    
    @SerializedName("label")
    private String mLabel;
    
    @SerializedName("ref")
    private String mRef;
    
    @SerializedName("sha")
    private String mSha;
    
    @SerializedName("user")
    private UserResponse mUser;
    
    @SerializedName("repo")
    private RepoResponse mRepo;
    
    public BranchResponse(Parcel source) {
        super(source);

        mLabel = source.readString();
        mRef = source.readString();
        mSha = source.readString();
        mUser = source.readParcelable(getClass().getClassLoader());
        mRepo = source.readParcelable(getClass().getClassLoader());
    }

    public String getLabel() {
        return mLabel;
    }

    public String getRef() {
        return mRef;
    }

    public String getSha() {
        return mSha;
    }

    public UserResponse getUser() {
        return mUser;
    }

    public RepoResponse getRepo() {
        return mRepo;
    }

    public static final Creator<BranchResponse> CREATOR = new Creator<BranchResponse>() {

        @Override
        public BranchResponse createFromParcel(Parcel source) {
            return new BranchResponse(source);
        }

        @Override
        public BranchResponse[] newArray(int size) {
            return new BranchResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(mLabel);
        dest.writeString(mRef);
        dest.writeString(mSha);
        dest.writeParcelable(mUser, 0);
        dest.writeParcelable(mRepo, 0);
    }
}
