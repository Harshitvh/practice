class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        LinkedList<String> temp = new LinkedList<>();
        dfs(s, "", 0, res, temp);
        return res;
    }

    private void dfs(String s, String in, int i, List<List<String>> res, LinkedList<String> temp) {
        if (i >= s.length()) {
            res.add(new LinkedList<String>(temp));
            return;
        }
        for (int z = i; z < s.length(); z++) {
            String temp1 = s.substring(i,z+1);
            if (isPalindrome(temp1)) {
                temp.add(temp1);
                dfs(s, "", z+1, res, temp);
                temp.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}