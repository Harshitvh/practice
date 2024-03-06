class Solution {
    public List<String> generateParenthesis(int n) {
        int open = 0;
        int close = 0;
        String temp = "";
        List<String> res = new ArrayList<>();
        dfs(open, close, n, temp, res);
        return res;
    }

    private void dfs(int open, int close, int n, String temp, List<String> res)
    {
        if(open == n && open==close)
        {
          res.add(new String(temp));
          return;
        }

        if(open<n)
        {
            dfs(open+1, close, n, temp+"(", res);
        }
        if(close<open)
        {
            dfs(open , close+1, n , temp + ")", res);
        }
        return;
    }
}