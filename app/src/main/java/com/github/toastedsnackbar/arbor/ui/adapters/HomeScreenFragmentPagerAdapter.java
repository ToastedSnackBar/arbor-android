package com.github.toastedsnackbar.arbor.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.toastedsnackbar.arbor.ui.fragments.FollowersFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.NewsFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.RepositoriesFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;

    public HomeScreenFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

        mFragments = new ArrayList<>();
        mFragments.add(RepositoriesFragment.newInstance());
        mFragments.add(NewsFragment.newInstance());
        mFragments.add(FollowersFragment.newInstance());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}