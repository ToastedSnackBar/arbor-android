package com.github.toastedsnackbar.arbor.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.requests.AuthUserRequest;
import com.github.toastedsnackbar.arbor.net.responses.ApiResponse;
import com.github.toastedsnackbar.arbor.net.responses.UserResponse;
import com.github.toastedsnackbar.arbor.ui.adapters.FolloweeFragmentPagerAdapter;

public class FolloweeFragment extends ArborFragment implements OnTabSelectedListener {

    private TabLayout mTabLayout;
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

        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.following));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.followers));

        FragmentManager fm = getChildFragmentManager();
        FolloweeFragmentPagerAdapter pagerAdapter = new FolloweeFragmentPagerAdapter(fm);
        mViewPager.setAdapter(pagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(FolloweeFragment.this);
        mViewPager.setCurrentItem(0);

        AuthUserRequest request = new AuthUserRequest();
        executeRequest(request);
    }

    @Override
    protected void onRequestStart(String requestId) {}

    @Override
    protected void onRequestSuccess(String requestId, ApiResponse baseResponse) {
        UserResponse response = (UserResponse) baseResponse;

        if (response != null) {
            Tab followingTab = mTabLayout.getTabAt(0);
            int followingCount = response.getFollowingCount();
            setTabFolloweeCount(followingTab, followingCount, R.string.following_count);

            Tab followerTab = mTabLayout.getTabAt(1);
            int followerCount = response.getFollowerCount();
            setTabFolloweeCount(followerTab, followerCount, R.string.followers_count);
        }
    }

    @Override
    protected void onRequestError(String requestId) {}

    private void setTabFolloweeCount(Tab tab, int count, int stringResId) {
        if (tab != null && count >= 0) {
            String followerString = getFolloweeCountString(stringResId, count);
            tab.setText(followerString);
        }
    }

    private String getFolloweeCountString(int stringResId, int count) {
        return String.format(getActivity().getString(stringResId), count);
    }

    @Override
    public void onTabSelected(Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab) { }

    @Override
    public void onTabReselected(Tab tab) { }

    @Override
    public String getFragmentTag() {
        return "fragment_followee";
    }
}
