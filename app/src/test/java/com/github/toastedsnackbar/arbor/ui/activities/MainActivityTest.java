package com.github.toastedsnackbar.arbor.ui.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.ApiReceiver;
import com.github.toastedsnackbar.arbor.net.ApiService;
import com.github.toastedsnackbar.arbor.net.ApiService.ResultCodes;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;
import com.github.toastedsnackbar.arbor.net.requests.AuthUserRequest;
import com.github.toastedsnackbar.arbor.net.responses.UserResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.internal.ShadowExtractor;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowWebView;
import org.robolectric.util.ActivityController;

import java.io.IOException;

import static org.assertj.android.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class MainActivityTest {

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
    public void onCreate_usernamePrefNotEmpty_shouldLaunchHomeScreenActivityAndFinish() {
        teardown();
        ArborPreferences.setUsername("username");
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
    public void register_registerBtnClick_shouldHideButtons() {
        Button registerButton = (Button) mActivity.findViewById(R.id.btn_register);
        Button loginButton = (Button) mActivity.findViewById(R.id.btn_login);
        registerButton.performClick();

        assertThat(registerButton).isNotVisible();
        assertThat(loginButton).isNotVisible();
    }

    @Test
    public void register_registerBtnClick_shouldShowRegisterWebView() {
        Button registerButton = (Button) mActivity.findViewById(R.id.btn_register);
        registerButton.performClick();

        WebView registerWebView = (WebView) mActivity.findViewById(R.id.web_view);
        assertThat(registerWebView).isVisible();
    }

    @Test
    public void register_registerBtnClick_registerWebViewShouldLoadGitHubJoinUrl() {
        Button registerButton = (Button) mActivity.findViewById(R.id.btn_register);
        registerButton.performClick();

        WebView registerWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowRegisterWebView = (ShadowWebView) ShadowExtractor.extract(
                registerWebView);

        String actualUrl = shadowRegisterWebView.getLastLoadedUrl();
        assertThat(actualUrl).isEqualTo(ApiEndpoints.getRegisterUrl());
    }

    @Test
    public void register_onBackPressed_shouldNotFinishIfRegisterWebViewIsVisible() {
        WebView registerWebView = (WebView) mActivity.findViewById(R.id.web_view);
        Button registerButton = (Button) mActivity.findViewById(R.id.btn_register);
        registerButton.performClick();

        mActivity.onBackPressed();

        assertThat(mActivity).isNotFinishing();
        assertThat(registerWebView).isNotVisible();
    }

    @Test
    public void register_onBackPressed_shouldFinishIfRegisterWebViewIsNotVisible() {
        WebView registerWebView = (WebView) mActivity.findViewById(R.id.web_view);
        mActivity.onBackPressed();

        assertThat(registerWebView).isNotVisible();
        assertThat(mActivity).isFinishing();
    }

    @Test
    public void register_urlOverride_shouldNotHappen() {
        Button registerButton = (Button) mActivity.findViewById(R.id.btn_register);
        registerButton.performClick();

        WebView registerWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowRegisterWebView = (ShadowWebView) ShadowExtractor.extract(
                registerWebView);
        WebViewClient registerWebViewClient = shadowRegisterWebView.getWebViewClient();

        boolean override = registerWebViewClient.shouldOverrideUrlLoading(registerWebView,
                ApiEndpoints.getRegisterUrl());

        assertThat(override).isFalse();
    }

    @Test
    public void register_onPageLoadStart_shouldShowProgressBar() {
        Button registerButton = (Button) mActivity.findViewById(R.id.btn_register);
        registerButton.performClick();

        WebView registerWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowRegisterWebView = (ShadowWebView) ShadowExtractor.extract(
                registerWebView);
        WebViewClient registerWebViewClient = shadowRegisterWebView.getWebViewClient();

        registerWebViewClient.onPageStarted(registerWebView, ApiEndpoints.getRegisterUrl(), null);

        assertThat(mActivity.findViewById(R.id.progress_bar)).isVisible();
    }

    @Test
    public void register_onPageLoadFinished_shouldHideProgressBar() {
        Button registerButton = (Button) mActivity.findViewById(R.id.btn_register);
        registerButton.performClick();

        WebView registerWebView = (WebView) mActivity.findViewById(R.id.web_view);
        ShadowWebView shadowRegisterWebView = (ShadowWebView) ShadowExtractor.extract(
                registerWebView);
        WebViewClient registerWebViewClient = shadowRegisterWebView.getWebViewClient();

        registerWebViewClient.onPageFinished(registerWebView, ApiEndpoints.getRegisterUrl());

        assertThat(mActivity.findViewById(R.id.progress_bar)).isNotVisible();
    }

    @Test
    public void login_emptyUsername_shouldNotExecuteRequest() throws IOException {
        EditText usernameEditText = (EditText) mActivity.findViewById(R.id.edittext_username);
        EditText passwordEditText = (EditText) mActivity.findViewById(R.id.edittext_password);

        usernameEditText.setText("");
        passwordEditText.setText("password");

        Button loginButton = (Button) mActivity.findViewById(R.id.btn_login);
        loginButton.performClick();

        ShadowActivity shadowMainActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        Intent startedIntent = shadowMainActivity.getNextStartedActivity();

        assertThat(startedIntent).isNull();
    }

    @Test
    public void login_emptyPassword_shouldNotExecuteRequest() throws IOException {
        EditText usernameEditText = (EditText) mActivity.findViewById(R.id.edittext_username);
        EditText passwordEditText = (EditText) mActivity.findViewById(R.id.edittext_password);

        usernameEditText.setText("username");
        passwordEditText.setText("");

        Button loginButton = (Button) mActivity.findViewById(R.id.btn_login);
        loginButton.performClick();

        ShadowActivity shadowMainActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        Intent startedIntent = shadowMainActivity.getNextStartedActivity();

        assertThat(startedIntent).isNull();
    }

    @Test
    public void login_nonEmptyPasswordAndUsername_shouldExecuteRequest() {
        EditText usernameEditText = (EditText) mActivity.findViewById(R.id.edittext_username);
        EditText passwordEditText = (EditText) mActivity.findViewById(R.id.edittext_password);

        usernameEditText.setText("username");
        passwordEditText.setText("password");

        Button loginButton = (Button) mActivity.findViewById(R.id.btn_login);
        loginButton.performClick();

        ShadowActivity shadowMainActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        Intent startedIntent = shadowMainActivity.getNextStartedService();

        assertThat(startedIntent).isNotNull();
        assertThat(startedIntent).hasComponent(new ComponentName(mActivity, ApiService.class));
        assertThat(startedIntent).hasExtra(ApiService.EXTRA_REQUEST);
        assertThat(startedIntent).hasExtra(ApiService.EXTRA_RESULT_RECEIVER);

        Parcelable request = startedIntent.getParcelableExtra(ApiService.EXTRA_REQUEST);
        assertThat(request).isInstanceOf(AuthUserRequest.class);

        Parcelable receiver = startedIntent.getParcelableExtra(ApiService.EXTRA_RESULT_RECEIVER);
        assertThat(receiver).isInstanceOf(ApiReceiver.class);
        assertThat(((ApiReceiver) receiver).getResultListener()).isInstanceOf(MainActivity.class);
    }

    @Test
    public void login_imeActionDone_emptyUsername_shouldNotExecuteRequest() {
        EditText usernameEditText = (EditText) mActivity.findViewById(R.id.edittext_username);
        EditText passwordEditText = (EditText) mActivity.findViewById(R.id.edittext_password);

        usernameEditText.setText("");
        passwordEditText.setText("password");

        passwordEditText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        ShadowActivity shadowMainActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        Intent startedIntent = shadowMainActivity.getNextStartedService();

        assertThat(startedIntent).isNull();
    }

    @Test
    public void login_imeActionDone_emptyPassword_shouldNotExecuteRequest() {
        EditText usernameEditText = (EditText) mActivity.findViewById(R.id.edittext_username);
        EditText passwordEditText = (EditText) mActivity.findViewById(R.id.edittext_password);

        usernameEditText.setText("username");
        passwordEditText.setText("");

        passwordEditText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        ShadowActivity shadowMainActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        Intent startedIntent = shadowMainActivity.getNextStartedService();

        assertThat(startedIntent).isNull();
    }

    @Test
    public void login_imeActionDone_nonEmptyPasswordAndUsername_shouldExecuteRequest() {
        EditText usernameEditText = (EditText) mActivity.findViewById(R.id.edittext_username);
        EditText passwordEditText = (EditText) mActivity.findViewById(R.id.edittext_password);

        usernameEditText.setText("username");
        passwordEditText.setText("password");

        passwordEditText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        ShadowActivity shadowMainActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        Intent startedIntent = shadowMainActivity.getNextStartedService();

        assertThat(startedIntent).isNotNull();
        assertThat(startedIntent).hasComponent(new ComponentName(mActivity, ApiService.class));
        assertThat(startedIntent).hasExtra(ApiService.EXTRA_REQUEST);
        assertThat(startedIntent).hasExtra(ApiService.EXTRA_RESULT_RECEIVER);

        Parcelable request = startedIntent.getParcelableExtra(ApiService.EXTRA_REQUEST);
        assertThat(request).isInstanceOf(AuthUserRequest.class);

        Parcelable receiver = startedIntent.getParcelableExtra(ApiService.EXTRA_RESULT_RECEIVER);
        assertThat(receiver).isInstanceOf(ApiReceiver.class);
        assertThat(((ApiReceiver) receiver).getResultListener()).isInstanceOf(MainActivity.class);
    }

    @Test
    public void login_imeActionOther_nonEmptyPasswordAndUsername_shouldNotExecuteRequest() {
        EditText usernameEditText = (EditText) mActivity.findViewById(R.id.edittext_username);
        EditText passwordEditText = (EditText) mActivity.findViewById(R.id.edittext_password);

        usernameEditText.setText("username");
        passwordEditText.setText("password");

        passwordEditText.onEditorAction(EditorInfo.IME_ACTION_GO);

        ShadowActivity shadowMainActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        Intent startedIntent = shadowMainActivity.getNextStartedService();

        assertThat(startedIntent).isNull();
    }

    @Test
    public void login_onRequestStart_shouldShowProgressBar() {
        EditText usernameEditText = (EditText) mActivity.findViewById(R.id.edittext_username);
        EditText passwordEditText = (EditText) mActivity.findViewById(R.id.edittext_password);

        usernameEditText.setText("username");
        passwordEditText.setText("password");

        Button loginButton = (Button) mActivity.findViewById(R.id.btn_login);
        loginButton.performClick();

        UserResponse response = GsonHelper.fromJson(MockResponses.AUTH_USER, UserResponse.class);
        String requestId = ApiEndpoints.getAuthUserUrl();

        Bundle bundle = new Bundle();
        bundle.putString(ApiService.EXTRA_REQUEST_ID, requestId);
        bundle.putParcelable(ApiService.EXTRA_RESPONSE, response);

        mActivity.onReceiveResult(ResultCodes.RUNNING, bundle);

        assertThat(mActivity.findViewById(R.id.progress_bar)).isVisible();
    }

    @Test
    public void login_onRequestSuccess_shouldHideProgressBar() {
        EditText usernameEditText = (EditText) mActivity.findViewById(R.id.edittext_username);
        EditText passwordEditText = (EditText) mActivity.findViewById(R.id.edittext_password);

        usernameEditText.setText("username");
        passwordEditText.setText("password");

        Button loginButton = (Button) mActivity.findViewById(R.id.btn_login);
        loginButton.performClick();

        UserResponse response = GsonHelper.fromJson(MockResponses.AUTH_USER, UserResponse.class);
        String requestId = ApiEndpoints.getAuthUserUrl();

        Bundle bundle = new Bundle();
        bundle.putString(ApiService.EXTRA_REQUEST_ID, requestId);
        bundle.putParcelable(ApiService.EXTRA_RESPONSE, response);

        mActivity.onReceiveResult(ResultCodes.SUCCESS, bundle);

        assertThat(mActivity.findViewById(R.id.progress_bar)).isNotVisible();
    }

    @Test
    public void login_onRequestError_shouldHideProgressBar() {
        EditText usernameEditText = (EditText) mActivity.findViewById(R.id.edittext_username);
        EditText passwordEditText = (EditText) mActivity.findViewById(R.id.edittext_password);

        usernameEditText.setText("username");
        passwordEditText.setText("password");

        Button loginButton = (Button) mActivity.findViewById(R.id.btn_login);
        loginButton.performClick();

        UserResponse response = GsonHelper.fromJson(MockResponses.AUTH_USER, UserResponse.class);
        String requestId = ApiEndpoints.getAuthUserUrl();

        Bundle bundle = new Bundle();
        bundle.putString(ApiService.EXTRA_REQUEST_ID, requestId);
        bundle.putParcelable(ApiService.EXTRA_RESPONSE, response);

        mActivity.onReceiveResult(ResultCodes.ERROR, bundle);

        assertThat(mActivity.findViewById(R.id.progress_bar)).isNotVisible();
    }

    @Test
    public void login_onRequestSuccess_shouldStoreUsernameInSharedPrefs() {
        EditText usernameEditText = (EditText) mActivity.findViewById(R.id.edittext_username);
        EditText passwordEditText = (EditText) mActivity.findViewById(R.id.edittext_password);

        usernameEditText.setText("username");
        passwordEditText.setText("password");

        Button loginButton = (Button) mActivity.findViewById(R.id.btn_login);
        loginButton.performClick();

        UserResponse response = GsonHelper.fromJson(MockResponses.AUTH_USER, UserResponse.class);
        String requestId = ApiEndpoints.getAuthUserUrl();

        Bundle bundle = new Bundle();
        bundle.putString(ApiService.EXTRA_REQUEST_ID, requestId);
        bundle.putParcelable(ApiService.EXTRA_RESPONSE, response);

        mActivity.onReceiveResult(ResultCodes.SUCCESS, bundle);

        assertThat(ArborPreferences.getUsername()).isEqualTo("login");
    }
}
