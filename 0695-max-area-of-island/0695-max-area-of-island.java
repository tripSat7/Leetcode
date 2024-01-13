class Solution {
    
    public int area(int r, int c, int[][] grid, boolean[][] seen) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
                seen[r][c] || grid[r][c] == 0)
            return 0;
        seen[r][c] = true;
        return (1 + area(r+1, c, grid, seen) + area(r-1, c, grid, seen)
                  + area(r, c-1, grid, seen) + area(r, c+1, grid, seen));
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c, grid, seen));
            }
        }
        return ans;
    }
}