class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    maxArea = java.lang.Math.max(maxArea, markVisited(i, j, m, n, grid));
                }
            }
        }
        return maxArea;
    }

    public int markVisited(int i, int j, int m, int n, int[][] grid) {
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return (1 +  markVisited(i + 1, j, m, n, grid) +  markVisited(i - 1, j, m, n, grid) +  markVisited(i, j + 1, m, n, grid) +  markVisited(i, j - 1, m, n, grid));
    }
}