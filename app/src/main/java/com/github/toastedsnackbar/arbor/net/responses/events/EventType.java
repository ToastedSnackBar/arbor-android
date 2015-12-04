package com.github.toastedsnackbar.arbor.net.responses.events;

import com.google.gson.annotations.SerializedName;

public enum EventType {
    @SerializedName("CommitCommentEvent")
    COMMIT_COMMENT,

    @SerializedName("CreateEvent")
    CREATE,

    @SerializedName("DeleteEvent")
    DELETE,

    @SerializedName("DownloadEvent")
    DOWNLOAD,

    @SerializedName("FollowEvent")
    FOLLOW,

    @SerializedName("ForkEvent")
    FORK,

    @SerializedName("ForkApplyEvent")
    FORK_APPLY,

    @SerializedName("GistEvent")
    GIST,

    @SerializedName("GollumEvent")
    GOLLUM,

    @SerializedName("IssueCommentEvent")
    ISSUE_COMMENT,

    @SerializedName("IssuesEvent")
    ISSUES,

    @SerializedName("MemberEvent")
    MEMBER,

    @SerializedName("PublicEvent")
    PUBLIC,

    @SerializedName("PullRequestEvent")
    PULL_REQUEST,

    @SerializedName("PullRequestReviewCommentEvent")
    PULL_REQUEST_REVIEW_COMMENT,

    @SerializedName("PushEvent")
    PUSH,

    @SerializedName("TeamAddEvent")
    TEAM_ADD,

    @SerializedName("WatchEvent")
    WATCH
}
