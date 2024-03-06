class Solution {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        int len = nums.length;
        dfs(-1, len, nums, temp, result);
        return result;
    }

    void dfs(int i, int len, int[] nums, LinkedList<Integer> temp, LinkedList<List<Integer>> res) {
        if(temp.size()==len)
        {
            res.add(new LinkedList<>(temp));
            return;
        }
        for(int z = 0;z<nums.length;z++)
        {
            if( !temp.contains(nums[z]))
            {
                temp.add(nums[z]);
                dfs(i, len, nums, temp,res);
                temp.removeLast();
            }
        }
    }

}