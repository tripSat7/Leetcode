class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        int m = matrix.length, n = matrix[0].length;
        while(i<m && j>=0){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] < target){
                i++;
            }
            else{
                j--;
            }
        }
        
        return false;
    }
}