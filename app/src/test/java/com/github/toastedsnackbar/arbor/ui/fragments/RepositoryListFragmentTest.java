package com.github.toastedsnackbar.arbor.ui.fragments;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.net.ApiService;
import com.github.toastedsnackbar.arbor.net.ApiService.ResultCodes;
import com.github.toastedsnackbar.arbor.net.gson.GsonHelper;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryListResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static org.assertj.android.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class RepositoryListFragmentTest {

    private RepositoryListFragment mFragment;

    @Before
    public void setup() {
        ArborPreferences.init(RuntimeEnvironment.application);
        ArborPreferences.setAccessToken("access_token");
        mFragment = new RepositoryListFragment();
        SupportFragmentTestUtil.startFragment(mFragment, FragmentActivity.class);
    }

    @After
    public void teardown() {
        ArborPreferences.clear();
        mFragment = null;
    }

    @Test
    public void onCreate_shouldExecuteRequest() {
        ShadowApplication shadowApplication = ShadowApplication.getInstance();
        Intent startedIntent = shadowApplication.getNextStartedService();

        assertThat(startedIntent).isNotNull();
        assertThat(startedIntent).hasComponent(new ComponentName(RuntimeEnvironment.application,
                ApiService.class));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void onRequestStart_shouldShowProgressBar() {
        mFragment.onReceiveResult(ResultCodes.RUNNING, Bundle.EMPTY);

        ProgressBar progressBar = (ProgressBar) mFragment.getView().findViewById(R.id.progress_bar);
        assertThat(progressBar).isNotNull();
        assertThat(progressBar).isVisible();
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void onRequestSuccess_shouldShowRecyclerViewAndHideProgressBar() {
        RepositoryListResponse response = GsonHelper.fromJson(MockResponses.REPOSITORY_LIST,
                RepositoryListResponse.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ApiService.EXTRA_RESPONSE, response);
        mFragment.onReceiveResult(ResultCodes.SUCCESS, bundle);

        ProgressBar progressBar = (ProgressBar) mFragment.getView().findViewById(R.id.progress_bar);
        assertThat(progressBar).isNotNull();
        assertThat(progressBar).isNotVisible();

        RecyclerView list = (RecyclerView) mFragment.getView().findViewById(R.id.recycler_view);
        assertThat(list).isNotNull();
        assertThat(list).isVisible();
        assertThat(list.getAdapter().getItemCount()).isEqualTo(2);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void onRequestError_shouldHideProgressBar() {
        mFragment.onReceiveResult(ResultCodes.ERROR, Bundle.EMPTY);

        ProgressBar progressBar = (ProgressBar) mFragment.getView().findViewById(R.id.progress_bar);
        assertThat(progressBar).isNotNull();
        assertThat(progressBar).isNotVisible();
    }
}
