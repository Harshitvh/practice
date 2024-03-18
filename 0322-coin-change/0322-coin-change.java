class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0]=0;
        for(int i=1;i<dp.length;i++)
        {
            find(i, coins, dp);
        }
        return dp[amount] == Integer.MAX_VALUE-1 ? -1 : dp[amount];
    }

    private void find(int z, int[] coins, int[] dp)
    {
        for(int i=0;i<coins.length;i++)
        {
            int coin = coins[i];
            if(z-coin>=0)
            {
               dp[z] = Math.min(1+ dp[z-coin], dp[z]);
            }
        }
    }
}