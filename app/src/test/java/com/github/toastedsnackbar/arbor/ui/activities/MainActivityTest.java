package com.github.toastedsnackbar.arbor.ui.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.ApiReceiver;
import com.github.toastedsnackbar.arbor.net.ApiService;
import com.github.toastedsnackbar.arbor.net.requests.AccessTokenRequest;
import com.github.toastedsnackbar.arbor.net.responses.AccessTokenResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.internal.ShadowExtractor;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowWebView;
import org.robolectric.util.ActivityController;

import static org.assertj.android.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class MainActivityTest {

    private static final String TEST_OAUTH_URL = ApiEndpoints.getOAuthUrl();
    private static final String TEST_REGISTER_URL = ApiEndpoints.getRegisterUrl();
    private static final String TEST_REDIRECT_URL = "https://www.google.com/?code=code&state=state";

    private MainActivity mActivity;
    private ActivityController<MainActivity> mActivityController;

    @Before
    public void setup() {
        mActivityController = Robolectric.buildActivity(MainActivity.class);
        mActivity = mActivityController.create().start().resume().visible().get();
    }

    @After
    public void teardown() {
        ArborPreferences.clear();
        mActivityController.pause().stop().destroy();
        mActivityController = null;
        mActivity = null;
    }

    @Test
    public void onCreate_accessTokenPrefNotEmpty_shouldLaunchHomeScreenActivityAndFinish() {
        teardown();
        ArborPreferences.setAccessToken("access_token");
        setup();

        ShadowActivity shadowMainActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        Intent startedIntent = shadowMainActivity.getNextStartedActivity();
        assertThat(startedIntent).isNotNull();
        assertThat(startedIntent).hasComponent(new ComponentName(mActivity,
                HomeScreenActivity.class));

        assertThat(mActivity).isFinishing();
    }

    @Test
    public void onCreate_accessTokenPrefEmpty_shouldNotLaunchHomeScreenActivityAndFinish() {
        ShadowActivity shadowMainActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        Intent startedIntent = shadowMainActivity.getNextStartedActivity();
        assertThat(startedIntent).isNull();

        assertThat(mActivity).isNotFinishing();
    }

    @Test
    public void onCreate_loginBtnShouldBeVisibleClickable() {
        Button loginBtn = (Button) mActivity.findViewById(R.id.btn_login);

        assertThat(loginBtn).isNotNull();
        assertThat(loginBtn).isVisible();
        assertThat(loginBtn).isClickable();
        assertThat(loginBtn).hasText(R.string.splash_login);
    }

    @Test
    public void onCreate_loginWebViewShouldBeGone() {
        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);

        assertThat(loginWebView).isNotNull();
        assertThat(loginWebView).isGone();
    }

    @Test
    public void loginBtnClick_loginBtnShouldBeGone() {
        Button loginButton = (Button) mActivity.findViewById(R.id.btn_login);
        loginButton.performClick();

        assertThat(loginButton).isGone();
    }

    @Test
    public void loginBtnClick_loginWebViewShouldBeVisible() {
        clickOnButton(R.id.btn_login);

        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        assertThat(loginWebView).isVisible();
    }

    @Test
    public void loginBtnClick_loginWebViewShouldLoadOAuthUrl() {
        clickOnButton(R.id.btn_login);

        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowLoginWebView = (ShadowWebView) ShadowExtractor.extract(loginWebView);

        String actualUrl = shadowLoginWebView.getLastLoadedUrl();
        assertThat(actualUrl).isEqualTo(TEST_OAUTH_URL);
    }

    @Test
    public void registerBtnClick_registerBtnShouldBeGone() {
        Button registerButton = (Button) mActivity.findViewById(R.id.btn_register);
        registerButton.performClick();

        assertThat(registerButton).isGone();
    }

    @Test
    public void registerBtnClick_registerWebViewShouldBeVisible() {
        clickOnButton(R.id.btn_register);

        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        assertThat(loginWebView).isVisible();
    }

    @Test
    public void registerBtnClick_registerWebViewShouldLoadOAuthUrl() {
        clickOnButton(R.id.btn_register);

        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowLoginWebView = (ShadowWebView) ShadowExtractor.extract(loginWebView);

        String actualUrl = shadowLoginWebView.getLastLoadedUrl();
        assertThat(actualUrl).isEqualTo(TEST_REGISTER_URL);
    }

    @Test
    public void loginWebView_shouldLoadUrl() {
        clickOnButton(R.id.btn_login);

        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowLoginWebView = (ShadowWebView) ShadowExtractor.extract(loginWebView);

        WebViewClient webViewClient = shadowLoginWebView.getWebViewClient();
        webViewClient.shouldOverrideUrlLoading(loginWebView, TEST_OAUTH_URL);

        String actualUrl = shadowLoginWebView.getLastLoadedUrl();
        assertThat(actualUrl).isEqualTo(TEST_OAUTH_URL);
    }

    @Test
    public void loginWebView_progressBarShouldBeVisibleOnPageLoadStart() {
        clickOnButton(R.id.btn_login);

        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowLoginWebView = (ShadowWebView) ShadowExtractor.extract(loginWebView);

        WebViewClient webViewClient = shadowLoginWebView.getWebViewClient();
        webViewClient.onPageStarted(loginWebView, TEST_OAUTH_URL, null);

        ProgressBar progressBar = (ProgressBar) mActivity.findViewById(R.id.pb_web_view);
        assertThat(progressBar).isNotNull();
        assertThat(progressBar).isVisible();
    }

    @Test
    public void loginWebView_progressBarShouldBeGoneOnPageLoadFinish() {
        clickOnButton(R.id.btn_login);

        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowLoginWebView = (ShadowWebView) ShadowExtractor.extract(loginWebView);

        WebViewClient webViewClient = shadowLoginWebView.getWebViewClient();
        webViewClient.onPageFinished(loginWebView, TEST_OAUTH_URL);

        ProgressBar progressBar = (ProgressBar) mActivity.findViewById(R.id.pb_web_view);
        assertThat(progressBar).isNotNull();
        assertThat(progressBar).isGone();
    }

    @Test
    public void oauth_onRedirect_loginWebViewShouldBeGone() {
        clickOnButton(R.id.btn_login);

        final WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowLoginWebView = (ShadowWebView) ShadowExtractor.extract(loginWebView);

        WebViewClient webViewClient = shadowLoginWebView.getWebViewClient();
        webViewClient.shouldOverrideUrlLoading(loginWebView, TEST_REDIRECT_URL);

        assertThat(loginWebView).isGone();
    }

    @Test
    public void oauth_onRedirect_loginButtonShouldBeGone() {
        Button loginBtn = (Button) mActivity.findViewById(R.id.btn_login);
        loginBtn.performClick();

        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        loginWebView.loadUrl(TEST_REDIRECT_URL);

        assertThat(loginBtn).isGone();
    }

    @Test
    public void oauth_onRedirect_shouldExecuteApiRequest() {
        clickOnButton(R.id.btn_login);

        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowLoginWebView = (ShadowWebView) ShadowExtractor.extract(loginWebView);

        WebViewClient webViewClient = shadowLoginWebView.getWebViewClient();
        webViewClient.shouldOverrideUrlLoading(loginWebView, TEST_REDIRECT_URL);

        ShadowActivity shadowMainActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        Intent startedIntent = shadowMainActivity.getNextStartedService();
        assertThat(startedIntent).isNotNull();
        assertThat(startedIntent).hasComponent(new ComponentName(mActivity, ApiService.class));

        assertThat(startedIntent).hasExtra(ApiService.EXTRA_REQUEST);
        assertThat(startedIntent.getParcelableExtra(ApiService.EXTRA_REQUEST)).isInstanceOf(
                AccessTokenRequest.class);

        assertThat(startedIntent).hasExtra(ApiService.EXTRA_RESULT_RECEIVER);
        assertThat(startedIntent.getParcelableExtra(ApiService.EXTRA_RESULT_RECEIVER)).isInstanceOf(
                ApiReceiver.class);
    }

    @Test
    public void oauth_onReceiveRunning_progressBarShouldBeVisible() {
        mActivity.onReceiveResult(ApiService.ResultCodes.RUNNING, Bundle.EMPTY);

        ProgressBar progressBar = (ProgressBar) mActivity.findViewById(R.id.pb_web_view);
        assertThat(progressBar).isNotNull();
        assertThat(progressBar).isVisible();
    }

    @Test
    public void oauth_onReceiveSuccess_progressBarShouldBeGone() {
        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowLoginWebView = (ShadowWebView) ShadowExtractor.extract(loginWebView);

        WebViewClient webViewClient = shadowLoginWebView.getWebViewClient();
        webViewClient.shouldOverrideUrlLoading(loginWebView, TEST_REDIRECT_URL);

        AccessTokenResponse response = buildAccessTokenResponse();
        assertThat(response).isNotNull();

        Bundle resultData = new Bundle();
        resultData.putString(ApiService.EXTRA_REQUEST_ID, ApiEndpoints.getAccessTokenUrl());
        resultData.putParcelable(ApiService.EXTRA_RESPONSE, response);
        mActivity.onReceiveResult(ApiService.ResultCodes.SUCCESS, resultData);

        ProgressBar progressBar = (ProgressBar) mActivity.findViewById(R.id.pb_web_view);
        assertThat(progressBar).isNotNull();
        assertThat(progressBar).isGone();
    }

    @Test
    public void oauth_onReceiveSuccess_shouldStoreAccessTokenInSharedPrefs() {
        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowLoginWebView = (ShadowWebView) ShadowExtractor.extract(loginWebView);

        WebViewClient webViewClient = shadowLoginWebView.getWebViewClient();
        webViewClient.shouldOverrideUrlLoading(loginWebView, TEST_REDIRECT_URL);

        AccessTokenResponse response = buildAccessTokenResponse();
        assertThat(response).isNotNull();

        Bundle resultData = new Bundle();
        resultData.putString(ApiService.EXTRA_REQUEST_ID, ApiEndpoints.getAccessTokenUrl());
        resultData.putParcelable(ApiService.EXTRA_RESPONSE, response);
        mActivity.onReceiveResult(ApiService.ResultCodes.SUCCESS, resultData);

        assertThat(ArborPreferences.getAccessToken()).isEqualTo("access_token");
    }

    @Test
    public void onBackPressed_shouldFinishIfLoginWebViewNotVisible() {
        mActivity.onBackPressed();
        assertThat(mActivity).isFinishing();
    }

    @Test
    public void onBackPressed_loginWebViewShouldCloseIfVisible() {
        clickOnButton(R.id.btn_login);

        mActivity.onBackPressed();

        WebView loginWebView = (WebView) mActivity.findViewById(R.id.web_view);
        assertThat(loginWebView).isNotNull();
        assertThat(loginWebView).isGone();
    }
    
    private void clickOnButton(int buttonId) {
        Button button = (Button) mActivity.findViewById(buttonId);
        button.performClick();
    }

    private static AccessTokenResponse buildAccessTokenResponse() {
        AccessTokenResponse response;
        Parcel in = Parcel.obtain();
        Parcel out = Parcel.obtain();

        try {
            in.writeInt(200);
            in.writeLong(1000L);
            in.writeString("access_token");
            in.writeString("code");
            in.writeString("token_type");
            byte[] data = in.marshall();

            out.unmarshall(data, 0, data.length);
            out.setDataPosition(0);
            response = new AccessTokenResponse(out);
        } finally {
            in.recycle();
            out.recycle();
        }

        return response;
    }
}
