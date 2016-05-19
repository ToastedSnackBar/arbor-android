package com.github.toastedsnackbar.arbor.ui.activities;


import android.content.ComponentName;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.content.ArborPreferences;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.internal.ShadowExtractor;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.util.ActivityController;

import butterknife.ButterKnife;

import static org.assertj.android.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class HomeScreenActivityTest {

    private HomeScreenActivity mActivity;
    private ActivityController<HomeScreenActivity> mActivityController;

    @Before
    public void setup() {
        ArborPreferences.setUsername("username");
        ArborPreferences.setEmail("email@host.com");
        ArborPreferences.setAvatarUrl("http://api.host.com/avatar_url");
        mActivityController = Robolectric.buildActivity(HomeScreenActivity.class);
        mActivity = mActivityController.create().start().resume().visible().get();
        ButterKnife.bind(this, mActivity);
    }

    @After
    public void teardown() {
        ArborPreferences.clear();
        mActivityController.pause().stop().destroy();
        mActivityController = null;
        mActivity = null;
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void onCreate_shouldShowActionBar() {
        ActionBar actionBar = mActivity.getSupportActionBar();

        assertThat(actionBar).isNotNull();
        assertThat(actionBar.isShowing()).isTrue();
        assertThat(actionBar.getTitle()).isEqualTo(RuntimeEnvironment.application.getString(
                R.string.news_feed));
    }

    @Test
    public void optionsMenu_actionLogOut_shouldClearPreferencesLaunchMainActivityAndFinish() {
        NavigationView navigation = (NavigationView) mActivity.findViewById(R.id.navigation_view);
        MenuItem logoutItem = navigation.getMenu().findItem(R.id.action_log_out);
        mActivity.onNavigationItemSelected(logoutItem);

        assertThat(ArborPreferences.getAccessToken()).isEmpty();
        assertThat(ArborPreferences.getUsername()).isEmpty();

        ShadowActivity shadowActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        assertThat(startedIntent).isNotNull();
        assertThat(startedIntent).hasComponent(new ComponentName(mActivity, MainActivity.class));

        assertThat(mActivity).isFinishing();
    }
}
