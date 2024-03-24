class Solution {
    public int minDistance(String word1, String word2) {
        int s1 = word1.length();
        int s2 = word2.length();
        int[][] dp = new int[s1 + 1][s2 + 1];
        for (int i = 0; i <= s1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= s2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = 1 + dp[i][j - 1];
                    int replace = 1 + dp[i - 1][j - 1];
                    int remove = 1 + dp[i - 1][j];
                    dp[i][j] = Math.min(add, Math.min(replace, remove));
                }
            }
        }
        return dp[s1][s2];
    }

    private int dfs(int i, int j, String str1, String str2) {

        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return dfs(i - 1, j - 1, str1, str2);
        } else {
            int add = 1 + dfs(i, j - 1, str1, str2);
            int replace = 1 + dfs(i - 1, j - 1, str1, str2);
            int remove = 1 + dfs(i - 1, j, str1, str2);
            return Math.min(add, Math.min(replace, remove));
        }
    }
}