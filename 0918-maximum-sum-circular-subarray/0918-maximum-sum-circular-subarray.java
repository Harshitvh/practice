class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minCurr = 0;
        int min = nums[0];
        int maxCurr = 0;
        int max = nums[0];
        int total = 0;
        for(int i=0;i<nums.length;i++)
        {
            total = total + nums[i];
            maxCurr = Math.max(nums[i], maxCurr+nums[i]);
            max = Math.max(maxCurr, max);

            minCurr = Math.min(nums[i], minCurr+nums[i]);
            min = Math.min(minCurr, min);
        }
        return max<0 ? max : Math.max(max, total-min);
    }
}