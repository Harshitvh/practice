class Solution {
    public int lengthOfLIS(int[] nums) {
        //This is a dp approach which is used to solve this problem
        int n = nums.length;
        int[][] dp = new int[nums.length + 1][nums.length + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[nums.length][i] = 0;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j <= nums.length; j++) {
                int not = dp[i + 1][j];
                int take = 0;
                if (j == 0 || nums[j - 1] < nums[i])
                    take = 1 + dp[i + 1][i + 1];
                int value = Math.max(not, take);
                dp[i][j] = value;
            }
        }

        return dp[0][0];
    }

    private int dfs(int n, int prev, int[] nums, int[][] dp) {
        if (n == nums.length) {
            return 0;
        }
        if (dp[n][prev] != -1) {
            return dp[n][prev];
        }
        int not = dfs(n + 1, prev, nums, dp);
        int take = 0;
        if (prev == 0 || nums[prev - 1] < nums[n])
            take = 1 + dfs(n + 1, n + 1, nums, dp);
        int value = Math.max(not, take);
        dp[n][prev] = value;
        return value;
    }
}