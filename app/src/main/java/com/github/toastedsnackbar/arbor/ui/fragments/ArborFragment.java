package com.github.toastedsnackbar.arbor.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.github.toastedsnackbar.arbor.net.ApiReceiver;
import com.github.toastedsnackbar.arbor.net.ApiReceiver.ReceiveResultListener;
import com.github.toastedsnackbar.arbor.net.ApiService;
import com.github.toastedsnackbar.arbor.net.ApiService.ResultCodes;
import com.github.toastedsnackbar.arbor.net.requests.ApiRequest;
import com.github.toastedsnackbar.arbor.net.responses.ApiResponse;

public abstract class ArborFragment extends Fragment implements ReceiveResultListener {

    private static final String LOG_TAG = "ArborFragment";

    private ApiReceiver mApiReceiver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApiReceiver = new ApiReceiver(new Handler());
        mApiReceiver.setResultListener(ArborFragment.this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mApiReceiver.setResultListener(ArborFragment.this);
    }

    @Override
    public void onStop() {
        super.onStop();
        mApiReceiver.setResultListener(null);
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        String requestId = resultData.getString(ApiService.EXTRA_REQUEST_ID);

        switch (resultCode) {
            case ResultCodes.RUNNING:
                onRequestStart(requestId);
                break;

            case ResultCodes.SUCCESS:
                ApiResponse response = resultData.getParcelable(ApiService.EXTRA_RESPONSE);
                onRequestSuccess(requestId, response);
                Log.d(LOG_TAG, "requestId: " + requestId + " SUCCESS!");
                break;

            case ResultCodes.ERROR:
                onRequestError(requestId);
                Log.e(LOG_TAG, "requestId: " + requestId + " ERROR!");
                break;
        }
    }

    protected void executeRequest(ApiRequest request) {
        ApiService.executeRequest(getActivity(), request, mApiReceiver);
    }

    protected abstract void onRequestStart(String requestId);

    protected abstract void onRequestSuccess(String requestId, ApiResponse baseResponse);

    protected abstract void onRequestError(String requestId);

    public abstract String getFragmentTag();
}
