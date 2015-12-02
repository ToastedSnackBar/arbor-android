package com.github.toastedsnackbar.arbor.net.responses;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class RepositoryResponse extends ApiResponse {

    @SerializedName("id")
    private int repoID;

    @SerializedName("name")
    private String name;

    @SerializedName("full_name")
    private String full_name;

    @SerializedName("owner")
    private OwnerResponse owner;

    @SerializedName("private")
    private boolean isPrivate;

    @SerializedName("html_url")
    private String html_url;

    @SerializedName("description")
    private String description;

    @SerializedName("fork")
    private boolean hasFork;

    @SerializedName("url")
    private String url;

    @SerializedName("forks_url")
    private String forks_url;

    @SerializedName("keys_url")
    private String keys_url;

    @SerializedName("collaborators_url")
    private String collaborators_url;

    @SerializedName("teams_url")
    private String teams_url;

    @SerializedName("hooks_url")
    private String hooks_url;

    @SerializedName("issue_events_url")
    private String issue_events_url;

    @SerializedName("events_url")
    private String events_url;

    @SerializedName("assignees_url")
    private String assignees_url;

    @SerializedName("branches_url")
    private String branches_url;

    @SerializedName("tags_url")
    private String tags_url;

    @SerializedName("blobs_url")
    private String blobs_url;

    @SerializedName("git_tags_url")
    private String git_tags_url;

    @SerializedName("git_refs_url")
    private String git_refs_url;

    @SerializedName("trees_url")
    private String trees_url;

    @SerializedName("statuses_url")
    private String statuses_url;

    @SerializedName("languages_url")
    private String languages_url;

    @SerializedName("stargazers_url")
    private String stargazers_url;

    @SerializedName("contributors_url")
    private String contributors_url;

    @SerializedName("subscribers_url")
    private String subscribers_url;

    @SerializedName("subscription_url")
    private String subscription_url;

    @SerializedName("commits_url")
    private String commits_url;

    @SerializedName("git_commits_url")
    private String git_commits_url;

    @SerializedName("comments_url")
    private String comments_url;

    @SerializedName("issue_comment_url")
    private String issue_comment_url;

    @SerializedName("contents_url")
    private String contents_url;

    @SerializedName("compare_url")
    private String compare_url;

    @SerializedName("merges_url")
    private String merges_url;

    @SerializedName("archive_url")
    private String archive_url;

    @SerializedName("downloads_url")
    private String downloads_url;

    @SerializedName("issues_url")
    private String issues_url;

    @SerializedName("pulls_url")
    private String pulls_url;

    @SerializedName("milestones_url")
    private String milestones_url;

    @SerializedName("notifications_url")
    private String notifications_url;

    @SerializedName("labels_url")
    private String labels_url;

    @SerializedName("releases_url")
    private String releases_url;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("pushed_at")
    private String pushed_at;

    @SerializedName("git_url")
    private String git_url;

    @SerializedName("ssh_url")
    private String ssh_url;

    @SerializedName("clone_url")
    private String clone_url;

    @SerializedName("svn_url")
    private String svn_url;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("size")
    private int size;

    @SerializedName("stargazers_count")
    private int stargazers_count;

    @SerializedName("watchers_count")
    private int watchers_count;

    @SerializedName("language")
    private String repoLanguage;

    @SerializedName("has_issues")
    private boolean has_issues;

    @SerializedName("has_downloads")
    private boolean has_downloads;

    @SerializedName("has_wiki")
    private boolean has_wiki;

    @SerializedName("has_pages")
    private boolean has_pages;

    @SerializedName("forks_count")
    private int forks_count;

    @SerializedName("mirror_url")
    private String mirror_url;

    @SerializedName("open_issues_count")
    private int open_issues_count;

    @SerializedName("forks")
    private int forks;

    @SerializedName("open_issues")
    private int open_issues;

    @SerializedName("watchers")
    private int watchers;

    @SerializedName("default_branch")
    private String default_branch;

    public RepositoryResponse(Parcel source) {
        super(source);

        repoID = source.readInt();
        name = source.readString();
        full_name = source.readString();
        owner = source.readParcelable(getClass().getClassLoader());
        isPrivate = source.readByte() != 0;
        html_url = source.readString();
        description = source.readString();
        hasFork = source.readByte() != 0;
        url = source.readString();
        forks_url = source.readString();
        keys_url = source.readString();
        collaborators_url = source.readString();
        teams_url = source.readString();
        hooks_url = source.readString();
        issue_events_url = source.readString();
        events_url = source.readString();
        assignees_url = source.readString();
        branches_url = source.readString();
        tags_url = source.readString();
        blobs_url = source.readString();
        git_tags_url = source.readString();
        git_refs_url = source.readString();
        trees_url = source.readString();
        statuses_url = source.readString();
        languages_url = source.readString();
        stargazers_url = source.readString();
        contributors_url = source.readString();
        subscribers_url = source.readString();
        subscription_url = source.readString();
        commits_url = source.readString();
        git_commits_url = source.readString();
        comments_url = source.readString();
        issue_comment_url = source.readString();
        contents_url = source.readString();
        compare_url = source.readString();
        merges_url = source.readString();
        archive_url = source.readString();
        downloads_url = source.readString();
        issues_url = source.readString();
        pulls_url = source.readString();
        milestones_url = source.readString();
        notifications_url = source.readString();
        labels_url = source.readString();
        releases_url = source.readString();
        created_at = source.readString();
        updated_at = source.readString();
        pushed_at = source.readString();
        git_url = source.readString();
        ssh_url = source.readString();
        clone_url = source.readString();
        svn_url = source.readString();
        homepage = source.readString();
        size = source.readInt();
        stargazers_count = source.readInt();
        watchers_count = source.readInt();
        repoLanguage = source.readString();
        has_issues = source.readByte() != 0;
        has_downloads = source.readByte() != 0;
        has_wiki = source.readByte() != 0;
        has_pages = source.readByte() != 0;
        forks_count = source.readInt();
        mirror_url = source.readString();
        open_issues_count = source.readInt();
        forks = source.readInt();
        open_issues = source.readInt();
        watchers = source.readInt();
        default_branch = source.readString();
    }

    public int getRepoID() {
        return repoID;
    }

    public void setRepoID(int repoID) {
        this.repoID = repoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public OwnerResponse getOwner() {
        return owner;
    }

    public void setOwner(OwnerResponse owner) {
        this.owner = owner;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getHasFork() {
        return hasFork;
    }

    public void setHasFork(boolean hasFork) {
        this.hasFork = hasFork;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForks_url() {
        return forks_url;
    }

    public void setForks_url(String forks_url) {
        this.forks_url = forks_url;
    }

    public String getKeys_url() {
        return keys_url;
    }

    public void setKeys_url(String keys_url) {
        this.keys_url = keys_url;
    }

    public String getCollaborators_url() {
        return collaborators_url;
    }

    public void setCollaborators_url(String collaborators_url) {
        this.collaborators_url = collaborators_url;
    }

    public String getTeams_url() {
        return teams_url;
    }

    public void setTeams_url(String teams_url) {
        this.teams_url = teams_url;
    }

    public String getHooks_url() {
        return hooks_url;
    }

    public void setHooks_url(String hooks_url) {
        this.hooks_url = hooks_url;
    }

    public String getIssue_events_url() {
        return issue_events_url;
    }

    public void setIssue_events_url(String issue_events_url) {
        this.issue_events_url = issue_events_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public String getAssignees_url() {
        return assignees_url;
    }

    public void setAssignees_url(String assignees_url) {
        this.assignees_url = assignees_url;
    }

    public String getBranches_url() {
        return branches_url;
    }

    public void setBranches_url(String branches_url) {
        this.branches_url = branches_url;
    }

    public String getTags_url() {
        return tags_url;
    }

    public void setTags_url(String tags_url) {
        this.tags_url = tags_url;
    }

    public String getBlobs_url() {
        return blobs_url;
    }

    public void setBlobs_url(String blobs_url) {
        this.blobs_url = blobs_url;
    }

    public String getGit_tags_url() {
        return git_tags_url;
    }

    public void setGit_tags_url(String git_tags_url) {
        this.git_tags_url = git_tags_url;
    }

    public String getGit_refs_url() {
        return git_refs_url;
    }

    public void setGit_refs_url(String git_refs_url) {
        this.git_refs_url = git_refs_url;
    }

    public String getTrees_url() {
        return trees_url;
    }

    public void setTrees_url(String trees_url) {
        this.trees_url = trees_url;
    }

    public String getStatuses_url() {
        return statuses_url;
    }

    public void setStatuses_url(String statuses_url) {
        this.statuses_url = statuses_url;
    }

    public String getLanguages_url() {
        return languages_url;
    }

    public void setLanguages_url(String languages_url) {
        this.languages_url = languages_url;
    }

    public String getStargazers_url() {
        return stargazers_url;
    }

    public void setStargazers_url(String stargazers_url) {
        this.stargazers_url = stargazers_url;
    }

    public String getContributors_url() {
        return contributors_url;
    }

    public void setContributors_url(String contributors_url) {
        this.contributors_url = contributors_url;
    }

    public String getSubscribers_url() {
        return subscribers_url;
    }

    public void setSubscribers_url(String subscribers_url) {
        this.subscribers_url = subscribers_url;
    }

    public String getSubscription_url() {
        return subscription_url;
    }

    public void setSubscription_url(String subscription_url) {
        this.subscription_url = subscription_url;
    }

    public String getCommits_url() {
        return commits_url;
    }

    public void setCommits_url(String commits_url) {
        this.commits_url = commits_url;
    }

    public String getGit_commits_url() {
        return git_commits_url;
    }

    public void setGit_commits_url(String git_commits_url) {
        this.git_commits_url = git_commits_url;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public String getIssue_comment_url() {
        return issue_comment_url;
    }

    public void setIssue_comment_url(String issue_comment_url) {
        this.issue_comment_url = issue_comment_url;
    }

    public String getContents_url() {
        return contents_url;
    }

    public void setContents_url(String contents_url) {
        this.contents_url = contents_url;
    }

    public String getCompare_url() {
        return compare_url;
    }

    public void setCompare_url(String compare_url) {
        this.compare_url = compare_url;
    }

    public String getMerges_url() {
        return merges_url;
    }

    public void setMerges_url(String merges_url) {
        this.merges_url = merges_url;
    }

    public String getArchive_url() {
        return archive_url;
    }

    public void setArchive_url(String archive_url) {
        this.archive_url = archive_url;
    }

    public String getDownloads_url() {
        return downloads_url;
    }

    public void setDownloads_url(String downloads_url) {
        this.downloads_url = downloads_url;
    }

    public String getIssues_url() {
        return issues_url;
    }

    public void setIssues_url(String issues_url) {
        this.issues_url = issues_url;
    }

    public String getPulls_url() {
        return pulls_url;
    }

    public void setPulls_url(String pulls_url) {
        this.pulls_url = pulls_url;
    }

    public String getMilestones_url() {
        return milestones_url;
    }

    public void setMilestones_url(String milestones_url) {
        this.milestones_url = milestones_url;
    }

    public String getNotifications_url() {
        return notifications_url;
    }

    public void setNotifications_url(String notifications_url) {
        this.notifications_url = notifications_url;
    }

    public String getLabels_url() {
        return labels_url;
    }

    public void setLabels_url(String labels_url) {
        this.labels_url = labels_url;
    }

    public String getReleases_url() {
        return releases_url;
    }

    public void setReleases_url(String releases_url) {
        this.releases_url = releases_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPushed_at() {
        return pushed_at;
    }

    public void setPushed_at(String pushed_at) {
        this.pushed_at = pushed_at;
    }

    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public String getSsh_url() {
        return ssh_url;
    }

    public void setSsh_url(String ssh_url) {
        this.ssh_url = ssh_url;
    }

    public String getClone_url() {
        return clone_url;
    }

    public void setClone_url(String clone_url) {
        this.clone_url = clone_url;
    }

    public String getSvn_url() {
        return svn_url;
    }

    public void setSvn_url(String svn_url) {
        this.svn_url = svn_url;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public int getWatchers_count() {
        return watchers_count;
    }

    public void setWatchers_count(int watchers_count) {
        this.watchers_count = watchers_count;
    }

    public String getRepoLanguage() {
        return repoLanguage;
    }

    public void setRepoLanguage(String repoLanguage) {
        this.repoLanguage = repoLanguage;
    }

    public boolean getHas_issues() {
        return has_issues;
    }

    public void setHas_issues(boolean has_issues) {
        this.has_issues = has_issues;
    }

    public boolean getHas_downloads() {
        return has_downloads;
    }

    public void setHas_downloads(boolean has_downloads) {
        this.has_downloads = has_downloads;
    }

    public boolean getHas_wiki() {
        return has_wiki;
    }

    public void setHas_wiki(boolean has_wiki) {
        this.has_wiki = has_wiki;
    }

    public boolean getHas_pages() {
        return has_pages;
    }

    public void setHas_pages(boolean has_pages) {
        this.has_pages = has_pages;
    }

    public int getForks_count() {
        return forks_count;
    }

    public void setForks_count(int forks_count) {
        this.forks_count = forks_count;
    }

    public String getMirror_url() {
        return mirror_url;
    }

    public void setMirror_url(String mirror_url) {
        this.mirror_url = mirror_url;
    }

    public int getOpen_issues_count() {
        return open_issues_count;
    }

    public void setOpen_issues_count(int open_issues_count) {
        this.open_issues_count = open_issues_count;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public void setOpen_issues(int open_issues) {
        this.open_issues = open_issues;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public String getDefault_branch() {
        return default_branch;
    }

    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
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

        dest.writeInt(repoID);
        dest.writeString(name);
        dest.writeString(full_name);
        dest.writeParcelable(owner, flags);
        dest.writeByte((byte) (isPrivate ? 1 : 0));
        dest.writeString(html_url);
        dest.writeString(description);
        dest.writeByte((byte) (hasFork ? 1 : 0));
        dest.writeString(url);
        dest.writeString(forks_url);
        dest.writeString(keys_url);
        dest.writeString(collaborators_url);
        dest.writeString(teams_url);
        dest.writeString(hooks_url);
        dest.writeString(issue_events_url);
        dest.writeString(events_url);
        dest.writeString(assignees_url);
        dest.writeString(branches_url);
        dest.writeString(tags_url);
        dest.writeString(blobs_url);
        dest.writeString(git_tags_url);
        dest.writeString(git_refs_url);
        dest.writeString(trees_url);
        dest.writeString(statuses_url);
        dest.writeString(languages_url);
        dest.writeString(stargazers_url);
        dest.writeString(contributors_url);
        dest.writeString(subscribers_url);
        dest.writeString(subscription_url);
        dest.writeString(commits_url);
        dest.writeString(git_commits_url);
        dest.writeString(comments_url);
        dest.writeString(issue_comment_url);
        dest.writeString(contents_url);
        dest.writeString(compare_url);
        dest.writeString(merges_url);
        dest.writeString(archive_url);
        dest.writeString(downloads_url);
        dest.writeString(issues_url);
        dest.writeString(pulls_url);
        dest.writeString(milestones_url);
        dest.writeString(notifications_url);
        dest.writeString(labels_url);
        dest.writeString(releases_url);
        dest.writeString(created_at);
        dest.writeString(updated_at);
        dest.writeString(pushed_at);
        dest.writeString(git_url);
        dest.writeString(ssh_url);
        dest.writeString(clone_url);
        dest.writeString(svn_url);
        dest.writeString(homepage);
        dest.writeInt(size);
        dest.writeInt(stargazers_count);
        dest.writeInt(watchers_count);
        dest.writeString(repoLanguage);
        dest.writeByte((byte) (has_issues ? 1 : 0));
        dest.writeByte((byte) (has_downloads ? 1 : 0));
        dest.writeByte((byte) (has_wiki ? 1 : 0));
        dest.writeByte((byte) (has_pages ? 1 : 0));
        dest.writeInt(forks_count);
        dest.writeString(mirror_url);
        dest.writeInt(open_issues_count);
        dest.writeInt(forks);
        dest.writeInt(open_issues);
        dest.writeInt(watchers);
        dest.writeString(default_branch);
    }
}