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

import com.bumptech.glide.Glide;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
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

    private StringBuilder mStringBuilder;
    private SpannableStringBuilder mSpannableBuilder;

    private Map<Integer, SpannableString> mPayloadSpannableMap;
    private Map<Integer, SpannableString> mGollumSpannableMap;
    private Map<Integer, SpannableString> mPushSpannableMap;

    public NewsAdapter(Context context) {
        mContext = context;
        mItems = new ArrayList<>();

        mSpannableBuilder = new SpannableStringBuilder();
        mStringBuilder = new StringBuilder();

        mPayloadSpannableMap = new LinkedHashMap<>();
        mGollumSpannableMap = new LinkedHashMap<>();
        mPushSpannableMap = new LinkedHashMap<>();
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
                setPushItemView((PushNewsViewHolder) newsViewHolder, event, position);
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

        Glide.with(mContext).load(avatarUrl).override(100, 100).centerCrop().crossFade(500)
                .into(newsViewHolder.avatarView);
    }

    private void setPushItemView(PushNewsViewHolder pushViewHolder, EventResponse event,
                                 int position) {
        PushEventPayloadResponse payload = (PushEventPayloadResponse) event.getPayload();
        List<CommitResponse> commits = payload.getCommits();

        // commits list empty: show new location of branch head
        if (commits == null || commits.isEmpty()) {
            SpannableString noCommitSpannable = mPushSpannableMap.get(position);
            if (noCommitSpannable == null) {
                String head = payload.getHead().substring(0, 7);
                String noCommitStr = mContext.getString(R.string.push_no_commits, head);

                mSpannableBuilder.clear();
                mSpannableBuilder.append(noCommitStr);

                addSpans(noCommitStr, head, false);
                noCommitSpannable = SpannableString.valueOf(mSpannableBuilder);
                mPushSpannableMap.put(position, noCommitSpannable);
            }
            pushViewHolder.commitMsg1.setText(noCommitSpannable);

            pushViewHolder.commitMsg1.setVisibility(View.VISIBLE);
            pushViewHolder.commit2.setVisibility(View.GONE);
            pushViewHolder.commitCount.setVisibility(View.GONE);
            pushViewHolder.commitSum1.setVisibility(View.GONE);
        } else {
            CommitResponse firstCommit = commits.get(0);

            // 1st commit is always shown
            String commitSum1 = firstCommit.getSha();
            pushViewHolder.commitSum1.setText(commitSum1);
            pushViewHolder.commitSum1.setVisibility(View.VISIBLE);

            String commitMsg1 = firstCommit.getMessage();
            pushViewHolder.commitMsg1.setText(commitMsg1);

            if (commits.size() >= 2) { // at least 2 commits (show everything)
                CommitResponse secondCommit = commits.get(1);
                String commitSum2 = secondCommit.getSha();
                pushViewHolder.commitSum2.setText(commitSum2);

                String commitMsg2 = secondCommit.getMessage();
                pushViewHolder.commitMsg2.setText(commitMsg2);

                if (commits.size() > 2) {
                    int commitCount = commits.size() - 2;
                    int commitCountResId = commitCount > 1 ?
                            R.string.commits_count : R.string.commit_count;
                    String commitCountString = mContext.getString(commitCountResId);

                    mStringBuilder.setLength(0);
                    mStringBuilder.append(commitCount);
                    mStringBuilder.append(" ");
                    mStringBuilder.append(commitCountString);

                    pushViewHolder.commitCount.setText(mStringBuilder);
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
        String commitCountString = mContext.getString(commitCountStringResId);

        mStringBuilder.setLength(0);
        mStringBuilder.append(commitCount);
        mStringBuilder.append(" ");
        mStringBuilder.append(commitCountString);
        pullRequestViewHolder.commitCount.setText(mStringBuilder);

        int additionCount = payload.getPullRequest().getAdditionCount();
        int additionCountStringResId = additionCount > 1 ?
                R.string.line_count_pr : R.string.lines_count_pr;
        String additionCountString = mContext.getString(additionCountStringResId);

        mStringBuilder.setLength(0);
        mStringBuilder.append("+");
        mStringBuilder.append(additionCount);
        mStringBuilder.append(" ");
        mStringBuilder.append(additionCountString);
        pullRequestViewHolder.additionCount.setText(mStringBuilder);

        int deletionCount = payload.getPullRequest().getDeletionCount();
        int deletionCountStringResId = deletionCount > 1 ?
                R.string.line_count_pr : R.string.lines_count_pr;
        String deletionCountString = mContext.getString(deletionCountStringResId);

        // -{deletionCount} lines
        mStringBuilder.setLength(0);
        mStringBuilder.append("-");
        mStringBuilder.append(deletionCount);
        mStringBuilder.append(" ");
        mStringBuilder.append(deletionCountString);
        pullRequestViewHolder.deletionCount.setText(mStringBuilder);
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

        // {action} {pageName}
        mStringBuilder.setLength(0);
        mStringBuilder.append(StringUtil.capitalizeFirst(action));
        mStringBuilder.append(" ");
        mStringBuilder.append(pageName);

        String gollumEventPayloadString = mStringBuilder.toString();
        mSpannableBuilder.clear();
        mSpannableBuilder.append(gollumEventPayloadString);

        addSpans(gollumEventPayloadString, pageName, false);

        SpannableString newSpannable = SpannableString.valueOf(mSpannableBuilder);
        mGollumSpannableMap.put(position, newSpannable);
        gollumNewsViewHolder.description.setText(newSpannable);
    }

    private SpannableString getPushPayloadSpannable(EventResponse event) {
        PushEventPayloadResponse payload = (PushEventPayloadResponse) event.getPayload();

        String actorName = event.getActor().getLogin();
        String repoName = event.getRepo().getName();
        String branchName = getBranchNameFromRef(payload.getRef());

        // {actorName} pushed to {branchName} at {repoName}
        mStringBuilder.setLength(0);
        mStringBuilder.append(actorName);
        mStringBuilder.append(" ");
        mStringBuilder.append(mContext.getString(R.string.pushed));
        mStringBuilder.append(" ");
        mStringBuilder.append(mContext.getString(R.string.to));
        mStringBuilder.append(" ");
        mStringBuilder.append(branchName);
        mStringBuilder.append(" ");
        mStringBuilder.append(mContext.getString(R.string.at));
        mStringBuilder.append(" ");
        mStringBuilder.append(repoName);
        String payloadString = mStringBuilder.toString();

        mSpannableBuilder.clear();
        mSpannableBuilder.append(payloadString);

        addSpans(payloadString, actorName, true);
        addSpans(payloadString, branchName, true);
        addSpans(payloadString, repoName, true);

        return SpannableString.valueOf(mSpannableBuilder);
    }

    private SpannableString getPullRequestPayloadSpannable(EventResponse event) {
        PullRequestEventPayloadResponse payload = (PullRequestEventPayloadResponse)
                event.getPayload();

        String actorName = event.getActor().getLogin();
        String action = payload.getPullRequest().isMerged() ?
                mContext.getString(R.string.merged) : payload.getAction();
        String repoName = event.getRepo().getName();
        String number = String.valueOf(payload.getNumber());

        // {actorName} {action} pull request {repoName}#{number}
        mStringBuilder.setLength(0);
        mStringBuilder.append(actorName);
        mStringBuilder.append(" ");
        mStringBuilder.append(action);
        mStringBuilder.append(" ");
        mStringBuilder.append(mContext.getString(R.string.pull_request));
        mStringBuilder.append(" ");
        mStringBuilder.append(repoName);
        mStringBuilder.append("#");
        mStringBuilder.append(number);
        String payloadString = mStringBuilder.toString();

        mSpannableBuilder.clear();
        mSpannableBuilder.append(payloadString);

        addSpans(payloadString, actorName, true);
        addSpans(payloadString, String.format("%s#%s", repoName, number), true);

        return SpannableString.valueOf(mSpannableBuilder);
    }

    private SpannableString getGollumPayloadSpannable(EventResponse event) {
        String actorName = event.getActor().getLogin();
        String repoName = event.getRepo().getName();

        mStringBuilder.setLength(0);
        mStringBuilder.append(actorName);
        mStringBuilder.append(" ");
        mStringBuilder.append(mContext.getString(R.string.updated_the));
        mStringBuilder.append(" ");
        mStringBuilder.append(repoName);
        mStringBuilder.append(" ");
        mStringBuilder.append(mContext.getString(R.string.wiki));
        String payloadString = mStringBuilder.toString();

        mSpannableBuilder.clear();
        mSpannableBuilder.append(payloadString);

        addSpans(payloadString, actorName, true);
        addSpans(payloadString, repoName, true);

        return SpannableString.valueOf(mSpannableBuilder);
    }

    private String getBranchNameFromRef(String ref) {
        String[] refPaths = ref.split("/");
        return refPaths[refPaths.length - 1];
    }

    private void addSpans(String fullString, String substring, boolean bold) {
        int start = fullString.indexOf(substring);
        int end = start + substring.length();

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(
                ContextCompat.getColor(mContext, R.color.accent));
        mSpannableBuilder.setSpan(colorSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        if (bold) {
            StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
            mSpannableBuilder.setSpan(boldSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
    }
}
