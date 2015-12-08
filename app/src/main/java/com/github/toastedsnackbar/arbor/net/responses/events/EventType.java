package com.github.toastedsnackbar.arbor.net.responses.events;

import com.google.gson.annotations.SerializedName;

public enum EventType {

    @SerializedName("CommitCommentEvent")
    COMMIT_COMMENT("CommitCommentEvent"),

    @SerializedName("CreateEvent")
    CREATE("CreateEvent"),

    @SerializedName("DeleteEvent")
    DELETE("DeleteEvent"),

    @SerializedName("DownloadEvent")
    DOWNLOAD("DownloadEvent"),

    @SerializedName("FollowEvent")
    FOLLOW("FollowEvent"),

    @SerializedName("ForkEvent")
    FORK("ForkEvent"),

    @SerializedName("ForkApplyEvent")
    FORK_APPLY("ForkApplyEvent"),

    @SerializedName("GistEvent")
    GIST("GistEvent"),

    @SerializedName("GollumEvent")
    GOLLUM("GollumEvent"),

    @SerializedName("IssueCommentEvent")
    ISSUE_COMMENT("IssueCommentEvent"),

    @SerializedName("IssuesEvent")
    ISSUES("IssuesEvent"),

    @SerializedName("MemberEvent")
    MEMBER("MemberEvent"),

    @SerializedName("PublicEvent")
    PUBLIC("PublicEvent"),

    @SerializedName("PullRequestEvent")
    PULL_REQUEST("PullRequestEvent"),

    @SerializedName("PullRequestReviewCommentEvent")
    PULL_REQUEST_REVIEW_COMMENT("PullRequestReviewCommentEvent"),

    @SerializedName("PushEvent")
    PUSH("PushEvent"),

    @SerializedName("TeamAddEvent")
    TEAM_ADD("TeamAddEvent"),

    @SerializedName("WatchEvent")
    WATCH("WatchEvent");

    public String name;

    EventType(String name) {
        this.name = name;
    }
}
