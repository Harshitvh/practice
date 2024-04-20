class Solution {
    public int maxScore(int[] nums, int k) {
        int lsum = 0;
        int max = 0;
        int rsum = 0;
        for (int i = 0; i < k; i++) {
            lsum = lsum + nums[i];
        }
        int l = k-1;
        int r = nums.length-1;
        max = Math.max(max, lsum + rsum);
        while (l >= 0) {
            lsum = lsum - nums[l];
            l--;
            rsum = rsum + nums[r];
            r--;
            max = Math.max(max, lsum + rsum);

        }
        return max;

    }
}