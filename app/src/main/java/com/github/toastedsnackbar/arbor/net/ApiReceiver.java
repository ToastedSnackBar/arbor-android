package com.github.toastedsnackbar.arbor.net;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ResultReceiver;

@SuppressLint("ParcelCreator")
public class ApiReceiver extends ResultReceiver {

    private ReceiveResultListener mListener;

    public ApiReceiver(Handler handler) {
        super(handler);
    }

    public void setResultListener(ReceiveResultListener listener) {
        mListener = listener;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (mListener != null) {
            mListener.onReceiveResult(resultCode, resultData);
        }
    }

    public interface ReceiveResultListener {
        void onReceiveResult(int resultCode, Bundle resultData);
    }
}
