class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return dfs(n - 1, amount, coins, dp);
    }

    private int dfs(int n, int target, int[] coins, int[][] dp) {
        if (n == 0) {
            if (target % coins[0] == 0) {
                return 1;
            }
            return 0;
        }
        if(dp[n][target]!=-1)
        {
            return dp[n][target];
        }
        int not = dfs(n - 1, target, coins, dp);
        int take = 0;
        if (target >= coins[n]) {
            take = dfs(n, target - coins[n], coins, dp);
        }
        dp[n][target] = not + take;
        return not + take;
    }
}