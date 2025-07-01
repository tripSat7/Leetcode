// TC : O(log(m * n))

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;         // Total number of rows
        int n = matrix[0].length;      // Total number of columns

        int left = 0, right = m * n - 1; // Treat the matrix as a flattened 1D array

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert mid index back to 2D matrix coordinates
            int mid_val = matrix[mid / n][mid % n];

            if (mid_val == target) {
                return true;            // Found the target
            } else if (mid_val < target) {
                left = mid + 1;         // Search right half
            } else {
                right = mid - 1;        // Search left half
            }
        }

        return false; // Target not found
    }
}
