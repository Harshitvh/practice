class Solution {
    public int lengthOfLastWord(String s) {
        int startIndex = s.length() - 1;
        int endIndex = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                startIndex = i;
                break;
            }
        }

        for (int i = startIndex - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!Character.isLetter(c)) {
                endIndex = i;
                break;
            }
        }
        return startIndex-endIndex;
    }
}