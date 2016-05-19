package com.github.toastedsnackbar.arbor.net;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

import com.github.toastedsnackbar.arbor.net.requests.ApiRequest;
import com.github.toastedsnackbar.arbor.net.responses.ApiResponse;

import java.io.IOException;

public class ApiService extends IntentService {

    public static final class ResultCodes {
        public static final int RUNNING = 0;
        public static final int SUCCESS = 1;
        public static final int ERROR = 2;
    }

    public static final String EXTRA_RESULT_RECEIVER = "extra_result_receiver";
    public static final String EXTRA_REQUEST = "extra_request";
    public static final String EXTRA_REQUEST_ID = "extra_request_id";
    public static final String EXTRA_RESPONSE = "extra_response";
    public static final String EXTRA_ERROR = "extra_error";

    public ApiService() {
        super("com.github.toastedsnackbar.arbor.net.ApiService");
    }

    public ApiService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ApiRequest request = intent.getParcelableExtra(EXTRA_REQUEST);
        Bundle resultData = new Bundle();
        resultData.putString(EXTRA_REQUEST_ID, request.getRequestId());

        ResultReceiver receiver = intent.getParcelableExtra(EXTRA_RESULT_RECEIVER);
        receiver.send(ResultCodes.RUNNING, resultData);

        ApiResponse response = null;
        try {
            response = request.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            resultData.putParcelable(EXTRA_RESPONSE, response);
            receiver.send(ResultCodes.SUCCESS, resultData);
        }
    }

    public static void executeRequest(Context context, ApiRequest request, ApiReceiver receiver) {
        Intent requestIntent = new Intent(Intent.ACTION_SYNC, null, context, ApiService.class);
        requestIntent.putExtra(ApiService.EXTRA_REQUEST, request);
        requestIntent.putExtra(ApiService.EXTRA_RESULT_RECEIVER, receiver);
        context.startService(requestIntent);
    }
}
