package com.github.toastedsnackbar.arbor.ui.activities;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.ApiReceiver;
import com.github.toastedsnackbar.arbor.net.ApiService;
import com.github.toastedsnackbar.arbor.net.requests.AccessTokenRequest;
import com.github.toastedsnackbar.arbor.net.responses.AccessTokenResponse;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        ApiReceiver.ReceiveResultListener {

    private WebView mLoginWebView;

    private Button mLoginButton;
    private ProgressBar mProgressBar;

    private ApiReceiver mApiReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mApiReceiver = new ApiReceiver(new Handler());

        mLoginButton = (Button) findViewById(R.id.btn_login);
        mLoginWebView = (WebView) findViewById(R.id.web_view_login);
        mProgressBar = (ProgressBar) findViewById(R.id.pb_web_view);

        mLoginWebView.setWebViewClient(new LoginWebViewClient());
        mLoginWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mLoginButton.setOnClickListener(MainActivity.this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mApiReceiver.setResultListener(MainActivity.this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mApiReceiver.setResultListener(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLoginWebView != null) {
            teardownLoginWebView();
            mLoginWebView.removeAllViews();
            mLoginWebView.destroy();
        }
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        switch (resultCode) {
            case ApiService.ResultCodes.RUNNING:
                break;

            case ApiService.ResultCodes.SUCCESS:
                AccessTokenResponse response = resultData.getParcelable(ApiService.EXTRA_RESPONSE);
                if (response == null) return;

                String accessToken = response.getAccessToken();
                ArborPreferences.getInstance().setAccessToken(accessToken);
                break;
        }
    }

    private void setupLoginWebView() {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();

        mLoginWebView.loadUrl(ApiEndpoints.getOAuthUrl());
        mLoginWebView.setVisibility(View.VISIBLE);

        mLoginButton.setVisibility(View.GONE);
    }

    private void teardownLoginWebView() {
        mLoginWebView.clearHistory();
        mLoginWebView.clearCache(true);
        mLoginWebView.loadUrl("about:blank");
        mLoginWebView.setVisibility(View.GONE);

        mLoginButton.setVisibility(View.VISIBLE);
    }

    private void executeAccessTokenRequest(String url) {
        Uri uri = Uri.parse(url);
        String code = uri.getQueryParameter(ApiEndpoints.Params.CODE);
        String clientId = ApiEndpoints.getClientId();
        String clientSecret = ApiEndpoints.getClientSecret();
        String state = ApiEndpoints.getClientState();

        AccessTokenRequest request = new AccessTokenRequest(code, clientId, clientSecret, state);
        ApiService.executeRequest(MainActivity.this, request, mApiReceiver);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn_login:
                if (mLoginWebView.getVisibility() != View.VISIBLE) {
                    setupLoginWebView();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mLoginWebView.getVisibility() == View.VISIBLE) {
            teardownLoginWebView();
        } else {
            super.onBackPressed();
        }
    }

    private class LoginWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            if (url.startsWith(ApiEndpoints.getRedirectUrl())) {
                mLoginWebView.setVisibility(View.GONE);
                executeAccessTokenRequest(url);
            } else {
                mLoginWebView.loadUrl(url);
            }

            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView webView, String url) {
            super.onPageFinished(webView, url);
            mProgressBar.setVisibility(View.GONE);
        }
    }
}