class Solution {
    public String intToRoman(int num) {
        String[] roman = new String[] { "M", "CM", "D",
                "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] values = new int[] { 1000, 900, 500, 400, 100, 90, 50,
                40, 10, 9, 5, 4, 1 };

        StringBuilder sb = new StringBuilder("");
        iterative(num, sb, roman, values);
        return sb.toString();
    }

    private void iterative(int num, StringBuilder sb, String[] roman, int[] values) {
        while (num > 0) {
            int index = getIndex(num, values);
            String value = roman[index];
            int diff = values[index];
            sb.append(value);
            num = num - diff;
        }

    }

    private void dfs(int num, StringBuilder sb, String[] roman, int[] values) {
        if (num == 0) {
            return;
        }
        int index = getIndex(num, values);
        String value = roman[index];
        int diff = values[index];
        sb.append(value);
        dfs(num - diff, sb, roman, values);

    }

    private int getIndex(int num, int[] values) {
        if (num >= values[0]) {
            return 0;
        }
        int i = values.length - 1;
        while (i > 0) {
            if (values[i] == num) {
                return i;
            } else if (num > values[i] && values[i - 1] > num) {
                return i;
            }
            i--;
        }
        return i;
    }
}