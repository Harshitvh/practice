class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int j = 0; j < triangle.get(n - 1).size(); j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int a1 = triangle.get(i).get(j) + dp[i + 1][j];
                int a2 = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(a1, a2);
            }
        }
        return dp[0][0];
    }
}