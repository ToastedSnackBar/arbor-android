package com.github.toastedsnackbar.arbor.ui.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

    private Context mContext;
    private List<RepositoryResponse> mItems;

    public RepositoryAdapter(Context context) {
        mContext = context;
        mItems = new ArrayList<>();
    }

    public void setItems(List<RepositoryResponse> items) {
        mItems.addAll(items);
    }

    public static class RepositoryViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView repositoryName;
        TextView lastUpdatedDateTime;
        TextView createdDateTime;
        TextView repoStars;
        TextView repoFollowing;

        public RepositoryViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            repositoryName = (TextView) itemView.findViewById(R.id.repo_name);
            lastUpdatedDateTime = (TextView) itemView.findViewById(R.id.last_updated_date);
            createdDateTime = (TextView) itemView.findViewById(R.id.creation_date);
            repoStars = (TextView) itemView.findViewById(R.id.stars);
            repoFollowing = (TextView) itemView.findViewById(R.id.following);
        }
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_repository, parent, false);
        return new RepositoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder repositoryViewHolder, int position) {
        SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.CANADA);
        SimpleDateFormat mySDF = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA);

        repositoryViewHolder.repositoryName.setText(mItems.get(position).getName());

        String createdFormattedDate = "";
        String updatedFormattedDate = "";

        try {
            Date createdRawDate = parserSDF.parse(mItems.get(position).getCreated_at());
            Date updatedRawDated = parserSDF.parse(mItems.get(position).getUpdated_at());
            createdFormattedDate = mySDF.format(createdRawDate);
            updatedFormattedDate = mySDF.format(updatedRawDated);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        repositoryViewHolder.createdDateTime.setText(String.format(mContext.getString(R.string.repository_created_date_time), createdFormattedDate));
        repositoryViewHolder.lastUpdatedDateTime.setText(String.format(mContext.getString((R.string.repository_last_updated_date)), updatedFormattedDate));
        repositoryViewHolder.repoStars.setText(String.format(mContext.getString((R.string.repository_repo_stars)), mItems.get(position).getStargazers_count()));
        repositoryViewHolder.repoFollowing.setText(String.format(mContext.getString((R.string.repository_following_count)), mItems.get(position).getWatchers_count()));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}