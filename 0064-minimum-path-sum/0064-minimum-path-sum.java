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
        int down = -1, right = -1;
        if(i+1 < m){
            down = helper(grid, m, n, i+1, j, dp);
        }
        if(j+1 < n){
            right = helper(grid, m, n, i, j+1, dp);
        }

        if(down != -1 && right != -1){
            return dp[i][j] = grid[i][j] + Math.min(down, right);
        }
        else if(down == -1){
            return dp[i][j] = grid[i][j] + right;
        }
        else{
            return dp[i][j] = grid[i][j] + down;
        }
    }
}