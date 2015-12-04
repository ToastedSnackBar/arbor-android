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
    }
}
