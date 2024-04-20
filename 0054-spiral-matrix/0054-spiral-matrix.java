class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        while (top < bottom && left < right) {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right--;
            if (!(top < bottom && left < right)) {
                break;
            }
            for (int i = right - 1; i > left - 1; i--) {
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;
            for (int i = bottom - 1; i > top - 1; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;

    }
}