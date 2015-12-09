package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class PullRequestResponse extends ApiResponse {

    @SerializedName("id")
    private long mId;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("html_url")
    private String mHtmlUrl;

    @SerializedName("diff_url")
    private String mDiffUrl;

    @SerializedName("patch_url")
    private String mPatchUrl;

    @SerializedName("issue_url")
    private String mIssueUrl;

    @SerializedName("commits_url")
    private String mCommitsUrl;

    @SerializedName("review_comments_url")
    private String mReviewCommentsUrl;

    @SerializedName("review_comment_url")
    private String mReviewCommentUrl;

    @SerializedName("comments_url")
    private String mCommentsUrl;

    @SerializedName("statuses_url")
    private String mStatusesUrl;

    @SerializedName("number")
    private int mNumber;

    @SerializedName("state")
    private String mState;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("body")
    private String mBody;

    @SerializedName("assignee")
    private UserResponse mAssignee;

    @SerializedName("milestone")
    private MilestoneResponse mMilestone;

    @SerializedName("locked")
    private boolean mIsLocked;

    @SerializedName("created_at")
    private String mCreatedAt;

    @SerializedName("updated_at")
    private String mUpdatedAt;

    @SerializedName("closed_at")
    private String mClosedAt;

    @SerializedName("merged_at")
    private String mMergedAt;

    @SerializedName("head")
    private BranchResponse mHead;

    @SerializedName("base")
    private BranchResponse mBase;

    @SerializedName("user")
    private UserResponse mUser;

    @SerializedName("merge_commit_sha")
    private String mMergeCommitSha;

    @SerializedName("merged")
    private boolean mIsMerged;

    @SerializedName("mergeable")
    private boolean mIsMergeable;

    @SerializedName("merged_by")
    private UserResponse mMergedBy;

    @SerializedName("comments")
    private int mCommentCount;

    @SerializedName("commits")
    private int mCommitCount;

    @SerializedName("additions")
    private int mAdditionCount;

    @SerializedName("deletions")
    private int mDeletionCount;

    @SerializedName("changed_files")
    private int mChangedFileCount;

    public PullRequestResponse(Parcel source) {
        super(source);

        mId = source.readLong();
        mUrl = source.readString();
        mHtmlUrl = source.readString();
        mDiffUrl = source.readString();
        mPatchUrl = source.readString();
        mIssueUrl = source.readString();
        mCommitsUrl = source.readString();
        mReviewCommentsUrl = source.readString();
        mReviewCommentUrl = source.readString();
        mCommentsUrl = source.readString();
        mStatusesUrl = source.readString();
        mNumber = source.readInt();
        mState = source.readString();
        mTitle = source.readString();
        mBody = source.readString();
        mAssignee = source.readParcelable(getClass().getClassLoader());
        mMilestone = source.readParcelable(getClass().getClassLoader());
        mIsLocked = source.readByte() != 0;
        mCreatedAt = source.readString();
        mUpdatedAt = source.readString();
        mClosedAt = source.readString();
        mMergedAt = source.readString();
        mHead = source.readParcelable(getClass().getClassLoader());
        mBase = source.readParcelable(getClass().getClassLoader());
        mUser = source.readParcelable(getClass().getClassLoader());
        mMergeCommitSha = source.readString();
        mIsMerged = source.readByte() != 0;
        mIsMergeable = source.readByte() != 0;
        mMergedBy = source.readParcelable(getClass().getClassLoader());
        mCommentCount = source.readInt();
        mCommitCount = source.readInt();
        mAdditionCount = source.readInt();
        mDeletionCount = source.readInt();
        mChangedFileCount = source.readInt();
    }

    public long getId() {
        return mId;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public String getDiffUrl() {
        return mDiffUrl;
    }

    public String getPatchUrl() {
        return mPatchUrl;
    }

    public String getIssueUrl() {
        return mIssueUrl;
    }

    public String getCommitsUrl() {
        return mCommitsUrl;
    }

    public String getReviewCommentsUrl() {
        return mReviewCommentsUrl;
    }

    public String getReviewCommentUrl() {
        return mReviewCommentUrl;
    }

    public String getCommentsUrl() {
        return mCommentsUrl;
    }

    public String getStatusesUrl() {
        return mStatusesUrl;
    }

    public int getNumber() {
        return mNumber;
    }

    public String getState() {
        return mState;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getBody() {
        return mBody;
    }

    public UserResponse getAssignee() {
        return mAssignee;
    }

    public MilestoneResponse getMilestone() {
        return mMilestone;
    }

    public boolean isLocked() {
        return mIsLocked;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public String getClosedAt() {
        return mClosedAt;
    }

    public String getMergedAt() {
        return mMergedAt;
    }

    public BranchResponse getHead() {
        return mHead;
    }

    public BranchResponse getBase() {
        return mBase;
    }

    public UserResponse getUser() {
        return mUser;
    }

    public String getMergeCommitSha() {
        return mMergeCommitSha;
    }

    public boolean isMerged() {
        return mIsMerged;
    }

    public boolean isMergeable() {
        return mIsMergeable;
    }

    public UserResponse getMergedBy() {
        return mMergedBy;
    }

    public int getCommentCount() {
        return mCommentCount;
    }

    public int getCommitCount() {
        return mCommitCount;
    }

    public int getAdditionCount() {
        return mAdditionCount;
    }

    public int getDeletionCount() {
        return mDeletionCount;
    }

    public int getChangedFileCount() {
        return mChangedFileCount;
    }

    public static final Creator<PullRequestResponse> CREATOR = new Creator<PullRequestResponse>() {

        @Override
        public PullRequestResponse createFromParcel(Parcel source) {
            return new PullRequestResponse(source);
        }

        @Override
        public PullRequestResponse[] newArray(int size) {
            return new PullRequestResponse[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeLong(mId);
        dest.writeString(mUrl);
        dest.writeString(mHtmlUrl);
        dest.writeString(mDiffUrl);
        dest.writeString(mPatchUrl);
        dest.writeString(mIssueUrl);
        dest.writeString(mCommitsUrl);
        dest.writeString(mReviewCommentsUrl);
        dest.writeString(mReviewCommentUrl);
        dest.writeString(mCommentsUrl);
        dest.writeString(mStatusesUrl);
        dest.writeInt(mNumber);
        dest.writeString(mState);
        dest.writeString(mTitle);
        dest.writeString(mBody);
        dest.writeParcelable(mAssignee, 0);
        dest.writeParcelable(mMilestone, 0);
        dest.writeByte((byte) (mIsLocked ? 1 : 0));
        dest.writeString(mCreatedAt);
        dest.writeString(mUpdatedAt);
        dest.writeString(mClosedAt);
        dest.writeString(mMergedAt);
        dest.writeParcelable(mHead, 0);
        dest.writeParcelable(mBase, 0);
        dest.writeParcelable(mUser, 0);
        dest.writeString(mMergeCommitSha);
        dest.writeByte((byte) (mIsMerged ? 1 : 0));
        dest.writeByte((byte) (mIsMergeable ? 1 : 0));
        dest.writeParcelable(mMergedBy, 0);
        dest.writeInt(mCommentCount);
        dest.writeInt(mCommitCount);
        dest.writeInt(mAdditionCount);
        dest.writeInt(mDeletionCount);
        dest.writeInt(mChangedFileCount);
    }
}
