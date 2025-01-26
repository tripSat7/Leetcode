class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -101);
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int pathSum = helper(grid, m, n, 0, i, dp);
            res = Math.min(res, pathSum);
        }

        return res;
    }

    public int helper(int[][] grid, int m, int n, int i, int j, int dp[][]){
        if(i == m-1){
            return dp[i][j] = grid[i][j];
        }

        if(dp[i][j] != -101){
            return dp[i][j];
        }
        
        int down = Integer.MAX_VALUE;
        if (i + 1 < m) {
            down = helper(grid, m, n, i + 1, j, dp);
        }

        int ldown = Integer.MAX_VALUE;
        if (j - 1 >= 0 ) {
            ldown = helper(grid, m, n, i + 1, j - 1, dp);
        }
        
        int rdown = Integer.MAX_VALUE;
        if (j + 1 < n) {
            rdown = helper(grid, m, n, i + 1, j + 1, dp);
        }

        return dp[i][j] = grid[i][j] + Math.min(down, Math.min(ldown, rdown));        
    }
}