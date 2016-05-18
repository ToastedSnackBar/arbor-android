package com.github.toastedsnackbar.arbor.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.ApiService;
import com.github.toastedsnackbar.arbor.net.ApiService.ResultCodes;
import com.github.toastedsnackbar.arbor.net.requests.AuthUserIsFollowingRequest;
import com.github.toastedsnackbar.arbor.net.requests.UserListRequest;
import com.github.toastedsnackbar.arbor.net.requests.UserRequest;
import com.github.toastedsnackbar.arbor.net.responses.ApiResponse;
import com.github.toastedsnackbar.arbor.net.responses.IsFollowingResponse;
import com.github.toastedsnackbar.arbor.net.responses.UserListResponse;
import com.github.toastedsnackbar.arbor.net.responses.UserResponse;
import com.github.toastedsnackbar.arbor.ui.adapters.UserAdapter;
import com.github.toastedsnackbar.arbor.util.GlideHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FolloweeListFragment extends ArborFragment {

    public static final String KEY_URL = "key_url";
    public static final String KEY_IS_AUTHORIZED = "key_is_authorized";

    private UserAdapter mAdapter;
    private ProgressBar mProgressBar;

    private String mFolloweeListRequestId;
    private Map<String, UserResponse> mFollowingRequestIdUserMap;
    private Map<String, UserResponse> mUserRequestIdFollowerMap;
    private Map<UserResponse, Boolean> mFollowingMap;

    private int mUserCount;

    private GlideHelper mGlideHelper;

    public static FolloweeListFragment newInstance(String url, boolean isAuthorized) {
        FolloweeListFragment fragment = new FolloweeListFragment();
        Bundle args = new Bundle();
        args.putString(KEY_URL, url);
        args.putBoolean(KEY_IS_AUTHORIZED, isAuthorized);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_followee_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mGlideHelper = new GlideHelper(getActivity());
        mAdapter = new UserAdapter(getActivity(), mGlideHelper);

        mFollowingMap = new HashMap<>();
        mFollowingRequestIdUserMap = new HashMap<>();
        mUserRequestIdFollowerMap = new HashMap<>();

        mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

        RecyclerView usersList = (RecyclerView) view.findViewById(R.id.recycler_view);
        usersList.setAdapter(mAdapter);
        usersList.setLayoutManager(new LinearLayoutManager(getActivity()));
        usersList.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (RecyclerView.SCROLL_STATE_IDLE == newState) {
                    mGlideHelper.resumeRequests();
                } else if (RecyclerView.SCROLL_STATE_DRAGGING == newState) {
                    mGlideHelper.pauseRequests();
                }
            }
        });

        Bundle args = getArguments();
        String url = args.getString(KEY_URL);
        boolean isAuthorized = args.getBoolean(KEY_IS_AUTHORIZED, true);

        UserListRequest userListRequest = new UserListRequest(url, isAuthorized);
        mFolloweeListRequestId = userListRequest.getRequestId();
        executeRequest(userListRequest);
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        String requestId = resultData.getString(ApiService.EXTRA_REQUEST_ID);
        if (TextUtils.isEmpty(requestId)) {
            return;
        }

        switch (resultCode) {
            case ResultCodes.RUNNING:
                if (requestId.equals(mFolloweeListRequestId)) {
                    mProgressBar.setVisibility(View.VISIBLE);
                }
                break;

            case ResultCodes.SUCCESS:
                if (requestId.equals(mFolloweeListRequestId)) {
                    UserListResponse response = resultData.getParcelable(ApiService.EXTRA_RESPONSE);
                    if (response == null) {
                        return;
                    }

                    List<UserResponse> users = response.getItems();
                    mUserCount = users.size();
                    for (UserResponse user : users) {
                        UserRequest userRequest = new UserRequest(user.getLogin());
                        String userRequestId = userRequest.getRequestId();
                        mUserRequestIdFollowerMap.put(userRequestId, user);

                        executeRequest(userRequest);
                    }
                }

                if (mUserRequestIdFollowerMap.containsKey(requestId)) {
                    UserResponse userResponse = resultData.getParcelable(ApiService.EXTRA_RESPONSE);
                    if (userResponse == null) {
                        return;
                    }

                    UserResponse followerResponse = mUserRequestIdFollowerMap.remove(requestId);
                    AuthUserIsFollowingRequest isFollowingRequest =
                            new AuthUserIsFollowingRequest(followerResponse.getLogin());
                    executeRequest(isFollowingRequest);

                    String isFollowingRequestId = isFollowingRequest.getRequestId();
                    mFollowingRequestIdUserMap.put(isFollowingRequestId, userResponse);
                }

                if (mFollowingRequestIdUserMap.containsKey(requestId)) {
                    IsFollowingResponse response = resultData.getParcelable(
                            ApiService.EXTRA_RESPONSE);

                    UserResponse user = mFollowingRequestIdUserMap.remove(requestId);
                    mFollowingMap.put(user, response != null);

                    if (mFollowingMap.size() == mUserCount) {
                        mAdapter.addAll(mFollowingMap);
                        mAdapter.notifyDataSetChanged();

                        mUserRequestIdFollowerMap.clear();
                        mFollowingRequestIdUserMap.clear();
                        mFollowingMap.clear();

                        mProgressBar.setVisibility(View.GONE);
                    }
                }
                break;
        }
    }

    @Override
    protected void onRequestStart(String requestId) {
        if (requestId.equals(mFolloweeListRequestId)) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onRequestSuccess(String requestId, ApiResponse baseResponse) {
        if (requestId.equals(mFolloweeListRequestId)) {
            UserListResponse response = (UserListResponse) baseResponse;
            if (response == null) {
                return;
            }

            List<UserResponse> users = response.getItems();
            mUserCount = users.size();
            for (UserResponse user : users) {
                UserRequest userRequest = new UserRequest(user.getLogin());
                String userRequestId = userRequest.getRequestId();
                mUserRequestIdFollowerMap.put(userRequestId, user);

                executeRequest(userRequest);
            }
        } else if (mUserRequestIdFollowerMap.containsKey(requestId)) {
            UserResponse userResponse = (UserResponse) baseResponse;
            if (userResponse == null) {
                return;
            }

            UserResponse followerResponse = mUserRequestIdFollowerMap.remove(requestId);
            AuthUserIsFollowingRequest isFollowingRequest =
                    new AuthUserIsFollowingRequest(followerResponse.getLogin());
            executeRequest(isFollowingRequest);

            String isFollowingRequestId = isFollowingRequest.getRequestId();
            mFollowingRequestIdUserMap.put(isFollowingRequestId, userResponse);
        } else if (mFollowingRequestIdUserMap.containsKey(requestId)) {
            IsFollowingResponse response = (IsFollowingResponse) baseResponse;

            UserResponse user = mFollowingRequestIdUserMap.remove(requestId);
            mFollowingMap.put(user, response != null);

            if (mFollowingMap.size() == mUserCount) {
                mAdapter.addAll(mFollowingMap);
                mAdapter.notifyDataSetChanged();

                mUserRequestIdFollowerMap.clear();
                mFollowingRequestIdUserMap.clear();
                mFollowingMap.clear();

                mProgressBar.setVisibility(View.GONE);
            }
        }
    }

    @Override
    protected void onRequestError(String requestId) {

    }

    @Override
    public String getFragmentTag() {
        return "fragment_followee_list";
    }
}
