class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        String temp = "";
        k = k - 1;
        while (list.size() > 1) {
            int fact = facto(list.size());
            int blockSize = fact / list.size();
            int index = k / blockSize;
            temp = temp + "" + list.get(index);
            list.remove(index);
            k = k % blockSize;
        }
        temp = temp + "" + list.get(0);
        return temp;
    }

    private int facto(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * facto(n - 1);

    }
}