class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchRow(matrix, 0, matrix.length - 1, target);
        if (row == -1) {
            return false;
        }
        return binarySearch(matrix[row], 0, matrix[row].length - 1, target);
    }

    private boolean binarySearch(int[] nums, int l, int r, int target) {
        if (l > r) {
            return false;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return true;
        } else if (target < nums[mid]) {
            return binarySearch(nums, l, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, r, target);
        }
    }

    private int binarySearchRow(int[][] matrix, int start, int end, int target) {
        if (end < start) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
            return mid;
        } else if (target < matrix[mid][0]) {
            return binarySearchRow(matrix, start, mid - 1, target);
        } else {
            return binarySearchRow(matrix, mid + 1, end, target);
        }
    }

}