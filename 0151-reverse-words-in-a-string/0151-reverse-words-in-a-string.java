class Solution {
    public String reverseWords(String s) {
        String res = "";
        int startIndex = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (isNL(c)) {
                startIndex = i;
                break;
            }
        }
        for (int i = startIndex - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!isNL(c) && startIndex != -1) {
                res = res + s.substring(i + 1, startIndex + 1) +" ";
                startIndex = -1;
            } else if (isNL(c) && startIndex == -1) {
                startIndex = i;
            }
        }
        res = res + s.substring(0, startIndex + 1);
        return res.trim();
    }

    private boolean isNL(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

}