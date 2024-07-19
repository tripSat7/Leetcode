class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        int rowMin[] = new int[m];
        int colMax[] = new int[n];
        
        for(int i = 0; i < m; i++){
            int r = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++){
                r = Math.min(r, matrix[i][j]);
            }
            rowMin[i] = r;
        }
        
        for(int i = 0; i < n; i++){
            int c = Integer.MIN_VALUE;
            for(int j = 0; j < m; j++){
                c = Math.max(c, matrix[j][i]);
            }
            colMax[i] = c;
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]){
                    res.add(matrix[i][j]);
                }
            }
        }
                
        return res;
    }
}