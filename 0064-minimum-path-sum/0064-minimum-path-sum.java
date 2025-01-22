class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int prev[] = new int[n];
        prev[0] = grid[0][0];
        for(int i = 1; i < n; i++){
            prev[i] = grid[0][i] + prev[i-1];
        }

        for(int i = 1; i < m; i++){
            int temp[] = new int[n];
            for(int j = 0; j < n; j++){
                if(j == 0){
                    temp[j] = grid[i][j] + prev[j];
                }
                else{
                    temp[j] = grid[i][j] + Math.min(prev[j], temp[j-1]);
                }
            }

            prev = temp;
        }

        return prev[n-1];
    }
}