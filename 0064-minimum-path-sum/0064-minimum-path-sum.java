class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return helper(grid, m, n, 0, 0, dp);
    }

    public int helper(int[][] grid, int m, int n, int i, int j, int dp[][]){
        if(i == m - 1 && j == n - 1){
            return dp[i][j] = grid[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = Integer.MAX_VALUE;
        if (i + 1 < m) {
            down = helper(grid, m, n, i + 1, j, dp);
        }

        int right = Integer.MAX_VALUE;
        if (j + 1 < n) {
            right = helper(grid, m, n, i, j + 1, dp);
        }
        
        return dp[i][j] = grid[i][j] + Math.min(down, right);
    }
}