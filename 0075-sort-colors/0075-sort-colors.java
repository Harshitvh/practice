class Solution {
    public void sortColors(int[] nums) {
        int c = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                int temp = nums[c];
                nums[c] = nums[i];
                nums[i] = temp; 
                c++;
            }
        }
        for(int i=c;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                int temp = nums[c];
                nums[c] = nums[i];
                nums[i] = temp;
                c++;
            }
        }
        

    }
}