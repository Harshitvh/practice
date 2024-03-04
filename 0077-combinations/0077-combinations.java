class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> res = new LinkedList<>();
        dfs(0, k, res, list, n);
        return list;
    }

    public void dfs(int i, int k, LinkedList<Integer> res, List<List<Integer>> list, int input) {

        if (res.size() == k) {
            list.add(new ArrayList<>(res));
            return;
        }
        for (int z = i + 1; z <= input; z++) {
            res.add(z);
            dfs(z, k, res, list, input);
            res.removeLast();
        }

    }
}