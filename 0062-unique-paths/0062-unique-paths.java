class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(m - 1, n - 1, m, n, dp);
    }

    private int dfs(int i, int j, int m, int n, int[][] dp) {

        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = dfs(i - 1, j, m, n, dp);
        int up = dfs(i, j - 1, m, n, dp);
        dp[i][j] = left+up;
        return left  + up;
    }
}