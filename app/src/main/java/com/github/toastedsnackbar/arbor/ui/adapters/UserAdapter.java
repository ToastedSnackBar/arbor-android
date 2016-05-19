package com.github.toastedsnackbar.arbor.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.responses.UserResponse;
import com.github.toastedsnackbar.arbor.ui.adapters.UserAdapter.UserViewHolder;
import com.github.toastedsnackbar.arbor.util.GlideHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends Adapter<UserViewHolder> {

    public static class UserViewHolder extends ViewHolder {

        CircleImageView avatarView;
        TextView nameView;
        TextView usernameView;
        TextView companyView;
        Button followButton;
        Button followingButton;

        public UserViewHolder(View itemView) {
            super(itemView);

            avatarView = (CircleImageView) itemView.findViewById(R.id.avatar);
            nameView = (TextView) itemView.findViewById(R.id.name);
            usernameView = (TextView) itemView.findViewById(R.id.username);
            companyView = (TextView) itemView.findViewById(R.id.company);
            followButton = (Button) itemView.findViewById(R.id.btn_follow);
            followingButton = (Button) itemView.findViewById(R.id.btn_following);
        }
    }

    private Context mContext;
    private List<UserResponse> mItems;
    private Map<UserResponse, Boolean> mFollowingMap;

    private GlideHelper mGlideHelper;

    public UserAdapter(Context context, GlideHelper glideHelper) {
        mContext = context;

        mItems = new ArrayList<>();
        mFollowingMap = new HashMap<>();

        mGlideHelper = glideHelper;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addAll(Map<? extends UserResponse, ? extends Boolean> mapping) {
        mItems.addAll(mapping.keySet());
        mFollowingMap.putAll(mapping);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder userViewHolder, int position) {
        UserResponse user = mItems.get(position);

        String avatarUrl = user.getAvatarUrl();
        mGlideHelper.load(avatarUrl, 100, 100, userViewHolder.avatarView);

        String username = user.getLogin();
        userViewHolder.usernameView.setText(username);

        String name = user.getName();
        if (!TextUtils.isEmpty(name)) {
            userViewHolder.nameView.setText(name);
            userViewHolder.nameView.setVisibility(View.VISIBLE);
        } else {
            userViewHolder.nameView.setVisibility(View.GONE);
        }

        String company = user.getCompany();
        if (!TextUtils.isEmpty(company)) {
            userViewHolder.companyView.setText(company);
            userViewHolder.companyView.setVisibility(View.VISIBLE);
        } else {
            userViewHolder.companyView.setVisibility(View.GONE);
        }

        boolean isFollowing = mFollowingMap.get(user);
        userViewHolder.followButton.setVisibility(isFollowing ? View.INVISIBLE : View.VISIBLE);
        userViewHolder.followingButton.setVisibility(isFollowing ? View.VISIBLE : View.INVISIBLE);
    }
}
