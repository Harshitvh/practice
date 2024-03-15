class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        return findPeak(nums, 0, nums.length - 1);
    }

    private int findPeak(int[] nums, int l, int r) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (mid == 0 && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (mid == 0) {
            return findPeak(nums, mid + 1, r);
        } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
            return mid;
        } else if (mid == nums.length - 1) {
            return findPeak(nums, l, mid - 1);
        } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (nums[mid - 1] > nums[mid]) {
            return findPeak(nums, l, mid - 1);
        } else {
            return findPeak(nums, mid + 1, r);
        }
    }
}