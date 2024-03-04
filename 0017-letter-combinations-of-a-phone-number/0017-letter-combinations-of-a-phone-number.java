class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(1, new ArrayList<>());
        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));
        List<String> res = new LinkedList<>();
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        backTrack(digits, 0, "", res, map);
        return res;
    }

    private void backTrack(String ip, int n, String result, List<String> list, Map<Integer, List<Character>> map) {
        if (result.length() == ip.length()) {
            list.add(result);
            return;
        }

        List<Character> chars = map.get(Integer.parseInt(ip.charAt(n) + ""));
        for (char c : chars) {
            String resultNew = result + "" + c;
            backTrack(ip, n + 1, resultNew, list, map);
        }
    }
}