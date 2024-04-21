class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int maxf = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            Character rc = s.charAt(r);
            map.putIfAbsent(rc, 0);
            map.put(rc, map.get(rc) + 1);
            maxf = Math.max(maxf, map.get(rc));
            int len = r - l + 1;
            while (len - maxf > k) {
                Character lc = s.charAt(l);
                int count = map.get(lc);
                map.put(lc, count - 1);
                if (map.get(lc) == 0) {
                    map.remove(lc);
                }
                maxf = 0;
                for (Map.Entry<Character, Integer> e : map.entrySet()) {
                    maxf = Math.max(maxf, e.getValue());
                }
                l = l + 1;
                len = r - l + 1;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}