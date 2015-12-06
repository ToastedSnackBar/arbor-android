package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class RepositoryResponse extends ApiResponse {

    @SerializedName("id")
    private int mRepoId;

    @SerializedName("name")
    private String mName;

    @SerializedName("full_name")
    private String mFullName;

    @SerializedName("owner")
    private OwnerResponse mOwner;

    @SerializedName("private")
    private boolean mIsPrivate;

    @SerializedName("html_url")
    private String mHtmlUrl;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("fork")
    private boolean mHasFork;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("forks_url")
    private String mForksUrl;

    @SerializedName("keys_url")
    private String mKeysUrl;

    @SerializedName("collaborators_url")
    private String mCollaboratorsUrl;

    @SerializedName("teams_url")
    private String mTeamsUrl;

    @SerializedName("hooks_url")
    private String mHooksUrl;

    @SerializedName("issue_events_url")
    private String mIssueEventsUrl;

    @SerializedName("events_url")
    private String mEventsUrl;

    @SerializedName("assignees_url")
    private String mAssigneesUrl;

    @SerializedName("branches_url")
    private String mBranchesUrl;

    @SerializedName("tags_url")
    private String mTagsUrl;

    @SerializedName("blobs_url")
    private String mBlobsUrl;

    @SerializedName("git_tags_url")
    private String mGitTagsUrl;

    @SerializedName("git_refs_url")
    private String mGitRefsUrl;

    @SerializedName("trees_url")
    private String mTreesUrl;

    @SerializedName("statuses_url")
    private String mStatusesUrl;

    @SerializedName("languages_url")
    private String mLanguagesUrl;

    @SerializedName("stargazers_url")
    private String mStargazersUrl;

    @SerializedName("contributors_url")
    private String mContributorsUrl;

    @SerializedName("subscribers_url")
    private String mSubscribersUrl;

    @SerializedName("subscription_url")
    private String mSubscriptionUrl;

    @SerializedName("commits_url")
    private String mCommitsUrl;

    @SerializedName("git_commits_url")
    private String mGitCommitsUrl;

    @SerializedName("comments_url")
    private String mCommentsUrl;

    @SerializedName("issue_comment_url")
    private String mIssueCommentUrl;

    @SerializedName("contents_url")
    private String mContentsUrl;

    @SerializedName("compare_url")
    private String mCompareUrl;

    @SerializedName("merges_url")
    private String mMergesUrl;

    @SerializedName("archive_url")
    private String mArchiveUrl;

    @SerializedName("downloads_url")
    private String mDownloadsUrl;

    @SerializedName("issues_url")
    private String mIssuesUrl;

    @SerializedName("pulls_url")
    private String mPullsUrl;

    @SerializedName("milestones_url")
    private String mMilestonesUrl;

    @SerializedName("notifications_url")
    private String mNotificationsUrl;

    @SerializedName("labels_url")
    private String mLabelsUrl;

    @SerializedName("releases_url")
    private String mReleasesUrl;

    @SerializedName("created_at")
    private String mCreatedAt;

    @SerializedName("updated_at")
    private String mUpdatedAt;

    @SerializedName("pushed_at")
    private String mPushedAt;

    @SerializedName("git_url")
    private String mGitUrl;

    @SerializedName("ssh_url")
    private String mSshUrl;

    @SerializedName("clone_url")
    private String mCloneUrl;

    @SerializedName("svn_url")
    private String mSvnUrl;

    @SerializedName("homepage")
    private String mHomepage;

    @SerializedName("size")
    private int mSize;

    @SerializedName("stargazers_count")
    private int mStargazersCount;

    @SerializedName("watchers_count")
    private int mWatchersCount;

    @SerializedName("language")
    private String mRepoLanguage;

    @SerializedName("has_issues")
    private boolean mHasIssues;

    @SerializedName("has_downloads")
    private boolean mHasDownloads;

    @SerializedName("has_wiki")
    private boolean mHasWiki;

    @SerializedName("has_pages")
    private boolean mHasPages;

    @SerializedName("forks_count")
    private int mForksCount;

    @SerializedName("mirror_url")
    private String mMirrorUrl;

    @SerializedName("open_issues_count")
    private int mOpenIssuesCount;

    @SerializedName("forks")
    private int mForks;

    @SerializedName("open_issues")
    private int mOpenIssues;

    @SerializedName("watchers")
    private int mWatchers;

    @SerializedName("default_branch")
    private String mDefaultBranch;

    public RepositoryResponse(Parcel source) {
        super(source);

        mRepoId = source.readInt();
        mName = source.readString();
        mFullName = source.readString();
        mOwner = source.readParcelable(getClass().getClassLoader());
        mIsPrivate = source.readByte() != 0;
        mHtmlUrl = source.readString();
        mDescription = source.readString();
        mHasFork = source.readByte() != 0;
        mUrl = source.readString();
        mForksUrl = source.readString();
        mKeysUrl = source.readString();
        mCollaboratorsUrl = source.readString();
        mTeamsUrl = source.readString();
        mHooksUrl = source.readString();
        mIssueEventsUrl = source.readString();
        mEventsUrl = source.readString();
        mAssigneesUrl = source.readString();
        mBranchesUrl = source.readString();
        mTagsUrl = source.readString();
        mBlobsUrl = source.readString();
        mGitTagsUrl = source.readString();
        mGitRefsUrl = source.readString();
        mTreesUrl = source.readString();
        mStatusesUrl = source.readString();
        mLanguagesUrl = source.readString();
        mStargazersUrl = source.readString();
        mContributorsUrl = source.readString();
        mSubscribersUrl = source.readString();
        mSubscriptionUrl = source.readString();
        mCommitsUrl = source.readString();
        mGitCommitsUrl = source.readString();
        mCommentsUrl = source.readString();
        mIssueCommentUrl = source.readString();
        mContentsUrl = source.readString();
        mCompareUrl = source.readString();
        mMergesUrl = source.readString();
        mArchiveUrl = source.readString();
        mDownloadsUrl = source.readString();
        mIssuesUrl = source.readString();
        mPullsUrl = source.readString();
        mMilestonesUrl = source.readString();
        mNotificationsUrl = source.readString();
        mLabelsUrl = source.readString();
        mReleasesUrl = source.readString();
        mCreatedAt = source.readString();
        mUpdatedAt = source.readString();
        mPushedAt = source.readString();
        mGitUrl = source.readString();
        mSshUrl = source.readString();
        mCloneUrl = source.readString();
        mSvnUrl = source.readString();
        mHomepage = source.readString();
        mSize = source.readInt();
        mStargazersCount = source.readInt();
        mWatchersCount = source.readInt();
        mRepoLanguage = source.readString();
        mHasIssues = source.readByte() != 0;
        mHasDownloads = source.readByte() != 0;
        mHasWiki = source.readByte() != 0;
        mHasPages = source.readByte() != 0;
        mForksCount = source.readInt();
        mMirrorUrl = source.readString();
        mOpenIssuesCount = source.readInt();
        mForks = source.readInt();
        mOpenIssues = source.readInt();
        mWatchers = source.readInt();
        mDefaultBranch = source.readString();
    }

    public String getName() {
        return mName;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public int getStargazersCount() {
        return mStargazersCount;
    }

    public int getWatchersCount() {
        return mWatchersCount;
    }

    public boolean isPrivate() {
        return mIsPrivate;
    }

    public String getRepoLanguage() {
        return mRepoLanguage;
    }

    public static final Creator<RepositoryResponse> CREATOR = new Creator<RepositoryResponse>() {

        @Override
        public RepositoryResponse createFromParcel(Parcel source) {
            return new RepositoryResponse(source);
        }

        @Override
        public RepositoryResponse[] newArray(int size) {
            return new RepositoryResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeInt(mRepoId);
        dest.writeString(mName);
        dest.writeString(mFullName);
        dest.writeParcelable(mOwner, flags);
        dest.writeByte((byte) (mIsPrivate ? 1 : 0));
        dest.writeString(mHtmlUrl);
        dest.writeString(mDescription);
        dest.writeByte((byte) (mHasFork ? 1 : 0));
        dest.writeString(mUrl);
        dest.writeString(mForksUrl);
        dest.writeString(mKeysUrl);
        dest.writeString(mCollaboratorsUrl);
        dest.writeString(mTeamsUrl);
        dest.writeString(mHooksUrl);
        dest.writeString(mIssueEventsUrl);
        dest.writeString(mEventsUrl);
        dest.writeString(mAssigneesUrl);
        dest.writeString(mBranchesUrl);
        dest.writeString(mTagsUrl);
        dest.writeString(mBlobsUrl);
        dest.writeString(mGitTagsUrl);
        dest.writeString(mGitRefsUrl);
        dest.writeString(mTreesUrl);
        dest.writeString(mStatusesUrl);
        dest.writeString(mLanguagesUrl);
        dest.writeString(mStargazersUrl);
        dest.writeString(mContributorsUrl);
        dest.writeString(mSubscribersUrl);
        dest.writeString(mSubscriptionUrl);
        dest.writeString(mCommitsUrl);
        dest.writeString(mGitCommitsUrl);
        dest.writeString(mCommentsUrl);
        dest.writeString(mIssueCommentUrl);
        dest.writeString(mContentsUrl);
        dest.writeString(mCompareUrl);
        dest.writeString(mMergesUrl);
        dest.writeString(mArchiveUrl);
        dest.writeString(mDownloadsUrl);
        dest.writeString(mIssuesUrl);
        dest.writeString(mPullsUrl);
        dest.writeString(mMilestonesUrl);
        dest.writeString(mNotificationsUrl);
        dest.writeString(mLabelsUrl);
        dest.writeString(mReleasesUrl);
        dest.writeString(mCreatedAt);
        dest.writeString(mUpdatedAt);
        dest.writeString(mPushedAt);
        dest.writeString(mGitUrl);
        dest.writeString(mSshUrl);
        dest.writeString(mCloneUrl);
        dest.writeString(mSvnUrl);
        dest.writeString(mHomepage);
        dest.writeInt(mSize);
        dest.writeInt(mStargazersCount);
        dest.writeInt(mWatchersCount);
        dest.writeString(mRepoLanguage);
        dest.writeByte((byte) (mHasIssues ? 1 : 0));
        dest.writeByte((byte) (mHasDownloads ? 1 : 0));
        dest.writeByte((byte) (mHasWiki ? 1 : 0));
        dest.writeByte((byte) (mHasPages ? 1 : 0));
        dest.writeInt(mForksCount);
        dest.writeString(mMirrorUrl);
        dest.writeInt(mOpenIssuesCount);
        dest.writeInt(mForks);
        dest.writeInt(mOpenIssues);
        dest.writeInt(mWatchers);
        dest.writeString(mDefaultBranch);
    }
}