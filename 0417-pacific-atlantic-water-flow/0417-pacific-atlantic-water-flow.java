class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, n - 1, j);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] ocean, int row, int col) {

        if(ocean[row][col]){
            return;
        }
        int n = heights.length;
        int m = heights[0].length;
        ocean[row][col] = true;
        
        if(row + 1 < n && heights[row + 1][col] >= heights[row][col]){
            dfs(heights, ocean, row + 1, col);
        }

        if(row - 1 >= 0 && heights[row - 1][col] >= heights[row][col]){
            dfs(heights, ocean, row - 1, col);
        }

        if(col + 1 < m && heights[row][col + 1] >= heights[row][col]){
            dfs(heights, ocean, row, col + 1);
        }

        if(col - 1 >= 0 && heights[row][col - 1] >= heights[row][col]){
            dfs(heights, ocean, row, col - 1);
        }
    }
     
}