class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<Character> list = new LinkedList<>();
        for (int r = 0; r < numRows; r++) {
            int inc = (numRows - 1) * 2;
            for (int i = r; i < s.length(); i = i + inc) {
                list.add(s.charAt(i));
                if (r != 0 && r != numRows - 1 && (i + (inc - 2 * r)) < s.length()) {
                    list.add(s.charAt(i + (inc - 2 * r)));
                }
            }
        }
        return list.stream()
                .map(c -> c.toString())
                .collect(Collectors.joining());
    }
}