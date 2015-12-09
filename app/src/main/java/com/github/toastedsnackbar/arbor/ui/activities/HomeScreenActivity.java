package com.github.toastedsnackbar.arbor.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.Fragment;
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
import com.github.toastedsnackbar.arbor.ui.fragments.FollowerListFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.NewsListFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.RepositoryListFragment;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeScreenActivity extends AppCompatActivity implements
        OnNavigationItemSelectedListener {

    private Toolbar mToolbar;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

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

        mToolbar = (Toolbar) findViewById(R.id.toolbar_home);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = setupDrawerToggle();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        NavigationView navigation = (NavigationView) findViewById(R.id.navigation_view);
        navigation.setNavigationItemSelectedListener(HomeScreenActivity.this);
        setupNavigationHeader(navigation);

        onNavigationItemSelected(navigation.getMenu().findItem(R.id.nav_activity));
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
        Class<? extends Fragment> fragmentClass = null;
        Fragment fragment = null;

        switch (menuItem.getItemId()) {
            case R.id.nav_activity:
                fragmentClass = NewsListFragment.class;
                break;

            case R.id.nav_my_repositories:
                fragmentClass = RepositoryListFragment.class;
                break;

            case R.id.nav_my_followings:
                fragmentClass = FollowerListFragment.class;
                break;

            case R.id.action_log_out:
                ArborPreferences.clear();
                MainActivity.start(HomeScreenActivity.this);
                finish();
                break;
        }

        if (fragmentClass != null) {
            try {
                fragment = fragmentClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

            showFragment(fragment);
            menuItem.setChecked(true);
            setTitle(menuItem.getTitle());

            mDrawerLayout.closeDrawers();
        }

        return true;
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(HomeScreenActivity.this, mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close);
    }

    private void setupNavigationHeader(NavigationView navigation) {
        View headerView = navigation.inflateHeaderView(R.layout.nav_header);

        CircleImageView avatarView = (CircleImageView) headerView.findViewById(R.id.avatar);
        String avatarUrl = ArborPreferences.getAvatarUrl();
        Picasso.with(HomeScreenActivity.this).load(avatarUrl).into(avatarView);

        TextView usernameView = (TextView) headerView.findViewById(R.id.username);
        String username = ArborPreferences.getUsername();
        usernameView.setText(username);

        TextView emailView = (TextView) headerView.findViewById(R.id.email);
        String email = ArborPreferences.getEmail();
        emailView.setText(email);
    }
}
