// Time Complexity: O(m * n)
// Space Complexity: O(n) for dp table

public class Solution {
    public int uniquePaths(int m, int n) {
    
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Only one way to reach destination from last row

        // Start from the second-last row upwards
        for (int i = m - 2; i >= 0; i--) {
            // Move from second-last column to the left
            for (int j = n - 2; j >= 0; j--) {
                // Add paths from the cell to the right
                dp[j] += dp[j + 1];
            }
        }

        // dp[0] will hold the result for top-left cell
        return dp[0];
    }
}
