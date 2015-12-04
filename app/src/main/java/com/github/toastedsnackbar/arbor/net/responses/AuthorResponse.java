package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class AuthorResponse extends ApiResponse {

    @SerializedName("email")
    public String mEmail;

    @SerializedName("name")
    public String mName;

    public AuthorResponse(Parcel source) {
        super(source);

        mEmail = source.readString();
        mName = source.readString();
    }

    public String getEmail() {
        return mEmail;
    }

    public String getName() {
        return mName;
    }

    public static Creator<AuthorResponse> CREATOR = new Creator<AuthorResponse>() {
        @Override
        public AuthorResponse createFromParcel(Parcel source) {
            return new AuthorResponse(source);
        }

        @Override
        public AuthorResponse[] newArray(int size) {
            return new AuthorResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(mEmail);
        dest.writeString(mName);
    }
}
