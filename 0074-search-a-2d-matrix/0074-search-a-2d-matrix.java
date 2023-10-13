class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int up = 0, down = rows-1;
        int left = 0, right = cols-1;
        
        while(up <= down){
            int mid = up + (down - up)/2;
            if(matrix[mid][0] == target){
                return true;
            }
            else if(matrix[mid][0] < target){
                up = mid+1;
            }
            else{
                down = mid-1;
            }
        }
        while(left <= right && down >= 0){
            
            int mid = left + (right - left)/2;
            if(matrix[down][mid] == target){
                return true;
            }
            else if(matrix[down][mid] < target){
                left = mid + 1;
                
            }
            else{
                right = mid-1;
            }
        }
        
        return false;
    }
}