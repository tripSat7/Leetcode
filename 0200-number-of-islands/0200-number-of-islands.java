class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int i, int j){

        if(grid[i][j] == '0'){
            return;
        }
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = '0';
        if(i + 1 < m){
            dfs(grid, i+1, j);
        }

        if(i - 1 >= 0){
            dfs(grid, i-1, j);
        }

        if(j + 1 < n){
            dfs(grid, i, j+1);
        }

        if(j - 1 >= 0){
            dfs(grid, i, j-1);
        }
    }
}