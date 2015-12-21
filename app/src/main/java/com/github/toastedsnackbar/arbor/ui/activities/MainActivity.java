package com.github.toastedsnackbar.arbor.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.ApiReceiver;
import com.github.toastedsnackbar.arbor.net.ApiService;
import com.github.toastedsnackbar.arbor.net.ApiService.ResultCodes;
import com.github.toastedsnackbar.arbor.net.requests.AuthUserRequest;
import com.github.toastedsnackbar.arbor.net.responses.UserResponse;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        OnEditorActionListener, ApiReceiver.ReceiveResultListener {

    private static final int MIN_USERNAME_CHARS = 7;
    private static final int MIN_PASSWORD_CHARS = 7;

    private WebView mRegisterWebView;
    private ProgressBar mProgressBar;

    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private Button mRegisterButton;

    private CoordinatorLayout mSnackbarLayout;

    private ApiReceiver mApiReceiver;
    private String mAuthUserRequestId;

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
        ButterKnife.bind(this);

        String username = ArborPreferences.getUsername();
        if (!TextUtils.isEmpty(username)) {
            HomeScreenActivity.start(MainActivity.this);
            finish();
        }

        mRegisterWebView = (WebView) findViewById(R.id.web_view);
        mRegisterWebView.setWebViewClient(new RegisterWebViewClient());
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mUsernameEditText = (EditText) findViewById(R.id.edittext_username);
        mPasswordEditText = (EditText) findViewById(R.id.edittext_password);
        mPasswordEditText.setOnEditorActionListener(MainActivity.this);

        mLoginButton = (Button) findViewById(R.id.btn_login);
        mLoginButton.setOnClickListener(MainActivity.this);
        mRegisterButton = (Button) findViewById(R.id.btn_register);
        mRegisterButton.setOnClickListener(MainActivity.this);

        mSnackbarLayout = (CoordinatorLayout) findViewById(R.id.snackbar);

        mApiReceiver = new ApiReceiver(new Handler());
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

    private void executeAuthUserRequest() {
        String username = mUsernameEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        String basic = String.format("%s:%s", username, password);

        String tokenString = Base64.encodeToString(basic.getBytes(), Base64.CRLF);
        ArborPreferences.setAccessToken(tokenString);

        AuthUserRequest request = new AuthUserRequest();
        mAuthUserRequestId = request.getRequestId();
        ApiService.executeRequest(MainActivity.this, request, mApiReceiver);
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        switch (resultCode) {
            case ResultCodes.RUNNING:
                mProgressBar.setVisibility(View.VISIBLE);
                enableButtons(false);
                break;

            case ResultCodes.SUCCESS:
                String requestId = resultData.getString(ApiService.EXTRA_REQUEST_ID);
                if (TextUtils.isEmpty(requestId)) {
                    showErrorSnackbar(R.string.splash_error_unknown);
                    mProgressBar.setVisibility(View.GONE);
                    enableButtons(true);
                    return;
                }

                if (requestId.equals(mAuthUserRequestId)) {
                    UserResponse response = resultData.getParcelable(ApiService.EXTRA_RESPONSE);
                    if (response == null) {
                        showErrorSnackbar(R.string.splash_error_incorrect);
                        mProgressBar.setVisibility(View.GONE);
                        enableButtons(true);
                        return;
                    }

                    ArborPreferences.setUsername(response.getLogin());
                    ArborPreferences.setEmail(response.getEmail());
                    ArborPreferences.setAvatarUrl(response.getAvatarUrl());

                    HomeScreenActivity.start(MainActivity.this);
                    finish();
                }
                break;

            case ResultCodes.ERROR:
                showErrorSnackbar(R.string.splash_error_unknown);
                mProgressBar.setVisibility(View.GONE);
                enableButtons(true);
                break;
        }
    }

    @SuppressWarnings("deprecation")
    private void setupRegisterWebView() {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();

        mRegisterWebView.loadUrl(ApiEndpoints.getRegisterUrl());
        mRegisterWebView.setVisibility(View.VISIBLE);

        setButtonsVisibility(View.GONE);
    }

    private void teardownRegisterWebView() {
        mRegisterWebView.clearHistory();
        mRegisterWebView.clearCache(true);
        mRegisterWebView.loadUrl("about:blank");
        mRegisterWebView.setVisibility(View.GONE);

        setButtonsVisibility(View.VISIBLE);
    }

    private void setButtonsVisibility(int visibility) {
        mLoginButton.setVisibility(visibility);
        mRegisterButton.setVisibility(visibility);

        boolean enabled = visibility == View.VISIBLE;
        mLoginButton.setEnabled(enabled);
        mRegisterButton.setEnabled(enabled);
    }

    private void showErrorSnackbar(int stringResId) {
        Snackbar snackbar = Snackbar.make(mSnackbarLayout, stringResId, Snackbar.LENGTH_LONG);
        TextView textView = (TextView) snackbar.getView().findViewById(
                android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }

    private void enableButtons(boolean enable) {
        mLoginButton.setEnabled(enable);
        mRegisterButton.setEnabled(enable);

        mUsernameEditText.setEnabled(enable);
        mPasswordEditText.setEnabled(enable);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_login:
                login();
                break;

            case R.id.btn_register:
                if (mRegisterWebView.getVisibility() != View.VISIBLE) {
                    setupRegisterWebView();
                }
                break;
        }
    }

    private void login() {
        String username = mUsernameEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            showErrorSnackbar(R.string.splash_error_empty);
        } else if (username.length() < MIN_USERNAME_CHARS
                || password.length() < MIN_PASSWORD_CHARS) {
            showErrorSnackbar(R.string.splash_error_chars);
        } else {
            executeAuthUserRequest();
        }

        InputMethodManager manager = (InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(mUsernameEditText.getWindowToken(), 0);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            login();
            return true;
        }

        return false;
    }

    @Override
    public void onBackPressed() {
        if (mRegisterWebView.getVisibility() == View.VISIBLE) {
            teardownRegisterWebView();
        } else {
            super.onBackPressed();
        }
    }

    private class RegisterWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            return false;
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
