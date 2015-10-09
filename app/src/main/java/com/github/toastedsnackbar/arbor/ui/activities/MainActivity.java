package com.github.toastedsnackbar.arbor.ui.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView mLoginWebView;
    private Button mLoginButton;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginButton = (Button) findViewById(R.id.btn_login);
        mLoginWebView = (WebView) findViewById(R.id.web_view);
        mProgressBar = (ProgressBar) findViewById(R.id.pb_web_view);

        mLoginButton.setOnClickListener(MainActivity.this);
    }

    private void setupLoginWebView() {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();

        mLoginWebView.setWebViewClient(new LoginWebViewClient());
        mLoginWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLoginWebView != null) {
            teardownLoginWebView();
            mLoginWebView.destroy();
        }
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