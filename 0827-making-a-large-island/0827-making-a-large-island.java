class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int res = 0;
        boolean hasZero = false;

        Map<Integer, Integer> islandArea = new HashMap<>();
        int islandId = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid, islandId);
                    islandArea.put(islandId, area);
                    res = Math.max(res, area);
                    islandId++;
                }
            }
        }
        
        System.out.println(islandArea);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    Set<Integer> seenIslands = new HashSet<>();
                    int newArea = 1;
                    
                    if(i > 0 && grid[i-1][j] > 1){
                        seenIslands.add(grid[i-1][j]);
                    }
                    
                    if(j > 0 && grid[i][j-1] > 1){
                        seenIslands.add(grid[i][j-1]);  
                    }
                    
                    if(i < n-1 && grid[i+1][j] > 1){
                        seenIslands.add(grid[i+1][j]);  
                    }
                    
                    if (j < n-1 && grid[i][j+1] > 1){
                        seenIslands.add(grid[i][j+1]);  
                    } 
                    
                    for (int id : seenIslands) {
                        newArea += islandArea.get(id);
                    }

                    res = Math.max(res, newArea);
                }
            }
        }

        return hasZero ? res : n * n;
    }

    private int dfs(int r, int c, int[][] grid, int islandId) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid.length || grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = islandId;
        int area = 1;
        area += dfs(r + 1, c, grid, islandId);
        area += dfs(r - 1, c, grid, islandId);
        area += dfs(r, c + 1, grid, islandId);
        area += dfs(r, c - 1, grid, islandId);

        return area;
    }
}
