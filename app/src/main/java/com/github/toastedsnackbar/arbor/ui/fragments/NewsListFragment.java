package com.github.toastedsnackbar.arbor.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.ApiReceiver;
import com.github.toastedsnackbar.arbor.net.ApiService;
import com.github.toastedsnackbar.arbor.net.requests.EventListRequest;
import com.github.toastedsnackbar.arbor.net.responses.events.EventListResponse;
import com.github.toastedsnackbar.arbor.ui.adapters.NewsAdapter;

public class NewsListFragment extends Fragment implements ApiReceiver.ReceiveResultListener {

    private NewsAdapter mAdapter;
    private ProgressBar mProgressBar;

    private ApiReceiver mApiReceiver;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mAdapter = new NewsAdapter(getActivity());
        mApiReceiver = new ApiReceiver(new Handler());

        mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

        RecyclerView newsList = (RecyclerView) view.findViewById(R.id.recycler_view);
        newsList.setAdapter(mAdapter);
        newsList.setLayoutManager(new LinearLayoutManager(getActivity()));

        EventListRequest request = new EventListRequest();
        ApiService.executeRequest(getActivity(), request, mApiReceiver);
    }

    @Override
    public void onStart() {
        super.onStart();
        mApiReceiver.setResultListener(NewsListFragment.this);
    }

    @Override
    public void onStop() {
        super.onStop();
        mApiReceiver.setResultListener(null);
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        switch (resultCode) {
            case ApiService.ResultCodes.RUNNING:
                mProgressBar.setVisibility(View.VISIBLE);
                break;

            case ApiService.ResultCodes.SUCCESS:
                EventListResponse response = resultData.getParcelable(ApiService.EXTRA_RESPONSE);
                if (response == null) {
                    return;
                }

                mAdapter.addAll(response.getItems());
                mAdapter.notifyDataSetChanged();
                mProgressBar.setVisibility(View.GONE);
                break;

            case ApiService.ResultCodes.ERROR:
                mProgressBar.setVisibility(View.GONE);
                break;
        }
    }
}
