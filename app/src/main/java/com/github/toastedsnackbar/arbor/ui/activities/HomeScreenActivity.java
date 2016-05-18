package com.github.toastedsnackbar.arbor.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.content.ArborPreferences;
import com.github.toastedsnackbar.arbor.ui.fragments.ArborFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.FolloweeFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.NewsListFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.RepositoryListFragment;
import com.github.toastedsnackbar.arbor.util.GlideHelper;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeScreenActivity extends AppCompatActivity implements
        OnNavigationItemSelectedListener {

    private static final String KEY_INITIAL_FRAGMENT = "key_initial_fragment";

    private static final int DEFAULT_INITIAL_NAV = R.id.nav_activity;

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private int mInitialNav;
    private MenuItem mCurrentNav;

    private GlideHelper mGlideHelper;

    public static void start(Context context) {
        Intent intent = new Intent(context, HomeScreenActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        mGlideHelper = new GlideHelper(HomeScreenActivity.this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_home);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = setupDrawerToggle();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        NavigationView navigation = (NavigationView) findViewById(R.id.navigation_view);
        if (navigation != null) {
            navigation.setNavigationItemSelectedListener(HomeScreenActivity.this);
            setupNavigationHeader(navigation);
        }

        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_INITIAL_FRAGMENT)) {
            mInitialNav = savedInstanceState.getInt(KEY_INITIAL_FRAGMENT);
        } else {
            mInitialNav = DEFAULT_INITIAL_NAV;
        }

        if (navigation != null) {
            onNavigationItemSelected(navigation.getMenu().findItem(mInitialNav));
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        ArborFragment fragment = null;

        if (mCurrentNav != null
                && menuItem.getItemId() == mCurrentNav.getItemId()
                && menuItem.getGroupId() != R.id.action_items) {
            mDrawerLayout.closeDrawers();
            return true;
        }

        if (menuItem.getGroupId() != R.id.action_items) {
            mCurrentNav = menuItem;
        }

        switch (menuItem.getItemId()) {
            case R.id.nav_activity:
                fragment = NewsListFragment.newInstance();
                break;

            case R.id.nav_my_repositories:
                fragment = RepositoryListFragment.newInstance();
                break;

            case R.id.nav_my_followings:
                fragment = FolloweeFragment.newInstance();
                break;

            case R.id.action_log_out:
                ArborPreferences.clear();
                MainActivity.start(HomeScreenActivity.this);
                finish();
                break;
        }

        if (fragment != null) {
            showFragment(fragment);
            menuItem.setChecked(true);
            setTitle(menuItem.getTitle());
            mDrawerLayout.closeDrawers();
        }

        return true;
    }

    private void showFragment(ArborFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, fragment,
                fragment.getFragmentTag()).commit();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(HomeScreenActivity.this, mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close);
    }

    private void setupNavigationHeader(NavigationView navigation) {
        View headerView = navigation.inflateHeaderView(R.layout.nav_header);

        CircleImageView avatarView = (CircleImageView) headerView.findViewById(R.id.avatar);
        String avatarUrl = ArborPreferences.getAvatarUrl();
        mGlideHelper.load(avatarUrl, avatarView);

        TextView usernameView = (TextView) headerView.findViewById(R.id.username);
        String username = ArborPreferences.getUsername();
        usernameView.setText(username);

        TextView emailView = (TextView) headerView.findViewById(R.id.email);
        String email = ArborPreferences.getEmail();
        emailView.setText(email);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INITIAL_FRAGMENT, mInitialNav);
    }
}
