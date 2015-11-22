package com.github.toastedsnackbar.arbor.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.toastedsnackbar.arbor.R;

public class NewsFragment extends Fragment {

    public static NewsFragment newInstance(int num) {
        NewsFragment newsFragment = new NewsFragment();

        Bundle args = new Bundle();
        args.putInt("num", num);
        newsFragment.setArguments(args);

        return newsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }
}
