package com.github.toastedsnackbar.arbor.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.toastedsnackbar.arbor.ui.fragments.FollowerListFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.NewsListFragment;
import com.github.toastedsnackbar.arbor.ui.fragments.RepositoryListFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;

    public HomeScreenFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

        mFragments = new ArrayList<>();
        mFragments.add(RepositoryListFragment.newInstance());
        mFragments.add(NewsListFragment.newInstance());
        mFragments.add(FollowerListFragment.newInstance());
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
