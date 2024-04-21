class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i), i);
            if(map.get('a')!=null && map.get('b')!=null && map.get('c')!=null)
            {
               count = count + 1 + Math.min(map.get('a'), Math.min(map.get('b'), map.get('c')));
            }
        }
        return count;
    }
}