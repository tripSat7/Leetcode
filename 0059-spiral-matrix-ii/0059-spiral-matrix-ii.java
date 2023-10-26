class Solution {
    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        int left = 0, right = n, top = 0, bottom = n;
        int k = 1, row, col;
        while(k <= n*n){
            row = top; col = left;
            for(int i = col; i < right; i++){
                res[row][col] = k;
                k++;
                col++;
            }
            right--;
            col--;
            row++;
            
            for(int i = row; i < bottom; i++){
                res[row][col] = k;
                k++;
                row++;
            }
            bottom--;
            row--;
            col--;
            
            for(int i = col; i >= left; i--){
                res[row][col] = k;
                k++;
                col--;
            }
            left++;
            row--;
            col++;
            
            for(int i = bottom-1; i > top; i--){
                res[row][col] = k;
                k++;
                row--;
            }
            top++;
            col++;
            
        }
        
        return res;
    }
}