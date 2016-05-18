package com.github.toastedsnackbar.arbor.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.ApiReceiver;
import com.github.toastedsnackbar.arbor.net.requests.EventListRequest;
import com.github.toastedsnackbar.arbor.net.responses.ApiResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventListResponse;
import com.github.toastedsnackbar.arbor.ui.adapters.NewsAdapter;
import com.github.toastedsnackbar.arbor.util.GlideHelper;

public class NewsListFragment extends ArborFragment implements ApiReceiver.ReceiveResultListener {

    private NewsAdapter mAdapter;
    private ProgressBar mProgressBar;

    private GlideHelper mGlideHelper;

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
        mGlideHelper = new GlideHelper(getActivity());
        mAdapter = new NewsAdapter(getActivity(), mGlideHelper);

        mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

        RecyclerView newsList = (RecyclerView) view.findViewById(R.id.recycler_view);
        newsList.setAdapter(mAdapter);
        newsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsList.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (RecyclerView.SCROLL_STATE_IDLE == newState) {
                    mGlideHelper.resumeRequests();
                } else if (RecyclerView.SCROLL_STATE_DRAGGING == newState) {
                    mGlideHelper.pauseRequests();
                }
            }
        });

        EventListRequest request = new EventListRequest();
        executeRequest(request);
    }

    @Override
    protected void onRequestStart(String requestId) {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onRequestSuccess(String requestId, ApiResponse baseResponse) {
        EventListResponse response = (EventListResponse) baseResponse;
        if (response == null) {
            return;
        }

        mAdapter.addAll(response.getItems());
        mAdapter.notifyDataSetChanged();
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onRequestError(String requestId) {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public String getFragmentTag() {
        return "fragment_news_list";
    }
}
