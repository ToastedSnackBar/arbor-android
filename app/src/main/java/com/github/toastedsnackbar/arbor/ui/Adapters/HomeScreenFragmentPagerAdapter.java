package com.github.toastedsnackbar.arbor.ui.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.toastedsnackbar.arbor.ui.Fragments.RepositoriesFragment;

public class HomeScreenFragmentPagerAdapter extends FragmentStatePagerAdapter {
    public HomeScreenFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            default:
                return RepositoriesFragment.newInstance(position);
        }
    }

    @Override
    public int getCount() {
        return 1;
    }
}