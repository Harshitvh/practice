class Solution {
    public int climbStairs(int n) {
        int i=1;
        int j=1;
        for(int z=0;z<n-1;z++)
        {
            int temp = i;
            i = i+j;
            j=temp;
        }
        return i;
    }
}