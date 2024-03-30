class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            int val = q.poll();
            if (i + 1 == k) {
                return val;
            }
        }
        return 0;
    }
}