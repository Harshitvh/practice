class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length));
        int[][] dp = new int[words.length + 1][words.length + 1];
        for (int i = 0; i < words.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, words,dp);
    }

    private int dfs(int n, int prev, String[] words, int[][] dp) {
        if (n == words.length) {
            return 0;
        }
        if (dp[n][prev] != -1) {
            return dp[n][prev];
        }
        int not = dfs(n + 1, prev, words, dp);
        int take = 0;
        if (prev == 0 || compare(words[n], words[prev - 1])) {
            take = 1 + dfs(n + 1, n + 1, words,dp);
        }
        dp[n][prev] = Math.max(not, take);
        return Math.max(not, take);
    }

    boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }
}