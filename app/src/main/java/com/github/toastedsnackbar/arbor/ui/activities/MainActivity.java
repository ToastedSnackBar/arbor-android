package com.github.toastedsnackbar.arbor.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String oauthUrl = ApiEndpoints.getOAuthUrl();
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.clearCache(true);
        webView.loadUrl(oauthUrl);
    }
}