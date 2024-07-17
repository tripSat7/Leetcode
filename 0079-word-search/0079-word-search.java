class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean vis[][] = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, word, i, j, 0, vis)){
                        return true;   
                    }
                }
            } 
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int r, int c, int k, boolean vis[][]){
        
        if(k == word.length()){
            return true;
        }
        
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || vis[r][c] || k >= word.length() || board[r][c] != word.charAt(k)){
            return false;
        }
        
        //System.out.println(r+":"+c+"||"+word.charAt(k));
        
        
        vis[r][c] = true;
        if(dfs(board, word, r , c + 1, k + 1, vis) 
            || dfs(board, word, r + 1, c , k + 1, vis) 
            || dfs(board, word, r - 1, c , k + 1, vis)
            || dfs(board, word, r , c - 1, k + 1, vis)
          ){
            return true;
        }
        
        vis[r][c] = false;
        return false;
    }
}