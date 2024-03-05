class Solution {
    //This solution follows the dfs approach 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> temp = new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        int sum = 0;
        int i = 0;
        dfs(i, sum, candidates, target, temp, res);
        return res;
    }

    private void dfs(int i, int sum, int[] nums, int target, LinkedList<Integer> temp,
            LinkedList<List<Integer>> res) {
        if (sum == target) {
            res.add(new LinkedList<>(temp));
            return;
        }
        if (i >= nums.length || sum > target) {
            return;
        }
        temp.add(nums[i]);
        sum = sum + nums[i];
        dfs(i, sum, nums, target, temp, res);
        temp.removeLast();
        sum = sum - nums[i];
        dfs(i+1, sum, nums, target, temp, res);
    }

}