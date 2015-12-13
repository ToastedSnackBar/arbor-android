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

import butterknife.Bind;
import butterknife.ButterKnife;

public class RepositoryListFragment extends Fragment implements ApiReceiver.ReceiveResultListener {

    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;

    @Bind(R.id.recycler_view)
    RecyclerView mRepositoriesList;

    private RepositoryAdapter mAdapter;

    private ApiReceiver mApiReceiver;

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
        mApiReceiver = new ApiReceiver(new Handler());
        mApiReceiver.setResultListener(RepositoryListFragment.this);

        mRepositoriesList.setAdapter(mAdapter);
        mRepositoriesList.setLayoutManager(new LinearLayoutManager(getActivity()));

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
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
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
