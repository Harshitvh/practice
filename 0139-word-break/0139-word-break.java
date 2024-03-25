class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(0, s, wordDict, dp);
    }

    private boolean dfs(int i, String s, List<String> words, int[] dp) {
        if (i >= s.length()) {
            return true;
        }
        if (dp[i] != -1) {
            return dp[i]==1 ? true : false;
        }
        for (int z = 0; z < words.size(); z++) {
            String word = words.get(z);
            if (i + word.length() <= s.length()) {
                String temp = s.substring(i, i + word.length());
                if (word.equals(temp)) {
                    boolean res = dfs(i + word.length(), s, words, dp);
                    if (res) {
                        dp[i] = 1;
                        return true;
                    }
                }
            }
        }
        dp[i] = 0;
        return false;
    }

}