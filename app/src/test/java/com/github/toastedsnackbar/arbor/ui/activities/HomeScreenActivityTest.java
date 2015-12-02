package com.github.toastedsnackbar.arbor.ui.activities;


import android.content.ComponentName;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.View;

import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.ui.fragments.FollowerListFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.NewsListFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.RepositoryListFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.internal.ShadowExtractor;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.util.ActivityController;

import static org.assertj.android.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class HomeScreenActivityTest {

    private HomeScreenActivity mActivity;
    private ActivityController<HomeScreenActivity> mActivityController;

    @Before
    public void setup() {
        mActivityController = Robolectric.buildActivity(HomeScreenActivity.class);
        mActivity = mActivityController.create().start().resume().visible().get();
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
                R.string.activity_home_screen));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void onCreate_shouldShowTabLayout() {
        TabLayout tabLayout = (TabLayout) mActivity.findViewById(R.id.tab_layout);

        assertThat(tabLayout).isNotNull();
        assertThat(tabLayout.getVisibility()).isEqualTo(View.VISIBLE);
        assertThat(tabLayout.getTabCount()).isEqualTo(3);

        assertThat(tabLayout.getTabAt(0).getText()).isEqualTo(RuntimeEnvironment.application
                .getString(R.string.repos));
        assertThat(tabLayout.getTabAt(1).getText()).isEqualTo(RuntimeEnvironment.application
                .getString(R.string.news));
        assertThat(tabLayout.getTabAt(2).getText()).isEqualTo(RuntimeEnvironment.application
                .getString(R.string.follows));
    }

    @Test
    public void onCreate_shouldShowFragmentViewPager() {
        ViewPager viewPager = (ViewPager) mActivity.findViewById(R.id.home_screen_view_pager);
        assertThat(viewPager).isNotNull();
        assertThat(viewPager.getVisibility()).isEqualTo(View.VISIBLE);

        FragmentStatePagerAdapter adapter = (FragmentStatePagerAdapter) viewPager.getAdapter();
        assertThat(adapter.getCount()).isEqualTo(3);

        assertThat(adapter.getItem(0)).isInstanceOf(RepositoryListFragment.class);
        assertThat(adapter.getItem(1)).isInstanceOf(NewsListFragment.class);
        assertThat(adapter.getItem(2)).isInstanceOf(FollowerListFragment.class);
    }

    @Test
    public void tabLayout_selectFirstTab_shouldShowRepositoryListFragment() {
        TabLayout tabLayout = (TabLayout) mActivity.findViewById(R.id.tab_layout);
        mActivity.onTabSelected(tabLayout.getTabAt(0));

        ViewPager viewPager = (ViewPager) mActivity.findViewById(R.id.home_screen_view_pager);
        FragmentStatePagerAdapter adapter = (FragmentStatePagerAdapter) viewPager.getAdapter();
        assertThat(adapter.getCount()).isEqualTo(3);

        int currentItemPosition = viewPager.getCurrentItem();
        assertThat(adapter.getItem(currentItemPosition)).isInstanceOf(RepositoryListFragment.class);
    }

    @Test
    public void tabLayout_selectSecondTab_shouldShowNewsListFragment() {
        TabLayout tabLayout = (TabLayout) mActivity.findViewById(R.id.tab_layout);
        mActivity.onTabSelected(tabLayout.getTabAt(1));

        ViewPager viewPager = (ViewPager) mActivity.findViewById(R.id.home_screen_view_pager);
        FragmentStatePagerAdapter adapter = (FragmentStatePagerAdapter) viewPager.getAdapter();
        assertThat(adapter.getCount()).isEqualTo(3);

        int currentItemPosition = viewPager.getCurrentItem();
        assertThat(adapter.getItem(currentItemPosition)).isInstanceOf(NewsListFragment.class);
    }

    @Test
    public void tabLayout_selectThirdTab_shouldShowNewsListFragment() {
        TabLayout tabLayout = (TabLayout) mActivity.findViewById(R.id.tab_layout);
        mActivity.onTabSelected(tabLayout.getTabAt(2));

        ViewPager viewPager = (ViewPager) mActivity.findViewById(R.id.home_screen_view_pager);
        FragmentStatePagerAdapter adapter = (FragmentStatePagerAdapter) viewPager.getAdapter();
        assertThat(adapter.getCount()).isEqualTo(3);

        int currentItemPosition = viewPager.getCurrentItem();
        assertThat(adapter.getItem(currentItemPosition)).isInstanceOf(FollowerListFragment.class);
    }

    @Test
    public void tabLayout_reselectTab_shouldNotRecreateFragment() {
        TabLayout tabLayout = (TabLayout) mActivity.findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) mActivity.findViewById(R.id.home_screen_view_pager);
        FragmentStatePagerAdapter adapter = (FragmentStatePagerAdapter) viewPager.getAdapter();

        mActivity.onTabSelected(tabLayout.getTabAt(0));
        int currentItemPosition1 = viewPager.getCurrentItem();
        Fragment item = adapter.getItem(currentItemPosition1);

        mActivity.onTabSelected(tabLayout.getTabAt(0));
        int currentItemPosition2 = viewPager.getCurrentItem();
        Fragment item2 = adapter.getItem(currentItemPosition1);

        assertThat(currentItemPosition2).isEqualTo(currentItemPosition1);
        assertThat(item2).isEqualTo(item);
    }

    @Test
    public void optionsMenu_shouldShowActionItems() {
        ShadowActivity shadowActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        Menu optionsMenu = shadowActivity.getOptionsMenu();

        assertThat(optionsMenu.size()).isEqualTo(1);
        assertThat(optionsMenu.getItem(0).getTitle()).isEqualTo(
                RuntimeEnvironment.application.getString(R.string.action_log_out));
    }

    @Test
    public void optionsMenu_actionLogOut_shouldClearPreferencesLaunchMainActivityAndFinish() {
        ShadowActivity shadowActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        shadowActivity.clickMenuItem(R.id.action_log_out);

        assertThat(ArborPreferences.getAccessToken()).isEmpty();
        assertThat(ArborPreferences.getUsername()).isEmpty();

        Intent startedIntent = shadowActivity.getNextStartedActivity();
        assertThat(startedIntent).isNotNull();
        assertThat(startedIntent).hasComponent(new ComponentName(mActivity, MainActivity.class));

        assertThat(mActivity).isFinishing();
    }

    @Test
    public void optionsMenu_invalidActionSelected_shouldNotConsumeSelection() {
        ShadowActivity shadowActivity = (ShadowActivity) ShadowExtractor.extract(mActivity);
        boolean consumed = shadowActivity.clickMenuItem(-1);

        assertThat(consumed).isFalse();
    }
}
