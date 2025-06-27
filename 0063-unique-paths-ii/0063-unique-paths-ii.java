// Time Complexity: O(m * n)
// Space Complexity: O(m * n)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // If starting cell is not blocked, set dp[0][0] = 1
        if (obstacleGrid[0][0] == 0){
            dp[0][0] = 1;
        } 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // Obstacle cell
                } 
                else {
                    // If not the first row, add paths from above
                    if (i > 0){
                        dp[i][j] += dp[i-1][j];
                    } 
                    // If not the first column, add paths from left
                    if (j > 0){
                        dp[i][j] += dp[i][j-1];
                    } 
                }
            }
        }
        return dp[m-1][n-1];
    }
}
