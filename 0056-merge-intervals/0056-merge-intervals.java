class Solution {
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0][0]);
        list.add(nums[0][1]);
        res.add(list);
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i][0];
            List<Integer> lst = res.getLast();
            int p1 = lst.get(0);
            int p2 = lst.get(1);

            if (a >= p1 && a <= p2) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(p1);
                temp.add(Math.max(lst.get(1), nums[i][1]));
                res.set(res.size()- 1, temp);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[i][0]);
                temp.add(nums[i][1]);
                res.add(temp);
            }
        }
        int[][] r = new int[res.size()][2];
        for(int f =0;f<r.length;f++)
        {
            r[f][0] = res.get(f).get(0);
            r[f][1] = res.get(f).get(1);
        }
        return r;
    }
}