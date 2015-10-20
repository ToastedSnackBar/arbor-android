package com.github.toastedsnackbar.arbor.net;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

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
        public void onReceiveResult(int resultCode, Bundle resultData);
    }
}
