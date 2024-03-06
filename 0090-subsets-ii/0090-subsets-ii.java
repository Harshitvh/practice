class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        dfs(0, nums, temp, res);
        return new LinkedList<>(res); 
    }

    private void dfs(int i, int[] nums, LinkedList<Integer> temp, List<List<Integer>> res)
    {
        if(i==nums.length)
        {
            res.add(new LinkedList<>(temp));
            return;
        }
        temp.add(nums[i]);
        dfs(i+1, nums, temp, res);
        temp.removeLast();
        
        while(i+1<nums.length && nums[i]==nums[i+1])
        {
            i=i+1;
        }
        dfs(i+1, nums, temp, res);

    }
}