class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> temp = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        dfs(0, nums, temp, result);
        return result;
    }

    private void dfs(int i, int[] nums, LinkedList<Integer> temp, List<List<Integer>> res) {

        if (i >= nums.length) {
            res.add(new LinkedList<>(temp));
            return;
        }
        dfs(i + 1, nums, temp, res);
        temp.add(nums[i]);
        dfs(i + 1, nums, temp, res);
        temp.removeLast();
    }
}