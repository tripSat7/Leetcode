/**
 Time Complexity: O(n²) — visiting each element once during transpose and once during row reversal.
 Space Complexity: O(1) — In-place rotation, no extra space used.
 */

class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows; // Square matrix assumption

        // Step 1: Transpose the matrix (swap across the diagonal)
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row to get the rotated matrix
        for (int i = 0; i < rows; i++) {
            int j = 0, k = cols - 1;
            while (j < k) {
                // Swap elements in the row
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++; k--;
            }
        }
    }
}
