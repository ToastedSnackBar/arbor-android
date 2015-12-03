package com.github.toastedsnackbar.arbor.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.ApiReceiver;
import com.github.toastedsnackbar.arbor.net.ApiService;
import com.github.toastedsnackbar.arbor.net.requests.AccessTokenRequest;
import com.github.toastedsnackbar.arbor.net.responses.AccessTokenResponse;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        ApiReceiver.ReceiveResultListener {

    private enum WebViewMode {
        LOGIN, REGISTER
    }

    private WebView mLoginWebView;
    private ProgressBar mProgressBar;

    private Button mLoginButton;
    private Button mRegisterButton;

    private ApiReceiver mApiReceiver;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mApiReceiver = new ApiReceiver(new Handler());

        mLoginWebView = (WebView) findViewById(R.id.web_view);
        mLoginWebView.setWebViewClient(new LoginWebViewClient());
        mLoginWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        mProgressBar = (ProgressBar) findViewById(R.id.pb_web_view);

        mLoginButton = (Button) findViewById(R.id.btn_login);
        mLoginButton.setOnClickListener(MainActivity.this);

        mRegisterButton = (Button) findViewById(R.id.btn_register);
        mRegisterButton.setOnClickListener(MainActivity.this);

        String accessToken = ArborPreferences.getAccessToken();
        if (!TextUtils.isEmpty(accessToken)) {
            HomeScreenActivity.start(MainActivity.this);
            finish();
        }
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
                mProgressBar.setVisibility(View.VISIBLE);
                break;

            case ApiService.ResultCodes.SUCCESS:
                AccessTokenResponse response = resultData.getParcelable(ApiService.EXTRA_RESPONSE);
                if (response == null) {
                    return;
                }

                String accessToken = response.getAccessToken();
                ArborPreferences.setAccessToken(accessToken);

                mProgressBar.setVisibility(View.GONE);
                HomeScreenActivity.start(MainActivity.this);
                finish();
                break;
        }
    }

    @SuppressWarnings("deprecation")
    private void setupLoginWebView(WebViewMode mode) {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();

        String url;
        if (mode == WebViewMode.LOGIN) {
            url = ApiEndpoints.getOAuthUrl();
        } else {
            url = ApiEndpoints.getRegisterUrl();
        }

        mLoginWebView.loadUrl(url);
        mLoginWebView.setVisibility(View.VISIBLE);

        setButtonsVisibility(View.GONE);
    }

    private void teardownLoginWebView() {
        mLoginWebView.clearHistory();
        mLoginWebView.clearCache(true);
        mLoginWebView.loadUrl("about:blank");
        mLoginWebView.setVisibility(View.GONE);

        setButtonsVisibility(View.VISIBLE);
    }

    private void setButtonsVisibility(int visibility) {
        mLoginButton.setVisibility(visibility);
        mRegisterButton.setVisibility(visibility);

        boolean enabled = visibility == View.VISIBLE;
        mLoginButton.setEnabled(enabled);
        mRegisterButton.setEnabled(enabled);
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
                    setupLoginWebView(WebViewMode.LOGIN);
                }
                break;

            case R.id.btn_register:
                if (mLoginWebView.getVisibility() != View.VISIBLE) {
                    setupLoginWebView(WebViewMode.REGISTER);
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
                setButtonsVisibility(View.VISIBLE);
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
