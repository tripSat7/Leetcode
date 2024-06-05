class Solution {
    public void setZeroes(int[][] matrix) {
        
        int rows[] = new int[matrix.length];
        int cols[] = new int[matrix[0].length];
        
        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j < cols.length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        
        for(int i = 0; i < rows.length; i++){
            if(rows[i] == 1){
                for(int j = 0; j < cols.length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int i = 0; i < cols.length; i++){
            if(cols[i] == 1){
                for(int j = 0; j < rows.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}