package com.github.toastedsnackbar.arbor.ui.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryResponse;
import com.github.toastedsnackbar.arbor.ui.adapters.RepositoryAdapter.RepositoryViewHolder;
import com.github.toastedsnackbar.arbor.util.DateTimeUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RepositoryAdapter extends Adapter<RepositoryViewHolder> {

    public static class RepositoryViewHolder extends RecyclerView.ViewHolder {

        TextView repositoryName;
        TextView lastUpdatedDateTime;
        TextView repoStars;
        TextView repoFollowing;
        ImageView privacyStatus;
        TextView repoLanguage;
        View repoDescriptionContainer;
        TextView repoDescription;

        public RepositoryViewHolder(View itemView) {
            super(itemView);

            repositoryName = (TextView) itemView.findViewById(R.id.repo_name);
            lastUpdatedDateTime = (TextView) itemView.findViewById(R.id.last_updated_date);
            repoLanguage = (TextView) itemView.findViewById(R.id.repo_language);
            repoStars = (TextView) itemView.findViewById(R.id.stars);
            repoFollowing = (TextView) itemView.findViewById(R.id.following);
            privacyStatus = (ImageView) itemView.findViewById(R.id.privacy_status_icon);
            repoDescriptionContainer = itemView.findViewById(R.id.repo_description_container);
            repoDescription = (TextView) itemView.findViewById(R.id.repo_description);
        }
    }

    private Context mContext;
    private List<RepositoryResponse> mItems;

    private long mObtainedAt;

    public RepositoryAdapter(Context context) {
        mContext = context;
        mItems = new ArrayList<>();

        mObtainedAt = System.currentTimeMillis();
    }

    public void addAll(Collection<? extends RepositoryResponse> items) {
        mItems.addAll(items);
        mObtainedAt = System.currentTimeMillis();
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_repository,
                parent, false);
        return new RepositoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder repositoryViewHolder, int position) {
        RepositoryResponse item = mItems.get(position);
        repositoryViewHolder.repositoryName.setText(item.getName());

        int privacyIcon = item.isPrivate() ? R.drawable.ic_lock_white : R.drawable.ic_public_white;
        repositoryViewHolder.privacyStatus.setImageResource(privacyIcon);

        String updatedAt = item.getUpdatedAt();
        String updatedAtString = DateTimeUtil.getEventTimeStamp(updatedAt, mObtainedAt, mContext);
        repositoryViewHolder.lastUpdatedDateTime.setText(updatedAtString);

        String repoLanguage = item.getRepoLanguage();
        if (!TextUtils.isEmpty(repoLanguage)) {
            repositoryViewHolder.repoLanguage.setText(repoLanguage.toLowerCase());
            repositoryViewHolder.repoLanguage.setVisibility(View.VISIBLE);
        } else {
            repositoryViewHolder.repoLanguage.setVisibility(View.GONE);
        }

        String repoStars = String.valueOf(item.getStargazersCount());
        repositoryViewHolder.repoStars.setText(repoStars);

        String repoFollowing = String.valueOf(item.getWatchersCount());
        repositoryViewHolder.repoFollowing.setText(repoFollowing);

        String description = item.getDescription();
        if (!TextUtils.isEmpty(description)) {
            repositoryViewHolder.repoDescription.setText(description);
            repositoryViewHolder.repoDescriptionContainer.setVisibility(View.VISIBLE);
        } else {
            repositoryViewHolder.repoDescriptionContainer.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
