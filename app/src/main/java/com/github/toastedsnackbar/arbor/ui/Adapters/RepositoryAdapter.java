package com.github.toastedsnackbar.arbor.ui.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.toastedsnackbar.arbor.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

    public RepositoryAdapter() {
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_element, parent, false);
        return new RepositoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder repositoryViewHolder, int position) {
        SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat mySDF = new SimpleDateFormat("yyyy-MM-dd");

        repositoryViewHolder.repositoryName.setText(repositories.get(position).getName());

        String createdFormattedDate = "";
        String updatedFormattedDate = "";

        try {
            Date createdRawDate = parserSDF.parse(repositories.get(position).getCreated_at());
            Date updatedRawDated = parserSDF.parse(repositories.get(position).getUpdated_at());

            createdFormattedDate = mySDF.format(createdRawDate);
            updatedFormattedDate = mySDF.format(updatedRawDated);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        repositoryViewHolder.createdDateTime.setText("Created on: " + createdFormattedDate);
        repositoryViewHolder.lastUpdatedDateTime.setText("Last Updated: " + updatedFormattedDate);
        repositoryViewHolder.repoStars.setText("Stars: " + repositories.get(position).getStargazers_count().toString());
        repositoryViewHolder.repoFollowing.setText("Following: " + repositories.get(position).getWatchers_count().toString());
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}