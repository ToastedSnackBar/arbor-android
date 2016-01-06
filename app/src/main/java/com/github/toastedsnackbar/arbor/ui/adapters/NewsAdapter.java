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
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.toastedsnackbar.arbor.R;
import com.github.toastedsnackbar.arbor.net.responses.CommitResponse;
import com.github.toastedsnackbar.arbor.net.responses.PageResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventType;
import com.github.toastedsnackbar.arbor.net.responses.events.GollumEventPayloadResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.PullRequestEventPayloadResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.PushEventPayloadResponse;
import com.github.toastedsnackbar.arbor.ui.adapters.NewsAdapter.NewsViewHolder;
import com.github.toastedsnackbar.arbor.util.DateTimeUtil;
import com.github.toastedsnackbar.arbor.util.StringUtil;
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

    public static class PushNewsViewHolder extends NewsViewHolder {

        View commit1;
        View commit2;
        TextView commitSum1;
        TextView commitSum2;
        TextView commitMsg1;
        TextView commitMsg2;
        TextView commitCount;

        public PushNewsViewHolder(View itemView) {
            super(itemView);

            commit1 = itemView.findViewById(R.id.commit_1);
            commit2 = itemView.findViewById(R.id.commit_2);
            commitSum1 = (TextView) itemView.findViewById(R.id.commit_sum_1);
            commitSum2 = (TextView) itemView.findViewById(R.id.commit_sum_2);
            commitMsg1 = (TextView) itemView.findViewById(R.id.commit_message_1);
            commitMsg2 = (TextView) itemView.findViewById(R.id.commit_message_2);
            commitCount = (TextView) itemView.findViewById(R.id.commit_count);
        }
    }

    public static class PullRequestNewsViewHolder extends NewsViewHolder {

        TextView description;
        TextView commitCount;
        TextView additionCount;
        TextView deletionCount;

        public PullRequestNewsViewHolder(View itemView) {
            super(itemView);

            description = (TextView) itemView.findViewById(R.id.pull_request_description);
            commitCount = (TextView) itemView.findViewById(R.id.commit_count);
            additionCount = (TextView) itemView.findViewById(R.id.addition_count);
            deletionCount = (TextView) itemView.findViewById(R.id.deletion_count);
        }
    }

    public static class GollumNewsViewHolder extends NewsViewHolder {

        TextView description;

        public GollumNewsViewHolder(View itemView) {
            super(itemView);

            description = (TextView) itemView.findViewById(R.id.gollum_description);
        }
    }

    private static final SpannableString EMPTY_SPANNABLE = new SpannableString("");

    private Context mContext;
    private List<EventResponse> mItems;
    private Picasso mPicasso;

    private SpannableStringBuilder mSpannableBuilder;
    private Map<Integer, SpannableString> mPayloadSpannableMap;
    private Map<Integer, SpannableString> mGollumSpannableMap;

    public NewsAdapter(Context context) {
        mContext = context;
        mItems = new ArrayList<>();
        mPicasso = Picasso.with(mContext);

        mSpannableBuilder = new SpannableStringBuilder();
        mPayloadSpannableMap = new HashMap<>();
        mGollumSpannableMap = new HashMap<>();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getType().ordinal();
    }

    public void addAll(Collection<? extends EventResponse> items) {
        mItems.addAll(items);
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(mContext);

        final EventType[] types = EventType.values();
        switch (types[viewType]) {
            case PUSH:
                viewHolder = new PushNewsViewHolder(inflater.inflate(
                        R.layout.list_item_news_push, parent, false));
                break;

            case PULL_REQUEST:
                viewHolder = new PullRequestNewsViewHolder(inflater.inflate(
                        R.layout.list_item_news_pull_request, parent, false));
                break;

            case GOLLUM:
                viewHolder = new GollumNewsViewHolder(inflater.inflate(
                        R.layout.list_item_news_gollum, parent, false));
                break;

            default:
                viewHolder = new NewsViewHolder(inflater.inflate(
                        R.layout.list_item_news, parent, false));
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder newsViewHolder, int position) {
        EventResponse event = mItems.get(position);
        if (event == null) {
            return;
        }

        String createdAt = event.getCreatedAt();
        String timestamp = DateTimeUtil.getEventTimeStamp(createdAt, event.getObtainedAt(),
                mContext);
        SpannableString payloadString = mPayloadSpannableMap.get(position);
        String avatarUrl = event.getActor().getAvatarUrl();

        switch (event.getType()) {
            case PUSH:
                setPushItemView((PushNewsViewHolder) newsViewHolder, event);
                if (payloadString == null) {
                    payloadString = getPushPayloadSpannable(event);
                    mPayloadSpannableMap.put(position, payloadString);
                }
                break;

            case PULL_REQUEST:
                setPullRequestItemView((PullRequestNewsViewHolder) newsViewHolder, event);
                if (payloadString == null) {
                    payloadString = getPullRequestPayloadSpannable(event);
                    mPayloadSpannableMap.put(position, payloadString);
                }
                break;

            case GOLLUM:
                setGollumItemView((GollumNewsViewHolder) newsViewHolder, event, position);
                if (payloadString == null) {
                    payloadString = getGollumPayloadSpannable(event);
                    mPayloadSpannableMap.put(position, payloadString);
                }
                break;

            default:
                payloadString = EMPTY_SPANNABLE;
                break;
        }

        newsViewHolder.payload.setText(payloadString);
        newsViewHolder.timestamp.setText(timestamp);
        mPicasso.load(avatarUrl).into(newsViewHolder.avatarView);
    }

    private void setPushItemView(PushNewsViewHolder pushViewHolder, EventResponse event) {
        PushEventPayloadResponse payload = (PushEventPayloadResponse) event.getPayload();
        List<CommitResponse> commits = payload.getCommits();

        CommitResponse firstCommit = payload.getCommits().get(0);

        // 1st commit is always shown
        String commitSum1 = firstCommit.getSha().substring(0, 7);
        pushViewHolder.commitSum1.setText(commitSum1);

        String commitMsg1 = firstCommit.getMessage();
        pushViewHolder.commitMsg1.setText(commitMsg1);

        if (commits.size() >= 2) { // at least 2 commits (show everything)
            CommitResponse secondCommit = payload.getCommits().get(1);
            String commitSum2 = secondCommit.getSha().substring(0, 7);
            pushViewHolder.commitSum2.setText(commitSum2);

            String commitMsg2 = secondCommit.getMessage();
            pushViewHolder.commitMsg2.setText(commitMsg2);

            if (commits.size() > 2) {
                int commitCount = commits.size() - 2;

                int commitCountResId = commitCount > 1 ?
                        R.string.commits_count : R.string.commit_count;
                String commitCountString = mContext.getString(commitCountResId, commitCount);

                pushViewHolder.commitCount.setText(commitCountString);
                pushViewHolder.commitCount.setVisibility(View.VISIBLE);
            } else {
                pushViewHolder.commitCount.setVisibility(View.GONE);
            }

            pushViewHolder.commit2.setVisibility(View.VISIBLE);
        } else { // 1 commit (hide second commit and commit count)
            pushViewHolder.commit2.setVisibility(View.GONE);
            pushViewHolder.commitCount.setVisibility(View.GONE);
        }
    }

    private void setPullRequestItemView(PullRequestNewsViewHolder pullRequestViewHolder,
                                        EventResponse event) {
        PullRequestEventPayloadResponse payload = (PullRequestEventPayloadResponse)
                event.getPayload();

        String description = payload.getPullRequest().getBody();
        if (!TextUtils.isEmpty(description)) {
            pullRequestViewHolder.description.setText(description);
            pullRequestViewHolder.description.setVisibility(View.VISIBLE);
        } else {
            pullRequestViewHolder.description.setVisibility(View.GONE);
        }

        int commitCount = payload.getPullRequest().getCommitCount();
        int commitCountStringResId = commitCount > 1 ?
                R.string.commits_count_pr : R.string.commit_count_pr;
        String commitCountString = mContext.getString(commitCountStringResId, commitCount);
        pullRequestViewHolder.commitCount.setText(commitCountString);

        int additionCount = payload.getPullRequest().getAdditionCount();
        int additionCountStringResId = additionCount > 1 ?
                R.string.additions_count_pr : R.string.addition_count_pr;
        String additionCountString = mContext.getString(additionCountStringResId, additionCount);
        pullRequestViewHolder.additionCount.setText(additionCountString);

        int deletionCount = payload.getPullRequest().getDeletionCount();
        int deletionCountStringResId = deletionCount > 1 ?
                R.string.deletions_count_pr : R.string.deletion_count_pr;
        String deletionCountString = mContext.getString(deletionCountStringResId, deletionCount);
        pullRequestViewHolder.deletionCount.setText(deletionCountString);
    }

    private void setGollumItemView(GollumNewsViewHolder gollumNewsViewHolder, EventResponse event,
                                   int position) {
        SpannableString spannableString = mGollumSpannableMap.get(position);
        if (spannableString != null) {
            gollumNewsViewHolder.description.setText(spannableString);
            return;
        }

        GollumEventPayloadResponse payload = (GollumEventPayloadResponse) event.getPayload();

        PageResponse page = payload.getPages().get(0);
        String pageName = page.getPageName();
        String action = StringUtil.capitalizeFirst(page.getAction());

        String gollumEventPayloadString = String.format("%s %s", action, pageName);
        mSpannableBuilder.clear();
        mSpannableBuilder.append(gollumEventPayloadString);

        addSpans(gollumEventPayloadString, pageName);

        SpannableString newSpannable = SpannableString.valueOf(mSpannableBuilder);
        mGollumSpannableMap.put(position, newSpannable);
        gollumNewsViewHolder.description.setText(newSpannable);
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
        addSpans(payloadString, String.format("#%s", number));

        return SpannableString.valueOf(mSpannableBuilder);
    }

    private SpannableString getGollumPayloadSpannable(EventResponse event) {
        String actorName = event.getActor().getLogin();
        String repoName = event.getRepo().getName();

        String payloadString = mContext.getString(R.string.payload_gollum, actorName, repoName);
        mSpannableBuilder.clear();
        mSpannableBuilder.append(payloadString);

        addSpans(payloadString, actorName);
        addSpans(payloadString, repoName);

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
