package com.github.toastedsnackbar.arbor.ui.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.responses.events.EventPayloadResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventType;
import com.github.toastedsnackbar.arbor.net.responses.events.PushEventPayloadResponse;
import com.github.toastedsnackbar.arbor.ui.adapters.NewsAdapter.NewsViewHolder;
import com.github.toastedsnackbar.arbor.util.DateTimeUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewsAdapter extends Adapter<NewsViewHolder> {

    public static class NewsViewHolder extends ViewHolder {
        CardView cardView;
        CircleImageView avatarView;
        TextView timestamp;
        TextView payload;

        public NewsViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            avatarView = (CircleImageView) itemView.findViewById(R.id.avatar);
            timestamp = (TextView) itemView.findViewById(R.id.timestamp);
            payload = (TextView) itemView.findViewById(R.id.payload_text);
        }
    }

    private Context mContext;
    private List<EventResponse> mItems;
    private Picasso mPicasso;

    public NewsAdapter(Context context) {
        mContext = context;
        mItems = new ArrayList<>();
        mPicasso = Picasso.with(mContext);
    }

    public void addAll(Collection<? extends EventResponse> items) {
        mItems.addAll(items);
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item_news, parent, false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder newsViewHolder, int position) {
        EventResponse item = mItems.get(position);
        EventType type = item.getType();
        String createdAt = item.getCreatedAt();
        PushEventPayloadResponse payload = (PushEventPayloadResponse) item.getPayload();

        String timestamp = DateTimeUtil.getEventTimeStamp(createdAt, item.getObtainedAt(),
                mContext);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
