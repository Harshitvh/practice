class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int l = 0;
        int r = 0;
        int count = 1;
        while (r < nums.length) {
            while (nums[r] == 0 && count > k) {
                if (nums[l] == 0) {
                    count--;
                }
                l = l + 1;
            }
            int temp = r - l + 1;
            max = Math.max(temp, max);
            if (nums[r] == 0) {
                count++;
            }
            r++;
        }
        return max;
    }
}