package com.github.toastedsnackbar.arbor;

public class ArborTestConstants {

    public static final class MockResponses {
        public static final String ACCESS_TOKEN =
                "{\n" +
                "  \"access_token\": \"mock_access_token\",\n" +
                "  \"token_type\": \"mock_token_type\",\n" +
                "  \"scope\": \"mock_scope\"\n" +
                "}";

        public static final String REPOSITORY_LIST =
                "  [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"coding-challenge\",\n" +
                "      \"full_name\": \"okamayana\\/coding-challenge\",\n" +
                "      \"owner\": {\n" +
                "        \"login\": \"okamayana\",\n" +
                "        \"id\": 3643607,\n" +
                "        \"avatar_url\": \"https:\\/\\/avatars.githubusercontent" +
                ".com\\/u\\/3643607?v=3\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https:\\/\\/api.github.com\\/users\\/okamayana\",\n" +
                "        \"html_url\": \"https:\\/\\/github.com\\/okamayana\",\n" +
                "        \"followers_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/followers\",\n" +
                "        \"following_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/following{\\/other_user}\",\n" +
                "        \"gists_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/gists{\\/gist_id}\",\n" +
                "        \"starred_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/starred{\\/owner}{\\/repo}\",\n" +
                "        \"subscriptions_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/subscriptions\",\n" +
                "        \"organizations_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/orgs\",\n" +
                "        \"repos_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/repos\",\n" +
                "        \"events_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/events{\\/privacy}\",\n" +
                "        \"received_events_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"private\": false,\n" +
                "      \"html_url\": \"https:\\/\\/github" +
                ".com\\/okamayana\\/coding-challenge\",\n" +
                "      \"description\": \"\",\n" +
                "      \"fork\": false,\n" +
                "      \"url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\",\n" +
                "      \"forks_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/forks\",\n" +
                "      \"keys_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/keys{\\/key_id}\",\n" +
                "      \"collaborators_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/collaborators{\\/collaborator" +
                
                "}\",\n" +
                "      \"teams_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/teams\",\n" +
                "      \"hooks_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/hooks\",\n" +
                "      \"issue_events_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/issues\\/events{\\/number" +
                "}\"," +
                "\n" +
                "      \"events_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/events\",\n" +
                "      \"assignees_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/assignees{\\/user}\",\n" +
                "      \"branches_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/branches{\\/branch}\",\n" +
                "      \"tags_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/tags\",\n" +
                "      \"blobs_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/blobs{\\/sha}\",\n" +
                "      \"git_tags_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/tags{\\/sha}\",\n" +
                "      \"git_refs_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/refs{\\/sha}\",\n" +
                "      \"trees_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/trees{\\/sha}\",\n" +
                "      \"statuses_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/statuses\\/{sha}\",\n" +
                "      \"languages_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/languages\",\n" +
                "      \"stargazers_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/stargazers\",\n" +
                "      \"contributors_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/contributors\",\n" +
                "      \"subscribers_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/subscribers\",\n" +
                "      \"subscription_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/subscription\",\n" +
                "      \"commits_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/commits{\\/sha}\",\n" +
                "      \"git_commits_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/commits{\\/sha}\",\n" +
                "      \"comments_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/comments{\\/number}\",\n" +
                "      \"issue_comment_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/issues\\/comments" +
                "{\\/number" +
                "}\",\n" +
                "      \"contents_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/contents\\/{+path}\",\n" +
                "      \"compare_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/compare\\/{base}...{head}\",\n" +
                "      \"merges_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/merges\",\n" +
                "      \"archive_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/{archive_format}{\\/ref}\",\n" +
                "      \"downloads_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/downloads\",\n" +
                "      \"issues_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/issues{\\/number}\",\n" +
                "      \"pulls_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/pulls{\\/number}\",\n" +
                "      \"milestones_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/milestones{\\/number}\",\n" +
                "      \"notifications_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/notifications{?since,all," +
                "participating}\",\n" +
                "      \"labels_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/labels{\\/name}\",\n" +
                "      \"releases_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/releases{\\/id}\",\n" +
                "      \"created_at\": \"2014-04-26T04:30:57Z\",\n" +
                "      \"updated_at\": \"2014-07-31T14:52:31Z\",\n" +
                "      \"pushed_at\": \"2014-04-28T05:53:00Z\",\n" +
                "      \"git_url\": \"git:\\/\\/github.com\\/okamayana\\/coding-challenge" +
                ".git\",\n" +
                "      \"ssh_url\": \"git@github.com:okamayana\\/coding-challenge.git\",\n" +
                "      \"clone_url\": \"https:\\/\\/github.com\\/okamayana\\/coding-challenge" +
                ".git\",\n" +
                "      \"svn_url\": \"https:\\/\\/github" +
                ".com\\/okamayana\\/coding-challenge\",\n" +
                "      \"homepage\": \"\",\n" +
                "      \"size\": 404,\n" +
                "      \"stargazers_count\": 0,\n" +
                "      \"watchers_count\": 0,\n" +
                "      \"language\": \"Java\",\n" +
                "      \"has_issues\": false,\n" +
                "      \"has_downloads\": true,\n" +
                "      \"has_wiki\": true,\n" +
                "      \"has_pages\": false,\n" +
                "      \"forks_count\": 0,\n" +
                "      \"mirror_url\": null,\n" +
                "      \"open_issues_count\": 0,\n" +
                "      \"forks\": 0,\n" +
                "      \"open_issues\": 0,\n" +
                "      \"watchers\": 0,\n" +
                "      \"default_branch\": \"master\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 26778640,\n" +
                "      \"name\": \"ece358-lab2\",\n" +
                "      \"full_name\": \"okamayana\\/ece358-lab2\",\n" +
                "      \"owner\": {\n" +
                "        \"login\": \"okamayana\",\n" +
                "        \"id\": 3643607,\n" +
                "        \"avatar_url\": \"https:\\/\\/avatars.githubusercontent" +
                ".com\\/u\\/3643607?v=3\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https:\\/\\/api.github.com\\/users\\/okamayana\",\n" +
                "        \"html_url\": \"https:\\/\\/github.com\\/okamayana\",\n" +
                "        \"followers_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/followers\",\n" +
                "        \"following_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/following{\\/other_user}\",\n" +
                "        \"gists_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/gists{\\/gist_id}\",\n" +
                "        \"starred_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/starred{\\/owner}{\\/repo}\",\n" +
                "        \"subscriptions_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/subscriptions\",\n" +
                "        \"organizations_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/orgs\",\n" +
                "        \"repos_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/repos\",\n" +
                "        \"events_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/events{\\/privacy}\",\n" +
                "        \"received_events_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"private\": false,\n" +
                "      \"html_url\": \"https:\\/\\/github.com\\/okamayana\\/ece358-lab2" +
                "\",\n" +
                "      \"description\": \"\",\n" +
                "      \"fork\": false,\n" +
                "      \"url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\",\n" +
                "      \"forks_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/forks\",\n" +
                "      \"keys_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/keys{\\/key_id}\",\n" +
                "      \"collaborators_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/collaborators{\\/collaborator}\",\n" +
                "      \"teams_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/teams\",\n" +
                "      \"hooks_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/hooks\",\n" +
                "      \"issue_events_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/issues\\/events{\\/number}\",\n" +
                "      \"events_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/events\",\n" +
                "      \"assignees_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/assignees{\\/user}\",\n" +
                "      \"branches_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/branches{\\/branch}\",\n" +
                "      \"tags_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/tags\",\n" +
                "      \"blobs_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/git\\/blobs{\\/sha}\",\n" +
                "      \"git_tags_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/git\\/tags{\\/sha}\",\n" +
                "      \"git_refs_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/git\\/refs{\\/sha}\",\n" +
                "      \"trees_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/git\\/trees{\\/sha}\",\n" +
                "      \"statuses_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/statuses\\/{sha}\",\n" +
                "      \"languages_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/languages\",\n" +
                "      \"stargazers_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/stargazers\",\n" +
                "      \"contributors_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/contributors\",\n" +
                "      \"subscribers_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/subscribers\",\n" +
                "      \"subscription_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/subscription\",\n" +
                "      \"commits_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/commits{\\/sha}\",\n" +
                "      \"git_commits_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/git\\/commits{\\/sha}\",\n" +
                "      \"comments_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/comments{\\/number}\",\n" +
                "      \"issue_comment_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/issues\\/comments{\\/number}\",\n" +
                "      \"contents_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/contents\\/{+path}\",\n" +
                "      \"compare_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/compare\\/{base}...{head}\",\n" +
                "      \"merges_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/merges\",\n" +
                "      \"archive_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/{archive_format}{\\/ref}\",\n" +
                "      \"downloads_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/downloads\",\n" +
                "      \"issues_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/issues{\\/number}\",\n" +
                "      \"pulls_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/pulls{\\/number}\",\n" +
                "      \"milestones_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/milestones{\\/number}\",\n" +
                "      \"notifications_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/notifications{?since,all," +
                "participating}\",\n" +
                "      \"labels_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/labels{\\/name}\",\n" +
                "      \"releases_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/ece358-lab2\\/releases{\\/id}\",\n" +
                "      \"created_at\": \"2014-11-17T21:42:08Z\",\n" +
                "      \"updated_at\": \"2014-11-17T21:47:40Z\",\n" +
                "      \"pushed_at\": \"2014-11-17T21:47:40Z\",\n" +
                "      \"git_url\": \"git:\\/\\/github.com\\/okamayana\\/ece358-lab2" +
                ".git\",\n" +
                "      \"ssh_url\": \"git@github.com:okamayana\\/ece358-lab2.git\",\n" +
                "      \"clone_url\": \"https:\\/\\/github.com\\/okamayana\\/ece358-lab2" +
                ".git\",\n" +
                "      \"svn_url\": \"https:\\/\\/github.com\\/okamayana\\/ece358-lab2\",\n" +
                "      \"homepage\": null,\n" +
                "      \"size\": 108,\n" +
                "      \"stargazers_count\": 0,\n" +
                "      \"watchers_count\": 0,\n" +
                "      \"language\": \"Java\",\n" +
                "      \"has_issues\": true,\n" +
                "      \"has_downloads\": true,\n" +
                "      \"has_wiki\": true,\n" +
                "      \"has_pages\": false,\n" +
                "      \"forks_count\": 0,\n" +
                "      \"mirror_url\": null,\n" +
                "      \"open_issues_count\": 0,\n" +
                "      \"forks\": 0,\n" +
                "      \"open_issues\": 0,\n" +
                "      \"watchers\": 0,\n" +
                "      \"default_branch\": \"master\"\n" +
                "    }\n" +
                "  ]\n";

        public static final String REPOSITORY =
                "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"coding-challenge\",\n" +
                "  \"full_name\": \"okamayana\\/coding-challenge\",\n" +
                "  \"owner\": {\n" +
                "    \"login\": \"okamayana\",\n" +
                "    \"id\": 3643607,\n" +
                "    \"avatar_url\": \"https:\\/\\/avatars.githubusercontent" +
                ".com\\/u\\/3643607?v=3\",\n" +
                "    \"gravatar_id\": \"\",\n" +
                "    \"url\": \"https:\\/\\/api.github.com\\/users\\/okamayana\",\n" +
                "    \"html_url\": \"https:\\/\\/github.com\\/okamayana\",\n" +
                "    \"followers_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/followers\",\n" +
                "    \"following_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/following{\\/other_user}\",\n" +
                "    \"gists_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/gists{\\/gist_id}\",\n" +
                "    \"starred_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/starred{\\/owner}{\\/repo}\",\n" +
                "    \"subscriptions_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/subscriptions\",\n" +
                "    \"organizations_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/orgs\",\n" +
                "    \"repos_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/repos\",\n" +
                "    \"events_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/events{\\/privacy}\",\n" +
                "    \"received_events_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/received_events\",\n" +
                "    \"type\": \"User\",\n" +
                "    \"site_admin\": false\n" +
                "  },\n" +
                "  \"private\": false,\n" +
                "  \"html_url\": \"https:\\/\\/github.com\\/okamayana\\/coding-challenge\",\n" +
                "  \"description\": \"\",\n" +
                "  \"fork\": false,\n" +
                "  \"url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\",\n" +
                "  \"forks_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/forks\",\n" +
                "  \"keys_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/keys{\\/key_id}\",\n" +
                "  \"collaborators_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/collaborators{\\/collaborator" +
                "}\",\n" +
                "  \"teams_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/teams\",\n" +
                "  \"hooks_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/hooks\",\n" +
                "  \"issue_events_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/issues\\/events{\\/number}\"," +
                "\n" +
                "  \"events_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/events\",\n" +
                "  \"assignees_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/assignees{\\/user}\",\n" +
                "  \"branches_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/branches{\\/branch}\",\n" +
                "  \"tags_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/tags\",\n" +
                "  \"blobs_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/blobs{\\/sha}\",\n" +
                "  \"git_tags_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/tags{\\/sha}\",\n" +
                "  \"git_refs_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/refs{\\/sha}\",\n" +
                "  \"trees_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/trees{\\/sha}\",\n" +
                "  \"statuses_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/statuses\\/{sha}\",\n" +
                "  \"languages_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/languages\",\n" +
                "  \"stargazers_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/stargazers\",\n" +
                "  \"contributors_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/contributors\",\n" +
                "  \"subscribers_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/subscribers\",\n" +
                "  \"subscription_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/subscription\",\n" +
                "  \"commits_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/commits{\\/sha}\",\n" +
                "  \"git_commits_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/git\\/commits{\\/sha}\",\n" +
                "  \"comments_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/comments{\\/number}\",\n" +
                "  \"issue_comment_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/issues\\/comments{\\/number" +
                "}\",\n" +
                "  \"contents_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/contents\\/{+path}\",\n" +
                "  \"compare_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/compare\\/{base}...{head}\",\n" +
                "  \"merges_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/merges\",\n" +
                "  \"archive_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/{archive_format}{\\/ref}\",\n" +
                "  \"downloads_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/downloads\",\n" +
                "  \"issues_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/issues{\\/number}\",\n" +
                "  \"pulls_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/pulls{\\/number}\",\n" +
                "  \"milestones_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/milestones{\\/number}\",\n" +
                "  \"notifications_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/notifications{?since,all," +
                "participating}\",\n" +
                "  \"labels_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/labels{\\/name}\",\n" +
                "  \"releases_url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/okamayana\\/coding-challenge\\/releases{\\/id}\",\n" +
                "  \"created_at\": \"2014-04-26T04:30:57Z\",\n" +
                "  \"updated_at\": \"2014-07-31T14:52:31Z\",\n" +
                "  \"pushed_at\": \"2014-04-28T05:53:00Z\",\n" +
                "  \"git_url\": \"git:\\/\\/github.com\\/okamayana\\/coding-challenge.git" +
                "\"," +
                "\n" +
                "  \"ssh_url\": \"git@github.com:okamayana\\/coding-challenge.git\",\n" +
                "  \"clone_url\": \"https:\\/\\/github.com\\/okamayana\\/coding-challenge" +
                ".git\",\n" +
                "  \"svn_url\": \"https:\\/\\/github.com\\/okamayana\\/coding-challenge" +
                "\",\n" +
                "  \"homepage\": \"\",\n" +
                "  \"size\": 404,\n" +
                "  \"stargazers_count\": 0,\n" +
                "  \"watchers_count\": 0,\n" +
                "  \"language\": \"Java\",\n" +
                "  \"has_issues\": false,\n" +
                "  \"has_downloads\": true,\n" +
                "  \"has_wiki\": true,\n" +
                "  \"has_pages\": false,\n" +
                "  \"forks_count\": 0,\n" +
                "  \"mirror_url\": null,\n" +
                "  \"open_issues_count\": 0,\n" +
                "  \"forks\": 0,\n" +
                "  \"open_issues\": 0,\n" +
                "  \"watchers\": 0,\n" +
                "  \"default_branch\": \"master\"\n" +
                "}";

        public static final String OWNER =
                "{\n" +
                "  \"login\": \"okamayana\",\n" +
                "  \"id\": 3643607,\n" +
                "  \"avatar_url\": \"https:\\/\\/avatars.githubusercontent" +
                ".com\\/u\\/3643607?v=3\",\n" +
                "  \"gravatar_id\": \"\",\n" +
                "  \"url\": \"https:\\/\\/api.github.com\\/users\\/okamayana\",\n" +
                "  \"html_url\": \"https:\\/\\/github.com\\/okamayana\",\n" +
                "  \"followers_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/followers\",\n" +
                "  \"following_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/following{\\/other_user}\",\n" +
                "  \"gists_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/gists{\\/gist_id}\",\n" +
                "  \"starred_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/starred{\\/owner}{\\/repo}\",\n" +
                "  \"subscriptions_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/subscriptions\",\n" +
                "  \"organizations_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/orgs\",\n" +
                "  \"repos_url\": \"https:\\/\\/api.github.com\\/users\\/okamayana" +
                "\\/repos\"," +
                "\n" +
                "  \"events_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/events{\\/privacy}\",\n" +
                "  \"received_events_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/okamayana\\/received_events\",\n" +
                "  \"type\": \"User\",\n" +
                "  \"site_admin\": false\n" +
                "}";

        public static final String ACTOR =
                "{\n" +
                "  \"id\": 1,\n" +
                "  \"login\": \"login\",\n" +
                "  \"gravatar_id\": \"gravatar_id\",\n" +
                "  \"url\": \"url\",\n" +
                "  \"avatar_url\": \"avatar_url\"\n" +
                "}";

        public static final String REPO =
                "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"name\",\n" +
                "  \"url\": \"url\"\n" +
                "}";

        public static final String AUTHOR =
                "{\n" +
                "  \"email\": \"email\",\n" +
                "  \"name\": \"name\"\n" +
                "}";

        public static final String COMMIT =
                "{\n" +
                "  \"sha\": \"sha\",\n" +
                "  \"author\": {\n" +
                "    \"email\": \"email\",\n" +
                "    \"name\": \"name\"\n" +
                "  },\n" +
                "  \"message\": \"message\",\n" +
                "  \"distinct\": true,\n" +
                "  \"url\": \"url\"\n" +
                "}";

        public static final String ORGANIZATION =
                "{\n" +
                "  \"id\": 1,\n" +
                "  \"login\": \"login\",\n" +
                "  \"gravatar_id\": \"gravatar_id\",\n" +
                "  \"url\": \"url\",\n" +
                "  \"avatar_url\": \"avatar_url\"\n" +
                "}";

        public static final String PLAN =
                "{\n" +
                "  \"name\": \"name\",\n" +
                "  \"space\": 1,\n" +
                "  \"private_repos\": 1,\n" +
                "  \"collaborators\": 1\n" +
                "}";

        public static final String AUTH_USER =
                "{\n" +
                "  \"login\": \"login\",\n" +
                "  \"id\": 1,\n" +
                "  \"avatar_url\": \"avatar_url\",\n" +
                "  \"gravatar_id\": \"gravatar_id\",\n" +
                "  \"url\": \"url\",\n" +
                "  \"html_url\": \"html_url\",\n" +
                "  \"followers_url\": \"followers_url\",\n" +
                "  \"following_url\": \"following_url\",\n" +
                "  \"gists_url\": \"gists_url\",\n" +
                "  \"starred_url\": \"starred_url\",\n" +
                "  \"subscriptions_url\": \"subscriptions_url\",\n" +
                "  \"organizations_url\": \"organizations_url\",\n" +
                "  \"repos_url\": \"repos_url\",\n" +
                "  \"events_url\": \"events_url\",\n" +
                "  \"received_events_url\": \"received_events_url\",\n" +
                "  \"type\": \"type\",\n" +
                "  \"site_admin\": true,\n" +
                "  \"name\": \"name\",\n" +
                "  \"company\": \"company\",\n" +
                "  \"blog\": \"blog\",\n" +
                "  \"location\": \"location\",\n" +
                "  \"email\": \"email\",\n" +
                "  \"hireable\": true,\n" +
                "  \"bio\": \"bio\",\n" +
                "  \"public_repos\": 1,\n" +
                "  \"public_gists\": 2,\n" +
                "  \"followers\": 3,\n" +
                "  \"following\": 4,\n" +
                "  \"created_at\": \"created_at\",\n" +
                "  \"updated_at\": \"updated_at\",\n" +
                "  \"total_private_repos\": 5,\n" +
                "  \"owned_private_repos\": 6,\n" +
                "  \"private_gists\": 7,\n" +
                "  \"disk_usage\": 8,\n" +
                "  \"collaborators\": 9,\n" +
                "  \"plan\": {\n" +
                "    \"name\": \"name\",\n" +
                "    \"space\": 1,\n" +
                "    \"private_repos\": 1,\n" +
                "    \"collaborators\": 1\n" +
                "  }\n" +
                "}";

        public static final String MILESTONE =
                "{\n" +
                "  \"url\": \"url\",\n" +
                "  \"html_url\": \"html_url\",\n" +
                "  \"labels_url\": \"labels_url\",\n" +
                "  \"id\": 1,\n" +
                "  \"number\": 2,\n" +
                "  \"state\": \"state\",\n" +
                "  \"title\": \"title\",\n" +
                "  \"description\": \"description\",\n" +
                "  \"creator\": {\n" +
                "    \"login\": \"login\",\n" +
                "    \"id\": 3,\n" +
                "    \"avatar_url\": \"avatar_url\",\n" +
                "    \"gravatar_id\": \"gravatar_id\",\n" +
                "    \"url\": \"url\",\n" +
                "    \"html_url\": \"html_url\",\n" +
                "    \"followers_url\": \"followers_url\",\n" +
                "    \"following_url\": \"following_url\",\n" +
                "    \"gists_url\": \"gists_url\",\n" +
                "    \"starred_url\": \"starred_url\",\n" +
                "    \"subscriptions_url\": \"subscriptions_url\",\n" +
                "    \"organizations_url\": \"organizations_url\",\n" +
                "    \"repos_url\": \"repos_url\",\n" +
                "    \"events_url\": \"events_url\",\n" +
                "    \"received_events_url\": \"received_events_url\",\n" +
                "    \"type\": \"type\",\n" +
                "    \"site_admin\": true\n" +
                "  },\n" +
                "  \"open_issues\": 4,\n" +
                "  \"closed_issues\": 5,\n" +
                "  \"created_at\": \"created_at\",\n" +
                "  \"updated_at\": \"updated_at\",\n" +
                "  \"closed_at\": \"closed_at\",\n" +
                "  \"due_on\": \"due_on\"\n" +
                "}";

        public static final String BRANCH =
                "{\n" +
                "  \"label\": \"label\",\n" +
                "  \"ref\": \"ref\",\n" +
                "  \"sha\": \"sha\",\n" +
                "  \"user\": {\n" +
                "    \"login\": \"octocat\",\n" +
                "    \"id\": 1,\n" +
                "    \"avatar_url\": \"https:\\/\\/github" +
                ".com\\/images\\/error\\/octocat_happy.gif\",\n" +
                "    \"gravatar_id\": \"\",\n" +
                "    \"url\": \"https:\\/\\/api.github.com\\/users\\/octocat\",\n" +
                "    \"html_url\": \"https:\\/\\/github.com\\/octocat\",\n" +
                "    \"followers_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/followers\",\n" +
                "    \"following_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/following{\\/other_user}\",\n" +
                "    \"gists_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/gists{\\/gist_id}\",\n" +
                "    \"starred_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/starred{\\/owner}{\\/repo}\",\n" +
                "    \"subscriptions_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/subscriptions\",\n" +
                "    \"organizations_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/orgs\",\n" +
                "    \"repos_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/repos\",\n" +
                "    \"events_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/events{\\/privacy}\",\n" +
                "    \"received_events_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/received_events\",\n" +
                "    \"type\": \"User\",\n" +
                "    \"site_admin\": false\n" +
                "  },\n" +
                "  \"repo\": {\n" +
                "    \"id\": 1296269,\n" +
                "    \"owner\": {\n" +
                "      \"login\": \"octocat\",\n" +
                "      \"id\": 1,\n" +
                "      \"avatar_url\": \"https:\\/\\/github" +
                ".com\\/images\\/error\\/octocat_happy.gif\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https:\\/\\/api.github.com\\/users\\/octocat\",\n" +
                "      \"html_url\": \"https:\\/\\/github.com\\/octocat\",\n" +
                "      \"followers_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/followers\",\n" +
                "      \"following_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/following{\\/other_user}\",\n" +
                "      \"gists_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/gists{\\/gist_id}\",\n" +
                "      \"starred_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/starred{\\/owner}{\\/repo}\",\n" +
                "      \"subscriptions_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/subscriptions\",\n" +
                "      \"organizations_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/orgs\",\n" +
                "      \"repos_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/repos\",\n" +
                "      \"events_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/events{\\/privacy}\",\n" +
                "      \"received_events_url\": \"https:\\/\\/api.github" +
                ".com\\/users\\/octocat\\/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"name\": \"Hello-World\",\n" +
                "    \"full_name\": \"octocat\\/Hello-World\",\n" +
                "    \"description\": \"This your first repo!\",\n" +
                "    \"private\": false,\n" +
                "    \"fork\": true,\n" +
                "    \"url\": \"https:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\",\n" +
                "    \"html_url\": \"https:\\/\\/github.com\\/octocat\\/Hello-World\",\n" +
                "    \"archive_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/{archive_format}{\\/ref}\",\n" +
                "    \"assignees_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/assignees{\\/user}\",\n" +
                "    \"blobs_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/git\\/blobs{\\/sha}\",\n" +
                "    \"branches_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/branches{\\/branch}\",\n" +
                "    \"clone_url\": \"https:\\/\\/github.com\\/octocat\\/Hello-World" +
                ".git\",\n" +
                "    \"collaborators_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/collaborators{\\/collaborator}\"," +
                "\n" +
                "    \"comments_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/comments{\\/number}\",\n" +
                "    \"commits_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/commits{\\/sha}\",\n" +
                "    \"compare_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/compare\\/{base}...{head}\",\n" +
                "    \"contents_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/contents\\/{+path}\",\n" +
                "    \"contributors_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/contributors\",\n" +
                "    \"downloads_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/downloads\",\n" +
                "    \"events_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/events\",\n" +
                "    \"forks_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/forks\",\n" +
                "    \"git_commits_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/git\\/commits{\\/sha}\",\n" +
                "    \"git_refs_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/git\\/refs{\\/sha}\",\n" +
                "    \"git_tags_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/git\\/tags{\\/sha}\",\n" +
                "    \"git_url\": \"git:github.com\\/octocat\\/Hello-World.git\",\n" +
                "    \"hooks_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/hooks\",\n" +
                "    \"issue_comment_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/issues\\/comments{\\/number}\",\n" +
                "    \"issue_events_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/issues\\/events{\\/number}\",\n" +
                "    \"issues_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/issues{\\/number}\",\n" +
                "    \"keys_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/keys{\\/key_id}\",\n" +
                "    \"labels_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/labels{\\/name}\",\n" +
                "    \"languages_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/languages\",\n" +
                "    \"merges_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/merges\",\n" +
                "    \"milestones_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/milestones{\\/number}\",\n" +
                "    \"mirror_url\": \"git:git.example.com\\/octocat\\/Hello-World\",\n" +
                "    \"notifications_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/notifications{?since, all, " +
                "participating}\",\n" +
                "    \"pulls_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/pulls{\\/number}\",\n" +
                "    \"releases_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/releases{\\/id}\",\n" +
                "    \"ssh_url\": \"git@github.com:octocat\\/Hello-World.git\",\n" +
                "    \"stargazers_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/stargazers\",\n" +
                "    \"statuses_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/statuses\\/{sha}\",\n" +
                "    \"subscribers_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/subscribers\",\n" +
                "    \"subscription_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/subscription\",\n" +
                "    \"svn_url\": \"https:\\/\\/svn.github.com\\/octocat\\/Hello-World\"," +
                "\n" +
                "    \"tags_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/tags\",\n" +
                "    \"teams_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/teams\",\n" +
                "    \"trees_url\": \"http:\\/\\/api.github" +
                ".com\\/repos\\/octocat\\/Hello-World\\/git\\/trees{\\/sha}\",\n" +
                "    \"homepage\": \"https:\\/\\/github.com\",\n" +
                "    \"language\": null,\n" +
                "    \"forks_count\": 9,\n" +
                "    \"stargazers_count\": 80,\n" +
                "    \"watchers_count\": 80,\n" +
                "    \"size\": 108,\n" +
                "    \"default_branch\": \"master\",\n" +
                "    \"open_issues_count\": 0,\n" +
                "    \"has_issues\": true,\n" +
                "    \"has_wiki\": true,\n" +
                "    \"has_pages\": false,\n" +
                "    \"has_downloads\": true,\n" +
                "    \"pushed_at\": \"2011-01-26T19:06:43Z\",\n" +
                "    \"created_at\": \"2011-01-26T19:01:12Z\",\n" +
                "    \"updated_at\": \"2011-01-26T19:14:43Z\",\n" +
                "    \"permissions\": {\n" +
                "      \"admin\": false,\n" +
                "      \"push\": false,\n" +
                "      \"pull\": true\n" +
                "    }\n" +
                "  }\n" +
                "}";

        public static final String PULL_REQUEST =
                "{\n" +
                "  \"id\": 1,\n" +
                "  \"url\": \"url\",\n" +
                "  \"html_url\": \"html_url\",\n" +
                "  \"diff_url\": \"diff_url\",\n" +
                "  \"patch_url\": \"patch_url\",\n" +
                "  \"issue_url\": \"issue_url\",\n" +
                "  \"commits_url\": \"commits_url\",\n" +
                "  \"review_comments_url\": \"review_comments_url\",\n" +
                "  \"review_comment_url\": \"review_comment_url\",\n" +
                "  \"comments_url\": \"comments_url\",\n" +
                "  \"statuses_url\": \"statuses_url\",\n" +
                "  \"number\": 2,\n" +
                "  \"state\": \"state\",\n" +
                "  \"title\": \"title\",\n" +
                "  \"body\": \"body\",\n" +
                "  \"assignee\": {\n" +
                "    \"login\": \"octocat\",\n" +
                "    \"id\": 1,\n" +
                "    \"avatar_url\": \"https://github.com/images/error/octocat_happy" +
                ".gif\",\n" +
                "    \"gravatar_id\": \"\",\n" +
                "    \"url\": \"https://api.github.com/users/octocat\",\n" +
                "    \"html_url\": \"https://github.com/octocat\",\n" +
                "    \"followers_url\": \"https://api.github" +
                ".com/users/octocat/followers\",\n" +
                "    \"following_url\": \"https://api.github" +
                ".com/users/octocat/following{/other_user}\",\n" +
                "    \"gists_url\": \"https://api.github" +
                ".com/users/octocat/gists{/gist_id}\",\n" +
                "    \"starred_url\": \"https://api.github" +
                ".com/users/octocat/starred{/owner}{/repo}\",\n" +
                "    \"subscriptions_url\": \"https://api.github" +
                ".com/users/octocat/subscriptions\",\n" +
                "    \"organizations_url\": \"https://api.github" +
                ".com/users/octocat/orgs\",\n" +
                "    \"repos_url\": \"https://api.github.com/users/octocat/repos\",\n" +
                "    \"events_url\": \"https://api.github" +
                ".com/users/octocat/events{/privacy}\",\n" +
                "    \"received_events_url\": \"https://api.github" +
                ".com/users/octocat/received_events\",\n" +
                "    \"type\": \"User\",\n" +
                "    \"site_admin\": false\n" +
                "  },\n" +
                "  \"milestone\": {\n" +
                "    \"url\": \"https://api.github" +
                ".com/repos/octocat/Hello-World/milestones/1\",\n" +
                "    \"html_url\": \"https://github.com/octocat/Hello-World/milestones/v1" +
                ".0\",\n" +
                "    \"labels_url\": \"https://api.github" +
                ".com/repos/octocat/Hello-World/milestones/1/labels\",\n" +
                "    \"id\": 1002604,\n" +
                "    \"number\": 1,\n" +
                "    \"state\": \"open\",\n" +
                "    \"title\": \"v1.0\",\n" +
                "    \"description\": \"Tracking milestone for version 1.0\",\n" +
                "    \"creator\": {\n" +
                "      \"login\": \"octocat\",\n" +
                "      \"id\": 1,\n" +
                "      \"avatar_url\": \"https://github.com/images/error/octocat_happy" +
                ".gif\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/octocat\",\n" +
                "      \"html_url\": \"https://github.com/octocat\",\n" +
                "      \"followers_url\": \"https://api.github" +
                ".com/users/octocat/followers\",\n" +
                "      \"following_url\": \"https://api.github" +
                ".com/users/octocat/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github" +
                ".com/users/octocat/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github" +
                ".com/users/octocat/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github" +
                ".com/users/octocat/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github" +
                ".com/users/octocat/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/octocat/repos\",\n" +
                "      \"events_url\": \"https://api.github" +
                ".com/users/octocat/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github" +
                ".com/users/octocat/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"open_issues\": 4,\n" +
                "    \"closed_issues\": 8,\n" +
                "    \"created_at\": \"2011-04-10T20:09:31Z\",\n" +
                "    \"updated_at\": \"2014-03-03T18:58:10Z\",\n" +
                "    \"closed_at\": \"2013-02-12T13:22:01Z\",\n" +
                "    \"due_on\": \"2012-10-09T23:39:01Z\"\n" +
                "  },\n" +
                "  \"locked\": true,\n" +
                "  \"created_at\": \"created_at\",\n" +
                "  \"updated_at\": \"updated_at\",\n" +
                "  \"closed_at\": \"closed_at\",\n" +
                "  \"merged_at\": \"merged_at\",\n" +
                "  \"head\": {\n" +
                "    \"label\": \"new-topic\",\n" +
                "    \"ref\": \"new-topic\",\n" +
                "    \"sha\": \"6dcb09b5b57875f334f61aebed695e2e4193db5e\",\n" +
                "    \"user\": {\n" +
                "      \"login\": \"octocat\",\n" +
                "      \"id\": 1,\n" +
                "      \"avatar_url\": \"https://github.com/images/error/octocat_happy" +
                ".gif\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/octocat\",\n" +
                "      \"html_url\": \"https://github.com/octocat\",\n" +
                "      \"followers_url\": \"https://api.github" +
                ".com/users/octocat/followers\",\n" +
                "      \"following_url\": \"https://api.github" +
                ".com/users/octocat/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github" +
                ".com/users/octocat/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github" +
                ".com/users/octocat/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github" +
                ".com/users/octocat/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github" +
                ".com/users/octocat/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/octocat/repos\",\n" +
                "      \"events_url\": \"https://api.github" +
                ".com/users/octocat/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github" +
                ".com/users/octocat/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"repo\": {\n" +
                "      \"id\": 1296269,\n" +
                "      \"owner\": {\n" +
                "        \"login\": \"octocat\",\n" +
                "        \"id\": 1,\n" +
                "        \"avatar_url\": \"https://github.com/images/error/octocat_happy" +
                ".gif\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/octocat\",\n" +
                "        \"html_url\": \"https://github.com/octocat\",\n" +
                "        \"followers_url\": \"https://api.github" +
                ".com/users/octocat/followers\",\n" +
                "        \"following_url\": \"https://api.github" +
                ".com/users/octocat/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github" +
                ".com/users/octocat/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github" +
                ".com/users/octocat/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github" +
                ".com/users/octocat/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github" +
                ".com/users/octocat/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/octocat/repos\",\n" +
                "        \"events_url\": \"https://api.github" +
                ".com/users/octocat/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github" +
                ".com/users/octocat/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"name\": \"Hello-World\",\n" +
                "      \"full_name\": \"octocat/Hello-World\",\n" +
                "      \"description\": \"This your first repo!\",\n" +
                "      \"private\": false,\n" +
                "      \"fork\": true,\n" +
                "      \"url\": \"https://api.github.com/repos/octocat/Hello-World\",\n" +
                "      \"html_url\": \"https://github.com/octocat/Hello-World\",\n" +
                "      \"archive_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/{archive_format}{/ref}\",\n" +
                "      \"assignees_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/assignees{/user}\",\n" +
                "      \"blobs_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/git/blobs{/sha}\",\n" +
                "      \"branches_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/branches{/branch}\",\n" +
                "      \"clone_url\": \"https://github.com/octocat/Hello-World.git\",\n" +
                "      \"collaborators_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/collaborators{/collaborator}\",\n" +
                "      \"comments_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/comments{/number}\",\n" +
                "      \"commits_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/commits{/sha}\",\n" +
                "      \"compare_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/compare/{base}...{head}\",\n" +
                "      \"contents_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/contents/{+path}\",\n" +
                "      \"contributors_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/contributors\",\n" +
                "      \"downloads_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/downloads\",\n" +
                "      \"events_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/events\",\n" +
                "      \"forks_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/forks\",\n" +
                "      \"git_commits_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/git/commits{/sha}\",\n" +
                "      \"git_refs_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/git/refs{/sha}\",\n" +
                "      \"git_tags_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/git/tags{/sha}\",\n" +
                "      \"git_url\": \"git:github.com/octocat/Hello-World.git\",\n" +
                "      \"hooks_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/hooks\",\n" +
                "      \"issue_comment_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/issues/comments{/number}\",\n" +
                "      \"issue_events_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/issues/events{/number}\",\n" +
                "      \"issues_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/issues{/number}\",\n" +
                "      \"keys_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/keys{/key_id}\",\n" +
                "      \"labels_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/labels{/name}\",\n" +
                "      \"languages_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/languages\",\n" +
                "      \"merges_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/merges\",\n" +
                "      \"milestones_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/milestones{/number}\",\n" +
                "      \"mirror_url\": \"git:git.example.com/octocat/Hello-World\",\n" +
                "      \"notifications_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/notifications{?since, all, " +
                "participating}\",\n" +
                "      \"pulls_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/pulls{/number}\",\n" +
                "      \"releases_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/releases{/id}\",\n" +
                "      \"ssh_url\": \"git@github.com:octocat/Hello-World.git\",\n" +
                "      \"stargazers_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/stargazers\",\n" +
                "      \"statuses_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/statuses/{sha}\",\n" +
                "      \"subscribers_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/subscribers\",\n" +
                "      \"subscription_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/subscription\",\n" +
                "      \"svn_url\": \"https://svn.github.com/octocat/Hello-World\",\n" +
                "      \"tags_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/tags\",\n" +
                "      \"teams_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/teams\",\n" +
                "      \"trees_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/git/trees{/sha}\",\n" +
                "      \"homepage\": \"https://github.com\",\n" +
                "      \"language\": null,\n" +
                "      \"forks_count\": 9,\n" +
                "      \"stargazers_count\": 80,\n" +
                "      \"watchers_count\": 80,\n" +
                "      \"size\": 108,\n" +
                "      \"default_branch\": \"master\",\n" +
                "      \"open_issues_count\": 0,\n" +
                "      \"has_issues\": true,\n" +
                "      \"has_wiki\": true,\n" +
                "      \"has_pages\": false,\n" +
                "      \"has_downloads\": true,\n" +
                "      \"pushed_at\": \"2011-01-26T19:06:43Z\",\n" +
                "      \"created_at\": \"2011-01-26T19:01:12Z\",\n" +
                "      \"updated_at\": \"2011-01-26T19:14:43Z\",\n" +
                "      \"permissions\": {\n" +
                "        \"admin\": false,\n" +
                "        \"push\": false,\n" +
                "        \"pull\": true\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"base\": {\n" +
                "    \"label\": \"master\",\n" +
                "    \"ref\": \"master\",\n" +
                "    \"sha\": \"6dcb09b5b57875f334f61aebed695e2e4193db5e\",\n" +
                "    \"user\": {\n" +
                "      \"login\": \"octocat\",\n" +
                "      \"id\": 1,\n" +
                "      \"avatar_url\": \"https://github.com/images/error/octocat_happy" +
                ".gif\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/octocat\",\n" +
                "      \"html_url\": \"https://github.com/octocat\",\n" +
                "      \"followers_url\": \"https://api.github" +
                ".com/users/octocat/followers\",\n" +
                "      \"following_url\": \"https://api.github" +
                ".com/users/octocat/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github" +
                ".com/users/octocat/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github" +
                ".com/users/octocat/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github" +
                ".com/users/octocat/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github" +
                ".com/users/octocat/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/octocat/repos\",\n" +
                "      \"events_url\": \"https://api.github" +
                ".com/users/octocat/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github" +
                ".com/users/octocat/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"repo\": {\n" +
                "      \"id\": 1296269,\n" +
                "      \"owner\": {\n" +
                "        \"login\": \"octocat\",\n" +
                "        \"id\": 1,\n" +
                "        \"avatar_url\": \"https://github.com/images/error/octocat_happy" +
                ".gif\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/octocat\",\n" +
                "        \"html_url\": \"https://github.com/octocat\",\n" +
                "        \"followers_url\": \"https://api.github" +
                ".com/users/octocat/followers\",\n" +
                "        \"following_url\": \"https://api.github" +
                ".com/users/octocat/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github" +
                ".com/users/octocat/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github" +
                ".com/users/octocat/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github" +
                ".com/users/octocat/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github" +
                ".com/users/octocat/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/octocat/repos\",\n" +
                "        \"events_url\": \"https://api.github" +
                ".com/users/octocat/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github" +
                ".com/users/octocat/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"name\": \"Hello-World\",\n" +
                "      \"full_name\": \"octocat/Hello-World\",\n" +
                "      \"description\": \"This your first repo!\",\n" +
                "      \"private\": false,\n" +
                "      \"fork\": true,\n" +
                "      \"url\": \"https://api.github.com/repos/octocat/Hello-World\",\n" +
                "      \"html_url\": \"https://github.com/octocat/Hello-World\",\n" +
                "      \"archive_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/{archive_format}{/ref}\",\n" +
                "      \"assignees_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/assignees{/user}\",\n" +
                "      \"blobs_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/git/blobs{/sha}\",\n" +
                "      \"branches_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/branches{/branch}\",\n" +
                "      \"clone_url\": \"https://github.com/octocat/Hello-World.git\",\n" +
                "      \"collaborators_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/collaborators{/collaborator}\",\n" +
                "      \"comments_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/comments{/number}\",\n" +
                "      \"commits_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/commits{/sha}\",\n" +
                "      \"compare_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/compare/{base}...{head}\",\n" +
                "      \"contents_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/contents/{+path}\",\n" +
                "      \"contributors_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/contributors\",\n" +
                "      \"downloads_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/downloads\",\n" +
                "      \"events_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/events\",\n" +
                "      \"forks_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/forks\",\n" +
                "      \"git_commits_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/git/commits{/sha}\",\n" +
                "      \"git_refs_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/git/refs{/sha}\",\n" +
                "      \"git_tags_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/git/tags{/sha}\",\n" +
                "      \"git_url\": \"git:github.com/octocat/Hello-World.git\",\n" +
                "      \"hooks_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/hooks\",\n" +
                "      \"issue_comment_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/issues/comments{/number}\",\n" +
                "      \"issue_events_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/issues/events{/number}\",\n" +
                "      \"issues_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/issues{/number}\",\n" +
                "      \"keys_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/keys{/key_id}\",\n" +
                "      \"labels_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/labels{/name}\",\n" +
                "      \"languages_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/languages\",\n" +
                "      \"merges_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/merges\",\n" +
                "      \"milestones_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/milestones{/number}\",\n" +
                "      \"mirror_url\": \"git:git.example.com/octocat/Hello-World\",\n" +
                "      \"notifications_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/notifications{?since, all, " +
                "participating}\",\n" +
                "      \"pulls_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/pulls{/number}\",\n" +
                "      \"releases_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/releases{/id}\",\n" +
                "      \"ssh_url\": \"git@github.com:octocat/Hello-World.git\",\n" +
                "      \"stargazers_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/stargazers\",\n" +
                "      \"statuses_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/statuses/{sha}\",\n" +
                "      \"subscribers_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/subscribers\",\n" +
                "      \"subscription_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/subscription\",\n" +
                "      \"svn_url\": \"https://svn.github.com/octocat/Hello-World\",\n" +
                "      \"tags_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/tags\",\n" +
                "      \"teams_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/teams\",\n" +
                "      \"trees_url\": \"http://api.github" +
                ".com/repos/octocat/Hello-World/git/trees{/sha}\",\n" +
                "      \"homepage\": \"https://github.com\",\n" +
                "      \"language\": null,\n" +
                "      \"forks_count\": 9,\n" +
                "      \"stargazers_count\": 80,\n" +
                "      \"watchers_count\": 80,\n" +
                "      \"size\": 108,\n" +
                "      \"default_branch\": \"master\",\n" +
                "      \"open_issues_count\": 0,\n" +
                "      \"has_issues\": true,\n" +
                "      \"has_wiki\": true,\n" +
                "      \"has_pages\": false,\n" +
                "      \"has_downloads\": true,\n" +
                "      \"pushed_at\": \"2011-01-26T19:06:43Z\",\n" +
                "      \"created_at\": \"2011-01-26T19:01:12Z\",\n" +
                "      \"updated_at\": \"2011-01-26T19:14:43Z\",\n" +
                "      \"permissions\": {\n" +
                "        \"admin\": false,\n" +
                "        \"push\": false,\n" +
                "        \"pull\": true\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"_links\": {\n" +
                "    \"self\": {\n" +
                "      \"href\": \"https://api.github" +
                ".com/repos/octocat/Hello-World/pulls/1347\"\n" +
                "    },\n" +
                "    \"html\": {\n" +
                "      \"href\": \"https://github.com/octocat/Hello-World/pull/1347\"\n" +
                "    },\n" +
                "    \"issue\": {\n" +
                "      \"href\": \"https://api.github" +
                ".com/repos/octocat/Hello-World/issues/1347\"\n" +
                "    },\n" +
                "    \"comments\": {\n" +
                "      \"href\": \"https://api.github" +
                ".com/repos/octocat/Hello-World/issues/1347/comments\"\n" +
                "    },\n" +
                "    \"review_comments\": {\n" +
                "      \"href\": \"https://api.github" +
                ".com/repos/octocat/Hello-World/pulls/1347/comments\"\n" +
                "    },\n" +
                "    \"review_comment\": {\n" +
                "      \"href\": \"https://api.github" +
                ".com/repos/octocat/Hello-World/pulls/comments/{number}\"\n" +
                "    },\n" +
                "    \"commits\": {\n" +
                "      \"href\": \"https://api.github" +
                ".com/repos/octocat/Hello-World/pulls/1347/commits\"\n" +
                "    },\n" +
                "    \"statuses\": {\n" +
                "      \"href\": \"https://api.github" +
                ".com/repos/octocat/Hello-World/statuses" +
                "/6dcb09b5b57875f334f61aebed695e2e4193db5e\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"user\": {\n" +
                "    \"login\": \"octocat\",\n" +
                "    \"id\": 1,\n" +
                "    \"avatar_url\": \"https://github.com/images/error/octocat_happy" +
                ".gif\",\n" +
                "    \"gravatar_id\": \"\",\n" +
                "    \"url\": \"https://api.github.com/users/octocat\",\n" +
                "    \"html_url\": \"https://github.com/octocat\",\n" +
                "    \"followers_url\": \"https://api.github" +
                ".com/users/octocat/followers\",\n" +
                "    \"following_url\": \"https://api.github" +
                ".com/users/octocat/following{/other_user}\",\n" +
                "    \"gists_url\": \"https://api.github" +
                ".com/users/octocat/gists{/gist_id}\",\n" +
                "    \"starred_url\": \"https://api.github" +
                ".com/users/octocat/starred{/owner}{/repo}\",\n" +
                "    \"subscriptions_url\": \"https://api.github" +
                ".com/users/octocat/subscriptions\",\n" +
                "    \"organizations_url\": \"https://api.github" +
                ".com/users/octocat/orgs\",\n" +
                "    \"repos_url\": \"https://api.github.com/users/octocat/repos\",\n" +
                "    \"events_url\": \"https://api.github" +
                ".com/users/octocat/events{/privacy}\",\n" +
                "    \"received_events_url\": \"https://api.github" +
                ".com/users/octocat/received_events\",\n" +
                "    \"type\": \"User\",\n" +
                "    \"site_admin\": false\n" +
                "  },\n" +
                "  \"merge_commit_sha\": \"merge_commit_sha\",\n" +
                "  \"merged\": true,\n" +
                "  \"mergeable\": true,\n" +
                "  \"merged_by\": {\n" +
                "    \"login\": \"octocat\",\n" +
                "    \"id\": 1,\n" +
                "    \"avatar_url\": \"https://github.com/images/error/octocat_happy" +
                ".gif\",\n" +
                "    \"gravatar_id\": \"\",\n" +
                "    \"url\": \"https://api.github.com/users/octocat\",\n" +
                "    \"html_url\": \"https://github.com/octocat\",\n" +
                "    \"followers_url\": \"https://api.github" +
                ".com/users/octocat/followers\",\n" +
                "    \"following_url\": \"https://api.github" +
                ".com/users/octocat/following{/other_user}\",\n" +
                "    \"gists_url\": \"https://api.github" +
                ".com/users/octocat/gists{/gist_id}\",\n" +
                "    \"starred_url\": \"https://api.github" +
                ".com/users/octocat/starred{/owner}{/repo}\",\n" +
                "    \"subscriptions_url\": \"https://api.github" +
                ".com/users/octocat/subscriptions\",\n" +
                "    \"organizations_url\": \"https://api.github" +
                ".com/users/octocat/orgs\",\n" +
                "    \"repos_url\": \"https://api.github.com/users/octocat/repos\",\n" +
                "    \"events_url\": \"https://api.github" +
                ".com/users/octocat/events{/privacy}\",\n" +
                "    \"received_events_url\": \"https://api.github" +
                ".com/users/octocat/received_events\",\n" +
                "    \"type\": \"User\",\n" +
                "    \"site_admin\": false\n" +
                "  },\n" +
                "  \"comments\": 3,\n" +
                "  \"commits\": 4,\n" +
                "  \"additions\": 5,\n" +
                "  \"deletions\": 6,\n" +
                "  \"changed_files\": 7\n" +
                "}";

        public static final String EVENT_PUSH =
                "{\n" +
                "  \"id\": \"id\",\n" +
                "  \"type\": \"PushEvent\",\n" +
                "  \"actor\": {\n" +
                "    \"id\": 1,\n" +
                "    \"login\": \"login\",\n" +
                "    \"gravatar_id\": \"gravatar_id\",\n" +
                "    \"url\": \"url\",\n" +
                "    \"avatar_url\": \"avatar_url\"\n" +
                "  },\n" +
                "  \"repo\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"name\",\n" +
                "    \"url\": \"url\"\n" +
                "  },\n" +
                "  \"payload\": {\n" +
                "    \"push_id\": 1,\n" +
                "    \"size\": 1,\n" +
                "    \"distinct_size\": 1,\n" +
                "    \"ref\": \"ref\",\n" +
                "    \"head\": \"head\",\n" +
                "    \"before\": \"before\",\n" +
                "    \"commits\": [\n" +
                "      {\n" +
                "        \"sha\": \"sha\",\n" +
                "        \"author\": {\n" +
                "          \"email\": \"email\",\n" +
                "          \"name\": \"name\"\n" +
                "        },\n" +
                "        \"message\": \"message\",\n" +
                "        \"distinct\": true,\n" +
                "        \"url\": \"url\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"public\": true,\n" +
                "  \"created_at\": \"created_at\",\n" +
                "  \"org\": {\n" +
                "    \"id\": 1,\n" +
                "    \"login\": \"login\",\n" +
                "    \"gravatar_id\": \"gravatar_id\",\n" +
                "    \"url\": \"url\",\n" +
                "    \"avatar_url\": \"avatar_url\"\n" +
                "  }\n" +
                "}";

        public static final String PAYLOAD_PUSH_EVENT =
                "{\n" +
                "  \"push_id\": 1,\n" +
                "  \"size\": 1,\n" +
                "  \"distinct_size\": 1,\n" +
                "  \"ref\": \"ref\",\n" +
                "  \"head\": \"head\",\n" +
                "  \"before\": \"before\",\n" +
                "  \"commits\": [\n" +
                "    {\n" +
                "      \"sha\": \"sha\",\n" +
                "      \"author\": {\n" +
                "        \"email\": \"email\",\n" +
                "        \"name\": \"name\"\n" +
                "      },\n" +
                "      \"message\": \"message\",\n" +
                "      \"distinct\": true,\n" +
                "      \"url\": \"url\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"sha\": \"sha2\",\n" +
                "      \"author\": {\n" +
                "        \"email\": \"email2\",\n" +
                "        \"name\": \"name2\"\n" +
                "      },\n" +
                "      \"message\": \"message2\",\n" +
                "      \"distinct\": true,\n" +
                "      \"url\": \"url2\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        public static final String PAYLOAD_PULL_REQUEST =
                "{\n" +
                "  \"action\": \"action\",\n" +
                "  \"number\": 1,\n" +
                "  \"pull_request\": {\n" +
                "    \"url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/pulls/1\",\n" +
                "    \"id\": 34778301,\n" +
                "    \"html_url\": \"https://github" +
                ".com/baxterthehacker/public-repo/pull/1\",\n" +
                "    \"diff_url\": \"https://github" +
                ".com/baxterthehacker/public-repo/pull/1.diff\",\n" +
                "    \"patch_url\": \"https://github" +
                ".com/baxterthehacker/public-repo/pull/1.patch\",\n" +
                "    \"issue_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues/1\",\n" +
                "    \"number\": 1,\n" +
                "    \"state\": \"open\",\n" +
                "    \"locked\": false,\n" +
                "    \"title\": \"Update the README with new information\",\n" +
                "    \"user\": {\n" +
                "      \"login\": \"baxterthehacker\",\n" +
                "      \"id\": 6752317,\n" +
                "      \"avatar_url\": \"https://avatars.githubusercontent" +
                ".com/u/6752317?v=3\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/baxterthehacker\",\n" +
                "      \"html_url\": \"https://github.com/baxterthehacker\",\n" +
                "      \"followers_url\": \"https://api.github" +
                ".com/users/baxterthehacker/followers\",\n" +
                "      \"following_url\": \"https://api.github" +
                ".com/users/baxterthehacker/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github" +
                ".com/users/baxterthehacker/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github" +
                ".com/users/baxterthehacker/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github" +
                ".com/users/baxterthehacker/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github" +
                ".com/users/baxterthehacker/orgs\",\n" +
                "      \"repos_url\": \"https://api.github" +
                ".com/users/baxterthehacker/repos\",\n" +
                "      \"events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"body\": \"This is a pretty simple change that we need to pull into" +
                " master.\",\n" +
                "    \"created_at\": \"2015-05-05T23:40:27Z\",\n" +
                "    \"updated_at\": \"2015-05-05T23:40:27Z\",\n" +
                "    \"closed_at\": null,\n" +
                "    \"merged_at\": null,\n" +
                "    \"merge_commit_sha\": null,\n" +
                "    \"assignee\": null,\n" +
                "    \"milestone\": null,\n" +
                "    \"commits_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/pulls/1/commits\",\n" +
                "    \"review_comments_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/pulls/1/comments\",\n" +
                "    \"review_comment_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/pulls/comments{/number}\",\n" +
                "    \"comments_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues/1/comments\",\n" +
                "    \"statuses_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/statuses" +
                "/0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c\",\n" +
                "    \"head\": {\n" +
                "      \"label\": \"baxterthehacker:changes\",\n" +
                "      \"ref\": \"changes\",\n" +
                "      \"sha\": \"0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"baxterthehacker\",\n" +
                "        \"id\": 6752317,\n" +
                "        \"avatar_url\": \"https://avatars.githubusercontent" +
                ".com/u/6752317?v=3\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/baxterthehacker\",\n" +
                "        \"html_url\": \"https://github.com/baxterthehacker\",\n" +
                "        \"followers_url\": \"https://api.github" +
                ".com/users/baxterthehacker/followers\",\n" +
                "        \"following_url\": \"https://api.github" +
                ".com/users/baxterthehacker/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github" +
                ".com/users/baxterthehacker/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github" +
                ".com/users/baxterthehacker/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github" +
                ".com/users/baxterthehacker/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github" +
                ".com/users/baxterthehacker/orgs\",\n" +
                "        \"repos_url\": \"https://api.github" +
                ".com/users/baxterthehacker/repos\",\n" +
                "        \"events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 35129377,\n" +
                "        \"name\": \"public-repo\",\n" +
                "        \"full_name\": \"baxterthehacker/public-repo\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"baxterthehacker\",\n" +
                "          \"id\": 6752317,\n" +
                "          \"avatar_url\": \"https://avatars.githubusercontent" +
                ".com/u/6752317?v=3\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/baxterthehacker\",\n" +
                "          \"html_url\": \"https://github.com/baxterthehacker\",\n" +
                "          \"followers_url\": \"https://api.github" +
                ".com/users/baxterthehacker/followers\",\n" +
                "          \"following_url\": \"https://api.github" +
                ".com/users/baxterthehacker/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github" +
                ".com/users/baxterthehacker/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github" +
                ".com/users/baxterthehacker/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github" +
                ".com/users/baxterthehacker/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github" +
                ".com/users/baxterthehacker/orgs\",\n" +
                "          \"repos_url\": \"https://api.github" +
                ".com/users/baxterthehacker/repos\",\n" +
                "          \"events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/received_events\",\n" +
                "          \"type\": \"User\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github" +
                ".com/baxterthehacker/public-repo\",\n" +
                "        \"description\": \"\",\n" +
                "        \"fork\": false,\n" +
                "        \"url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo\",\n" +
                "        \"forks_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/forks\",\n" +
                "        \"keys_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/teams\",\n" +
                "        \"hooks_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/events\",\n" +
                "        \"assignees_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/tags\",\n" +
                "        \"blobs_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/subscription\",\n" +
                "        \"commits_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/merges\",\n" +
                "        \"archive_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/downloads\",\n" +
                "        \"issues_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/notifications{?since,all," +
                "participating}\",\n" +
                "        \"labels_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/releases{/id}\",\n" +
                "        \"created_at\": \"2015-05-05T23:40:12Z\",\n" +
                "        \"updated_at\": \"2015-05-05T23:40:12Z\",\n" +
                "        \"pushed_at\": \"2015-05-05T23:40:26Z\",\n" +
                "        \"git_url\": \"git://github.com/baxterthehacker/public-repo" +
                ".git\",\n" +
                "        \"ssh_url\": \"git@github.com:baxterthehacker/public-repo.git\"," +
                "\n" +
                "        \"clone_url\": \"https://github.com/baxterthehacker/public-repo" +
                ".git\",\n" +
                "        \"svn_url\": \"https://github.com/baxterthehacker/public-repo\"," +
                "\n" +
                "        \"homepage\": null,\n" +
                "        \"size\": 0,\n" +
                "        \"stargazers_count\": 0,\n" +
                "        \"watchers_count\": 0,\n" +
                "        \"language\": null,\n" +
                "        \"has_issues\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": true,\n" +
                "        \"has_pages\": true,\n" +
                "        \"forks_count\": 0,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"open_issues_count\": 1,\n" +
                "        \"forks\": 0,\n" +
                "        \"open_issues\": 1,\n" +
                "        \"watchers\": 0,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"base\": {\n" +
                "      \"label\": \"baxterthehacker:master\",\n" +
                "      \"ref\": \"master\",\n" +
                "      \"sha\": \"9049f1265b7d61be4a8904a9a27120d2064dab3b\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"baxterthehacker\",\n" +
                "        \"id\": 6752317,\n" +
                "        \"avatar_url\": \"https://avatars.githubusercontent" +
                ".com/u/6752317?v=3\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/baxterthehacker\",\n" +
                "        \"html_url\": \"https://github.com/baxterthehacker\",\n" +
                "        \"followers_url\": \"https://api.github" +
                ".com/users/baxterthehacker/followers\",\n" +
                "        \"following_url\": \"https://api.github" +
                ".com/users/baxterthehacker/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github" +
                ".com/users/baxterthehacker/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github" +
                ".com/users/baxterthehacker/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github" +
                ".com/users/baxterthehacker/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github" +
                ".com/users/baxterthehacker/orgs\",\n" +
                "        \"repos_url\": \"https://api.github" +
                ".com/users/baxterthehacker/repos\",\n" +
                "        \"events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 35129377,\n" +
                "        \"name\": \"public-repo\",\n" +
                "        \"full_name\": \"baxterthehacker/public-repo\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"baxterthehacker\",\n" +
                "          \"id\": 6752317,\n" +
                "          \"avatar_url\": \"https://avatars.githubusercontent" +
                ".com/u/6752317?v=3\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/baxterthehacker\",\n" +
                "          \"html_url\": \"https://github.com/baxterthehacker\",\n" +
                "          \"followers_url\": \"https://api.github" +
                ".com/users/baxterthehacker/followers\",\n" +
                "          \"following_url\": \"https://api.github" +
                ".com/users/baxterthehacker/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github" +
                ".com/users/baxterthehacker/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github" +
                ".com/users/baxterthehacker/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github" +
                ".com/users/baxterthehacker/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github" +
                ".com/users/baxterthehacker/orgs\",\n" +
                "          \"repos_url\": \"https://api.github" +
                ".com/users/baxterthehacker/repos\",\n" +
                "          \"events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/received_events\",\n" +
                "          \"type\": \"User\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github" +
                ".com/baxterthehacker/public-repo\",\n" +
                "        \"description\": \"\",\n" +
                "        \"fork\": false,\n" +
                "        \"url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo\",\n" +
                "        \"forks_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/forks\",\n" +
                "        \"keys_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/teams\",\n" +
                "        \"hooks_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/events\",\n" +
                "        \"assignees_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/tags\",\n" +
                "        \"blobs_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/subscription\",\n" +
                "        \"commits_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/merges\",\n" +
                "        \"archive_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/downloads\",\n" +
                "        \"issues_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/notifications{?since,all," +
                "participating}\",\n" +
                "        \"labels_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/releases{/id}\",\n" +
                "        \"created_at\": \"2015-05-05T23:40:12Z\",\n" +
                "        \"updated_at\": \"2015-05-05T23:40:12Z\",\n" +
                "        \"pushed_at\": \"2015-05-05T23:40:26Z\",\n" +
                "        \"git_url\": \"git://github.com/baxterthehacker/public-repo" +
                ".git\",\n" +
                "        \"ssh_url\": \"git@github.com:baxterthehacker/public-repo.git\"," +
                "\n" +
                "        \"clone_url\": \"https://github.com/baxterthehacker/public-repo" +
                ".git\",\n" +
                "        \"svn_url\": \"https://github.com/baxterthehacker/public-repo\"," +
                "\n" +
                "        \"homepage\": null,\n" +
                "        \"size\": 0,\n" +
                "        \"stargazers_count\": 0,\n" +
                "        \"watchers_count\": 0,\n" +
                "        \"language\": null,\n" +
                "        \"has_issues\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": true,\n" +
                "        \"has_pages\": true,\n" +
                "        \"forks_count\": 0,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"open_issues_count\": 1,\n" +
                "        \"forks\": 0,\n" +
                "        \"open_issues\": 1,\n" +
                "        \"watchers\": 0,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "      \"self\": {\n" +
                "        \"href\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/pulls/1\"\n" +
                "      },\n" +
                "      \"html\": {\n" +
                "        \"href\": \"https://github" +
                ".com/baxterthehacker/public-repo/pull/1\"\n" +
                "      },\n" +
                "      \"issue\": {\n" +
                "        \"href\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues/1\"\n" +
                "      },\n" +
                "      \"comments\": {\n" +
                "        \"href\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues/1/comments\"\n" +
                "      },\n" +
                "      \"review_comments\": {\n" +
                "        \"href\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/pulls/1/comments\"\n" +
                "      },\n" +
                "      \"review_comment\": {\n" +
                "        \"href\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/pulls/comments{/number}\"\n" +
                "      },\n" +
                "      \"commits\": {\n" +
                "        \"href\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/pulls/1/commits\"\n" +
                "      },\n" +
                "      \"statuses\": {\n" +
                "        \"href\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/statuses" +
                "/0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"merged\": false,\n" +
                "    \"mergeable\": null,\n" +
                "    \"mergeable_state\": \"unknown\",\n" +
                "    \"merged_by\": null,\n" +
                "    \"comments\": 0,\n" +
                "    \"review_comments\": 0,\n" +
                "    \"commits\": 1,\n" +
                "    \"additions\": 1,\n" +
                "    \"deletions\": 1,\n" +
                "    \"changed_files\": 1\n" +
                "  },\n" +
                "  \"repository\": {\n" +
                "    \"id\": 35129377,\n" +
                "    \"name\": \"public-repo\",\n" +
                "    \"full_name\": \"baxterthehacker/public-repo\",\n" +
                "    \"owner\": {\n" +
                "      \"login\": \"baxterthehacker\",\n" +
                "      \"id\": 6752317,\n" +
                "      \"avatar_url\": \"https://avatars.githubusercontent" +
                ".com/u/6752317?v=3\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/baxterthehacker\",\n" +
                "      \"html_url\": \"https://github.com/baxterthehacker\",\n" +
                "      \"followers_url\": \"https://api.github" +
                ".com/users/baxterthehacker/followers\",\n" +
                "      \"following_url\": \"https://api.github" +
                ".com/users/baxterthehacker/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github" +
                ".com/users/baxterthehacker/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github" +
                ".com/users/baxterthehacker/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github" +
                ".com/users/baxterthehacker/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github" +
                ".com/users/baxterthehacker/orgs\",\n" +
                "      \"repos_url\": \"https://api.github" +
                ".com/users/baxterthehacker/repos\",\n" +
                "      \"events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"private\": false,\n" +
                "    \"html_url\": \"https://github.com/baxterthehacker/public-repo\",\n" +
                "    \"description\": \"\",\n" +
                "    \"fork\": false,\n" +
                "    \"url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo\",\n" +
                "    \"forks_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/forks\",\n" +
                "    \"keys_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/keys{/key_id}\",\n" +
                "    \"collaborators_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/collaborators{/collaborator}\",\n" +
                "    \"teams_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/teams\",\n" +
                "    \"hooks_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/hooks\",\n" +
                "    \"issue_events_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues/events{/number}\",\n" +
                "    \"events_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/events\",\n" +
                "    \"assignees_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/assignees{/user}\",\n" +
                "    \"branches_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/branches{/branch}\",\n" +
                "    \"tags_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/tags\",\n" +
                "    \"blobs_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/blobs{/sha}\",\n" +
                "    \"git_tags_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/tags{/sha}\",\n" +
                "    \"git_refs_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/refs{/sha}\",\n" +
                "    \"trees_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/trees{/sha}\",\n" +
                "    \"statuses_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/statuses/{sha}\",\n" +
                "    \"languages_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/languages\",\n" +
                "    \"stargazers_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/stargazers\",\n" +
                "    \"contributors_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/contributors\",\n" +
                "    \"subscribers_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/subscribers\",\n" +
                "    \"subscription_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/subscription\",\n" +
                "    \"commits_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/commits{/sha}\",\n" +
                "    \"git_commits_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/git/commits{/sha}\",\n" +
                "    \"comments_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/comments{/number}\",\n" +
                "    \"issue_comment_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues/comments{/number}\",\n" +
                "    \"contents_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/contents/{+path}\",\n" +
                "    \"compare_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/compare/{base}...{head}\",\n" +
                "    \"merges_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/merges\",\n" +
                "    \"archive_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/{archive_format}{/ref}\",\n" +
                "    \"downloads_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/downloads\",\n" +
                "    \"issues_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/issues{/number}\",\n" +
                "    \"pulls_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/pulls{/number}\",\n" +
                "    \"milestones_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/milestones{/number}\",\n" +
                "    \"notifications_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/notifications{?since,all," +
                "participating}\",\n" +
                "    \"labels_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/labels{/name}\",\n" +
                "    \"releases_url\": \"https://api.github" +
                ".com/repos/baxterthehacker/public-repo/releases{/id}\",\n" +
                "    \"created_at\": \"2015-05-05T23:40:12Z\",\n" +
                "    \"updated_at\": \"2015-05-05T23:40:12Z\",\n" +
                "    \"pushed_at\": \"2015-05-05T23:40:26Z\",\n" +
                "    \"git_url\": \"git://github.com/baxterthehacker/public-repo.git\",\n" +
                "    \"ssh_url\": \"git@github.com:baxterthehacker/public-repo.git\",\n" +
                "    \"clone_url\": \"https://github.com/baxterthehacker/public-repo" +
                ".git\",\n" +
                "    \"svn_url\": \"https://github.com/baxterthehacker/public-repo\",\n" +
                "    \"homepage\": null,\n" +
                "    \"size\": 0,\n" +
                "    \"stargazers_count\": 0,\n" +
                "    \"watchers_count\": 0,\n" +
                "    \"language\": null,\n" +
                "    \"has_issues\": true,\n" +
                "    \"has_downloads\": true,\n" +
                "    \"has_wiki\": true,\n" +
                "    \"has_pages\": true,\n" +
                "    \"forks_count\": 0,\n" +
                "    \"mirror_url\": null,\n" +
                "    \"open_issues_count\": 1,\n" +
                "    \"forks\": 0,\n" +
                "    \"open_issues\": 1,\n" +
                "    \"watchers\": 0,\n" +
                "    \"default_branch\": \"master\"\n" +
                "  },\n" +
                "  \"sender\": {\n" +
                "    \"login\": \"baxterthehacker\",\n" +
                "    \"id\": 6752317,\n" +
                "    \"avatar_url\": \"https://avatars.githubusercontent" +
                ".com/u/6752317?v=3\",\n" +
                "    \"gravatar_id\": \"\",\n" +
                "    \"url\": \"https://api.github.com/users/baxterthehacker\",\n" +
                "    \"html_url\": \"https://github.com/baxterthehacker\",\n" +
                "    \"followers_url\": \"https://api.github" +
                ".com/users/baxterthehacker/followers\",\n" +
                "    \"following_url\": \"https://api.github" +
                ".com/users/baxterthehacker/following{/other_user}\",\n" +
                "    \"gists_url\": \"https://api.github" +
                ".com/users/baxterthehacker/gists{/gist_id}\",\n" +
                "    \"starred_url\": \"https://api.github" +
                ".com/users/baxterthehacker/starred{/owner}{/repo}\",\n" +
                "    \"subscriptions_url\": \"https://api.github" +
                ".com/users/baxterthehacker/subscriptions\",\n" +
                "    \"organizations_url\": \"https://api.github" +
                ".com/users/baxterthehacker/orgs\",\n" +
                "    \"repos_url\": \"https://api.github" +
                ".com/users/baxterthehacker/repos\",\n" +
                "    \"events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/events{/privacy}\",\n" +
                "    \"received_events_url\": \"https://api.github" +
                ".com/users/baxterthehacker/received_events\",\n" +
                "    \"type\": \"User\",\n" +
                "    \"site_admin\": false\n" +
                "  }\n" +
                "}";
    }
}
