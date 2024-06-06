class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows;
        for(int i = 0; i < rows; i++){
            for(int j = i; j < cols; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i = 0; i < rows; i++){
            int j = 0, k = cols-1;
            while(j < k){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++; k--;
            }
        }
    }
}