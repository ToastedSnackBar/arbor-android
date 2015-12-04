package com.github.toastedsnackbar.arbor.ui.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.ApiEndpoints;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryResponse;
import com.github.toastedsnackbar.arbor.ui.adapters.RepositoryAdapter.RepositoryViewHolder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RepositoryAdapter extends Adapter<RepositoryViewHolder> {

    public static class RepositoryViewHolder extends ViewHolder {
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

    public static final String DATE_FORMAT = "MMMM d, yyyy";

    private Context mContext;
    private List<RepositoryResponse> mItems;

    private DateFormat mSourceDateFormat;
    private DateFormat mDestinationDateFormat;

    public RepositoryAdapter(Context context) {
        mContext = context;
        mItems = new ArrayList<>();

        Locale currentLocale = context.getResources().getConfiguration().locale;
        mSourceDateFormat = new SimpleDateFormat(ApiEndpoints.SERVER_TIME_FORMAT, currentLocale);
        mDestinationDateFormat = new SimpleDateFormat(DATE_FORMAT, currentLocale);
    }

    public void addAll(Collection<? extends RepositoryResponse> items) {
        mItems.addAll(items);
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

        String createdFormattedDate = "";
        String updatedFormattedDate = "";

        try {
            Date createdRawDate = mSourceDateFormat.parse(item.getCreatedAt());
            createdFormattedDate = mDestinationDateFormat.format(createdRawDate);

            Date updatedRawDated = mSourceDateFormat.parse(item.getUpdatedAt());
            updatedFormattedDate = mDestinationDateFormat.format(updatedRawDated);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String createdDateTime = mContext.getString(R.string.repository_created_date_time,
                createdFormattedDate);
        repositoryViewHolder.createdDateTime.setText(Html.fromHtml(createdDateTime));

        String lastUpdatedDateTime = mContext.getString(R.string.repository_last_updated_date,
                updatedFormattedDate);
        repositoryViewHolder.lastUpdatedDateTime.setText(Html.fromHtml(lastUpdatedDateTime));

        String repoStars = String.valueOf(item.getStargazersCount());
        repositoryViewHolder.repoStars.setText(repoStars);

        String repoFollowing = String.valueOf(item.getWatchersCount());
        repositoryViewHolder.repoFollowing.setText(repoFollowing);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
