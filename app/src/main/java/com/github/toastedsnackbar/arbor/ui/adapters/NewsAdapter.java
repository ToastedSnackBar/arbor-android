package com.github.toastedsnackbar.arbor.ui.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.responses.events.EventResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.PullRequestEventPayloadResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.PushEventPayloadResponse;
import com.github.toastedsnackbar.arbor.ui.adapters.NewsAdapter.NewsViewHolder;
import com.github.toastedsnackbar.arbor.util.DateTimeUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private static final SpannableString EMPTY_SPANNABLE = new SpannableString("");

    private Context mContext;
    private List<EventResponse> mItems;
    private Picasso mPicasso;

    private SpannableStringBuilder mSpannableBuilder;
    private Map<Integer, SpannableString> mSpannableMap;

    public NewsAdapter(Context context) {
        mContext = context;
        mItems = new ArrayList<>();
        mPicasso = Picasso.with(mContext);

        mSpannableBuilder = new SpannableStringBuilder();
        mSpannableMap = new HashMap<>();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
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
        EventResponse event = mItems.get(position);
        if (event == null) {
            return;
        }

        String createdAt = event.getCreatedAt();
        SpannableString payloadString = getPayloadSpannable(event, position);
        String timestamp = DateTimeUtil.getEventTimeStamp(createdAt, event.getObtainedAt(),
                mContext);
        String avatarUrl = event.getActor().getAvatarUrl();

        newsViewHolder.payload.setText(payloadString);
        newsViewHolder.timestamp.setText(timestamp);
        mPicasso.load(avatarUrl).into(newsViewHolder.avatarView);
    }

    private SpannableString getPayloadSpannable(EventResponse event, int position) {
        SpannableString payloadSpannable = mSpannableMap.get(position);
        if (payloadSpannable != null) {
            return payloadSpannable;
        }

        switch (event.getType()) {
            case PUSH:
                payloadSpannable = getPushPayloadSpannable(event);
                break;

            case PULL_REQUEST:
                payloadSpannable = getPullRequestPayloadSpannable(event);
                break;

            default:
                payloadSpannable = EMPTY_SPANNABLE;
                break;
        }

        mSpannableMap.put(position, payloadSpannable);

        return payloadSpannable;
    }

    private SpannableString getPushPayloadSpannable(EventResponse event) {
        PushEventPayloadResponse payload = (PushEventPayloadResponse) event.getPayload();

        String actorName = event.getActor().getLogin();
        String repoName = event.getRepo().getName();
        String branchName = getBranchNameFromRef(payload.getRef());

        String payloadString = mContext.getString(R.string.payload_push, actorName, branchName,
                repoName);
        mSpannableBuilder.clear();
        mSpannableBuilder.append(payloadString);

        addSpans(payloadString, actorName);
        addSpans(payloadString, branchName);
        addSpans(payloadString, repoName);

        return SpannableString.valueOf(mSpannableBuilder);
    }

    private SpannableString getPullRequestPayloadSpannable(EventResponse event) {
        PullRequestEventPayloadResponse payload = (PullRequestEventPayloadResponse)
                event.getPayload();

        String actorName = event.getActor().getLogin();
        String action = payload.getAction();
        String repoName = event.getRepo().getName();
        String number = String.valueOf(payload.getNumber());

        String payloadString = mContext.getString(R.string.payload_pull_request, actorName, action,
                repoName, number);
        mSpannableBuilder.clear();
        mSpannableBuilder.append(payloadString);

        addSpans(payloadString, actorName);
        addSpans(payloadString, repoName);
        addSpans(payloadString, "#" + number);

        return SpannableString.valueOf(mSpannableBuilder);
    }

    private String getBranchNameFromRef(String ref) {
        String[] refPaths = ref.split("/");
        return refPaths[refPaths.length - 1];
    }

    private void addSpans(String fullString, String substring) {
        int start = fullString.indexOf(substring);
        int end = start + substring.length();

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(
                ContextCompat.getColor(mContext, R.color.accent));
        mSpannableBuilder.setSpan(colorSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        mSpannableBuilder.setSpan(boldSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
    }
}
