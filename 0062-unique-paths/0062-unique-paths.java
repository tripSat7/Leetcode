// Time Complexity: O(m * n)
// Space Complexity: O(m * n) for memoization table (dp)

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize all cells with -1 to mark them as uncomputed
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start from top-left corner (0, 0)
        return helper(0, 0, m, n, dp);
    }

    public int helper(int i, int j, int m, int n, int[][] dp) {
        // If we're at the bottom-right cell, it's one valid path
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // If we're out of bounds, it's not a valid path
        if (i >= m || j >= n) {
            return 0;
        }

        // If already computed, return cached value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Move down and right, and cache the result
        int res = helper(i + 1, j, m, n, dp) + helper(i, j + 1, m, n, dp);

        return dp[i][j] = res;
    }
}
