class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int c = 0; c <= len2; c++) {
            dp[0][c] = 0;
        }
        for (int r = 0; r <= len1; r++) {
            dp[r][0] = 0;
        }
        //This involves the shifting of index, intialize the array as len+1
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {

                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    int value = 1 + dp[i-1][j-1];
                    dp[i][j] = value;
                } else {
                    int value = Math.max(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = value;
                }
            }
        }
        return dp[len1][len2];
    }

    private int dfs(int i, int j, String text1, String text2, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            int value = 1 + dfs(i - 1, j - 1, text1, text2, dp);
            dp[i][j] = value;
            return value;
        } else {
            int value = Math.max(dfs(i - 1, j, text1, text2, dp), dfs(i, j - 1, text1, text2, dp));
            dp[i][j] = value;
            return value;
        }
    }
}