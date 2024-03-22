class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (dp[0][i] != Integer.MIN_VALUE) {
                min = Math.min(min, dp[0][i]);
            } else {
                min = Math.min(min, dfs(0, i, matrix, dp));
            }
        }
        return min;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= matrix[i].length) {
            return 100 * matrix.length * matrix[i].length;
        }
        if (i == matrix.length - 1) {
            return matrix[i][j];
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int a3 = matrix[i][j] + dfs(i + 1, j - 1, matrix, dp);
        int a1 = matrix[i][j] + dfs(i + 1, j, matrix,dp);
        int a2 = matrix[i][j] + dfs(i + 1, j + 1, matrix, dp);
        int res = Math.min(Math.min(a1, a2), a3);
        dp[i][j] = res;
        return res;
    }
}