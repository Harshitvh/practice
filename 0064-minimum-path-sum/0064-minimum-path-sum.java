class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[m-1].length;
        int max = m * n * 200;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int left = i > 0 ? grid[i][j] + dp[i - 1][j] : max;
                    int right = j > 0 ? grid[i][j] + dp[i][j - 1] : max;
                    dp[i][j] = Math.min(left, right);
                }
            }
        }
        return dp[m - 1][n - 1];

    }
}