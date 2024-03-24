class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(0, 1, prices, 0, dp);
    }

    private int dfs(int n, int buy, int[] prices, int txn, int[][][] dp) {
        if (txn == 2) {
            return 0;
        }
        if (n == prices.length) {
            return 0;
        }
        if (dp[n][buy][txn] != -1) {
            return dp[n][buy][txn];
        }
        int profit;
        if (buy == 1) {
            profit = Math.max((dfs(n + 1, 0, prices, txn, dp) - prices[n]), dfs(n + 1, 1, prices, txn, dp));
        } else {
            profit = Math.max((dfs(n + 1, 1, prices, txn + 1, dp) + prices[n]), dfs(n + 1, 0, prices, txn, dp));
        }
        dp[n][buy][txn] = profit;
        return profit;
    }
}