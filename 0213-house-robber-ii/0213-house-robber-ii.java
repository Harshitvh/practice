class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        return Math.max(rob1(Arrays.copyOfRange(nums,1, nums.length)), rob1(Arrays.copyOfRange(nums, 0, nums.length-1)));
    }

      public int rob1(int[] nums) {
        int[] dp = new int[nums.length];
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {

            int p1 = nums[i] + prev2;

            int p2 = prev;
            int curri = Math.max(p1, p2);
            prev2 = prev;
            prev = curri;

        }
        return prev;
    }
}