package com.github.toastedsnackbar.arbor.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.toastedsnackbar.arbor.ui.fragments.FollowersFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.NewsFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.RepositoriesFragment;

public class HomeScreenFragmentPagerAdapter extends FragmentStatePagerAdapter {

    public HomeScreenFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return RepositoriesFragment.newInstance(position);
            case 1:
                return NewsFragment.newInstance(position);
            default:
                return FollowersFragment.newInstance(position);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}