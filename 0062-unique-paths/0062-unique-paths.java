// Time Complexity: O(m * n)
// Space Complexity: O(m * n) for dp table

public class Solution {
    public int uniquePaths(int m, int n) {
        // Create DP table with extra row and column to avoid boundary checks
        int[][] dp = new int[m + 1][n + 1];

        // Base case: only 1 way to reach bottom-right cell from itself
        dp[m - 1][n - 1] = 1;

        // Fill the table from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Add paths from the cell below and the cell to the right
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
            }
        }

        // The result is the number of unique paths from top-left
        return dp[0][0];
    }
}
