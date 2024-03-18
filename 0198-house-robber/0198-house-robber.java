class Solution {
    public int rob(int[] nums) {
        int nminus1 = 0;
        int nminus2 = 0;
        for (int i = 0; i < nums.length; i++) {
           int temp = nminus1;
           nminus1 = Math.max(temp, nums[i]+(nminus2));
           nminus2 = temp;
        }
        return nminus1;
    }
}