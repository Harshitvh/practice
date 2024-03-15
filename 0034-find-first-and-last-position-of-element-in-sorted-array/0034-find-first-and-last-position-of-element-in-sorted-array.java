class Solution {
    public int[] searchRange(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int[] binarySearch(int[] nums, int target, int l, int r) {
        if (l > r) {
            return new int[] { -1, -1 };
        }
        int mid = l + (r - l) / 2;
        if (target == nums[mid]) {
            int low = mid;
            while (low - 1 >= 0 && nums[low - 1] == target) {
                low = low - 1;
            }
            int high = mid;
            while (high + 1 < nums.length && nums[high + 1] == target) {
                high = high + 1;
            }
            return new int[] { low, high };
        } else if (target < nums[mid]) {
            return binarySearch(nums, target, l, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, r);
        }

    }
}