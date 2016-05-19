package com.github.toastedsnackbar.arbor.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.ui.fragments.FolloweeListFragment;

import java.util.ArrayList;
import java.util.List;

public class FolloweeFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;

    public FolloweeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

        mFragments = new ArrayList<>();
        mFragments.add(FolloweeListFragment.newInstance(ApiEndpoints.getAuthUserFollowingUrl(),
                true));
        mFragments.add(FolloweeListFragment.newInstance(ApiEndpoints.getAuthUserFollowersUrl(),
                true));
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
