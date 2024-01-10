class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        
        int arow[] = {-1, 0, +1, 0};
        int acol[] = {0, +1, 0, -1};
        
        for(int i = 0; i < n; i++){
            
            //first row
            if(grid[0][i] == 1 && vis[0][i] == 0){
                dfs(0, i, grid, vis, arow, acol);
            }
            
            //last row
            if(grid[m-1][i] == 1 && vis[m-1][i] == 0){
                dfs(m-1, i, grid, vis, arow, acol);
            }
        }
        
        for(int i = 0; i < m; i++){
            
            //first col
            if(grid[i][0] == 1 && vis[i][0] == 0){
                dfs(i, 0, grid, vis, arow, acol);
            }
            
            //last col
            if(grid[i][n-1] == 1 && vis[i][n-1] == 0){
                dfs(i, n-1, grid, vis, arow, acol);
            }
        }
        
        
        int counter = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    counter++;
                }
            }
        }
        
        return counter;
    }
    
    public void dfs(int row, int col, int[][] grid, int[][] vis, int[] arow, int[] acol){
        vis[row][col] = 1;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < 4; i++){
            int nrow = row + arow[i];
            int ncol = col + acol[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, grid, vis, arow, acol);
            }
        }
    }
}