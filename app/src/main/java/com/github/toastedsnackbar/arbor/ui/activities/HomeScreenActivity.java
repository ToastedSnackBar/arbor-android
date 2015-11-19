package com.github.toastedsnackbar.arbor.ui.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.ui.Adapters.HomeScreenFragmentPagerAdapter;

public class HomeScreenActivity extends FragmentActivity {

    HomeScreenFragmentPagerAdapter homeScreenFragmentPagerAdapter;
    ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_home_screen);
        viewPager = (ViewPager) findViewById(R.id.home_screen_view_pager);

        homeScreenFragmentPagerAdapter = new HomeScreenFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(homeScreenFragmentPagerAdapter);
    }
}

