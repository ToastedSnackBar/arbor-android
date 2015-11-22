package com.github.toastedsnackbar.arbor.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.toastedsnackbar.arbor.R;

public class FollowersFragment extends Fragment {

    public static FollowersFragment newInstance(int num) {
        FollowersFragment followersFragment = new FollowersFragment();

        Bundle args = new Bundle();
        args.putInt("num", num);
        followersFragment.setArguments(args);

        return followersFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_followers, container, false);
    }
}
