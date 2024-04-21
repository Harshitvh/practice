class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Find sum<=goal and find sum<=goal-1
        return find(nums, goal) - find(nums, goal - 1);
    }

    public int find(int[] nums, int goal) {
        if(goal<0)
        {
            return 0;
        }
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while (r < nums.length) {
            sum = sum + nums[r];

            while (sum > goal) {
                sum = sum - nums[l];
                l = l + 1;

            }
            if (sum <=goal) {
                count = count + (r-l+1);
            }
            r++;
        }
        return count;
    }
}