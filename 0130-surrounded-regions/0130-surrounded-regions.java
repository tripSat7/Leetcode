class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];
        
        int arow[] = {-1, 0, +1, 0};
        int acol[] = {0, +1, 0, -1};
        
        for(int i = 0; i < n; i++){
            
            //first row
            if(board[0][i]=='O' && vis[0][i] == 0){
                dfs(0, i, board, vis, arow, acol);
            }
            
            //last row
            if(board[m-1][i]=='O' && vis[m-1][i] == 0){
                dfs(m-1, i, board, vis, arow, acol);
            }
        }
        
        for(int i = 0; i < m; i++){
            
            //first col
            if(board[i][0] == 'O' && vis[i][0] == 0){
                dfs(i, 0, board, vis, arow, acol);
            }
            
            //last col
            if(board[i][n-1] == 'O' && vis[i][n-1] == 0){
                dfs(i, n-1, board, vis, arow, acol);
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void dfs(int row, int col, char[][] board, int[][] vis, int[] arow, int[] acol){
        vis[row][col] = 1;
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < 4; i++){
            int nrow = row + arow[i];
            int ncol = col + acol[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                dfs(nrow, ncol, board, vis, arow, acol);
            }
        }
    }
    
    
}