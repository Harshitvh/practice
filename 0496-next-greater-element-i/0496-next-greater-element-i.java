class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int res[] = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int poll = stack.pop();
                if (map.containsKey(poll)) {
                    int idx = map.get(poll);
                    res[idx] = nums2[i];
                }
            }
            if (map.containsKey(nums2[i])) {
                stack.push(nums2[i]);
            }

        }
        return res;
    }
}