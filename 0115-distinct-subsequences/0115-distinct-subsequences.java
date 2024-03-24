class Solution {
    public int numDistinct(String s, String t) {
        int i = s.length();
        int j = t.length();
        int[][] dp = new int[i + 1][j + 1];
        for (int z = 0; z <=i; z++) {
            dp[z][0] = 1;
        }

        for (int r = 1; r <=i; r++) {
            for (int c = 1; c <=j; c++) {
                int s1 = r - 1;
                int s2 = c - 1;
                if (s.charAt(s1) == t.charAt(s2)) {
                    dp[r][c] = dp[r - 1][c - 1] + dp[r - 1][c];
                } else {
                    dp[r][c] = dp[r - 1][c];
                }
            }
        }
        return dp[i][j];
    }

    private int dfs(int i, int j, String str1, String str2, int[][] dp) {

        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            int value = dfs(i - 1, j - 1, str1, str2, dp) + dfs(i - 1, j, str1, str2, dp);
            dp[i][j] = value;
            return value;
        }
        int value = dfs(i - 1, j, str1, str2, dp);
        dp[i][j] = value;
        return value;
    }
}