class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 1, prices, dp, fee);
    }

    public int dfs(int n, int buy, int[] prices, int[][] dp, int fee) {
        if (n >= prices.length) {
            return 0;
        }
        if (dp[n][buy] != -1) {
            return dp[n][buy];
        }

        int profit;
        if (buy == 1) {
            profit = Math.max(-fee+dfs(n + 1, 0, prices, dp, fee) - prices[n], dfs(n + 1, 1, prices, dp, fee));
        } else {
            profit = Math.max(dfs(n + 1, 1, prices, dp, fee) + prices[n] , dfs(n + 1, 0, prices, dp, fee));
        }
        dp[n][buy] = profit;
        return profit;
    }
}