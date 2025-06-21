// Time Complexity: O(m * n * 4^L)
//   - m, n: dimensions of the board
//   - L: length of the word
//   - At each cell, you may explore up to 4 directions, up to L characters deep

// Space Complexity: O(m * n)

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean vis[][] = new boolean[m][n]; // tracks visited cells during current search

        // Try to start from every cell that matches the first character
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // Start DFS from (i, j) for the word
                    if (dfs(board, word, i, j, 0, vis)) {
                        return true;   
                    }
                }
            } 
        }
        
        return false; // No path found
    }
    
    public boolean dfs(char[][] board, String word, int r, int c, int k, boolean vis[][]){
        // Out of bounds, visited, mismatch, or word too long
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || vis[r][c] || k >= word.length() || board[r][c] != word.charAt(k)) {
            return false;
        }
        
        // All characters matched
        if (k + 1 == word.length()) {
            return true;
        }
        
        vis[r][c] = true; // Mark as visited

        // Explore all 4 directions
        if (dfs(board, word, r , c + 1, k + 1, vis) 
            || dfs(board, word, r + 1, c , k + 1, vis) 
            || dfs(board, word, r - 1, c , k + 1, vis)
            || dfs(board, word, r , c - 1, k + 1, vis)
        ) {
            return true;
        }
        
        vis[r][c] = false; // Backtrack: unmark visited for this path
        return false;
    }
}
