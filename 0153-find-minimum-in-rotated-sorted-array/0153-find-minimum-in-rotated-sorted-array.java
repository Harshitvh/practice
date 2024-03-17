class Solution {
    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int l, int r) {
        if (l > r) {
            return nums[0];
        }
        int mid = l + (r-l)/2;
        if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }
        if (mid<nums.length-1 && nums[mid + 1] < nums[mid]) {
            return nums[mid+1];
        }

        if(nums[mid]>= nums[l])
        {
            return binarySearch(nums, mid+1, r);
        }
        return binarySearch(nums, l, mid-1);
    }
}