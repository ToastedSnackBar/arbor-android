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
import com.github.toastedsnackbar.arbor.net.requests.RepositoryListRequest;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryListResponse;
import com.github.toastedsnackbar.arbor.ui.adapters.RepositoryAdapter;

public class RepositoryListFragment extends Fragment implements ApiReceiver.ReceiveResultListener {

    private RepositoryAdapter mAdapter;
    private ProgressBar mProgressBar;

    private ApiReceiver mApiReceiver;

    public static RepositoryListFragment newInstance() {
        return new RepositoryListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repositories, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mAdapter = new RepositoryAdapter(getActivity());
        mApiReceiver = new ApiReceiver(new Handler());

        mProgressBar = (ProgressBar) view.findViewById(R.id.pb_recycler_view);

        RecyclerView repositoriesList = (RecyclerView) view.findViewById(R.id.recycler_view);
        repositoriesList.setAdapter(mAdapter);
        repositoriesList.setLayoutManager(new LinearLayoutManager(getActivity()));

        RepositoryListRequest request = new RepositoryListRequest();
        ApiService.executeRequest(getActivity(), request, mApiReceiver);
    }

    @Override
    public void onStart() {
        super.onStart();
        mApiReceiver.setResultListener(RepositoryListFragment.this);
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
                RepositoryListResponse response = resultData.getParcelable(ApiService
                        .EXTRA_RESPONSE);
                if (response == null) {
                    return;
                }

                mAdapter.setItems(response.getItems());
                mAdapter.notifyDataSetChanged();
                mProgressBar.setVisibility(View.GONE);
                break;

            case ApiService.ResultCodes.ERROR:
                mProgressBar.setVisibility(View.GONE);
                break;
        }
    }
}
