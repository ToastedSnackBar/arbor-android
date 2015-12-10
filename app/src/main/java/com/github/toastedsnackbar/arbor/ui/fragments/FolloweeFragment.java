package com.github.toastedsnackbar.arbor.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.ui.adapters.FolloweeFragmentPagerAdapter;

public class FolloweeFragment extends Fragment implements OnTabSelectedListener {

    private ViewPager mViewPager;

    public static FolloweeFragment newInstance() {
        return new FolloweeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        return inflater.inflate(R.layout.fragment_followees, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mViewPager = (ViewPager) view.findViewById(R.id.followee_view_pager);
        mViewPager.setOffscreenPageLimit(2);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.following));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.followers));

        FragmentManager fm = getChildFragmentManager();
        FolloweeFragmentPagerAdapter pagerAdapter = new FolloweeFragmentPagerAdapter(fm);
        mViewPager.setAdapter(pagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(FolloweeFragment.this);
        mViewPager.setCurrentItem(0);
    }

    @Override
    public void onTabSelected(Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab) { }

    @Override
    public void onTabReselected(Tab tab) { }
}
