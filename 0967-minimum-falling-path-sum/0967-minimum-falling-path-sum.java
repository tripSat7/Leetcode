class Solution {
    public int minFallingPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        if(n == 1){
            return grid[0][0];
        }
        int prev[]= new int[n];
        for(int i = 0; i < n; i++){
            prev[i] = grid[0][i];
        }
        for(int i = 1; i < m; i++){
            int temp[] = new int[n];
            for(int j = 0; j < n; j++){
                if(j == 0){
                    temp[j] = grid[i][j] + Math.min(prev[j], prev[j+1]);
                }
                else if(j == n - 1){
                    temp[j] = grid[i][j] + Math.min(prev[j], prev[j-1]);
                }
                else{
                    temp[j] = grid[i][j] + Math.min(prev[j] , Math.min(prev[j+1], prev[j-1]));
                }
            }

            prev = temp;
        }

        int res = Integer.MAX_VALUE;    
        for(int i = 0; i < n; i++){
            res = Math.min(res, prev[i]);
        }

        return res;
    }
}