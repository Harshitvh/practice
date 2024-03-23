class Solution {
    public int minInsertions(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
       
        System.out.println(s1);
        System.out.println(s2);
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return s1.length() - dp[s1.length()][s1.length()];
    }
}