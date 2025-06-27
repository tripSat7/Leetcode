// Time Complexity: O(m * n) — each cell is visited once due to memoization
// Space Complexity: O(m * n) — for the dp table and recursion stack

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If destination cell is an obstacle, no path is possible
        if(obstacleGrid[m-1][n-1] == 1){
            return 0;
        }

        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1); // Initialize DP table with -1 (unvisited)
        }

        // Start from top-left corner
        return helper(0, 0, m, n, dp, obstacleGrid);
    }

    // Recursive helper with memoization
    public int helper(int i, int j, int m, int n, int dp[][], int[][] obstacleGrid){
        // Reached destination cell
        if(i == m-1 && j == n-1){
            return 1;
        }
        // Out of bounds
        if(i >= m || j >= n){
            return 0;
        }
        // Hit an obstacle
        if(obstacleGrid[i][j] == 1){
            return dp[i][j] = 0;
        }
        // Already computed
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // Move down and right
        int res = helper(i+1, j, m, n, dp, obstacleGrid) + helper(i, j+1, m, n, dp, obstacleGrid);
        return dp[i][j] = res; // Memoize and return result
    }
}
