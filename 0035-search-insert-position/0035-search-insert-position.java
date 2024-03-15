class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int l , int r)
    {
        if(l>r)
        {
            return l;
        }
        int mid = l + (r-l)/2;
        if(nums[mid]==target)
        {
            return mid;
        } 
        if(target<nums[mid])
        {
            return binarySearch(nums, target, l, mid-1);
        }
        else{
            return binarySearch(nums, target, mid+1, r);
        }
    }
}