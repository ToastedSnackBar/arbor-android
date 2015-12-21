package com.github.toastedsnackbar.arbor.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.requests.RepositoryListRequest;
import com.github.toastedsnackbar.arbor.net.responses.ApiResponse;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryListResponse;
import com.github.toastedsnackbar.arbor.ui.adapters.RepositoryAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RepositoryListFragment extends ArborFragment {

    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;

    @Bind(R.id.recycler_view)
    RecyclerView mRepositoriesList;

    private RepositoryAdapter mAdapter;

    public static RepositoryListFragment newInstance() {
        return new RepositoryListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repository_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mAdapter = new RepositoryAdapter(getActivity());
        mRepositoriesList.setAdapter(mAdapter);
        mRepositoriesList.setLayoutManager(new LinearLayoutManager(getActivity()));

        RepositoryListRequest request = new RepositoryListRequest();
        executeRequest(request);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    protected void onRequestStart(String requestId) {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onRequestSuccess(String requestId, ApiResponse baseResponse) {
        if (baseResponse == null) {
            return;
        }

        RepositoryListResponse response = (RepositoryListResponse) baseResponse;
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
        return "fragment_repository_list";
    }
}
