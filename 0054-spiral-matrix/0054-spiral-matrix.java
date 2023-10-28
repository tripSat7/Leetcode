class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List <Integer> res = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = cols-1, top = 0, bottom = rows-1;
        int tot = rows*cols;
        
        //System.out.println(right+"|"+bottom);
        
        while(tot > 0){
            for(int i = left; tot>0 && i <= right; i++){
                res.add(matrix[top][i]);
                tot--;
            }
            top++;
            
            for(int i = top;tot>0 && i <= bottom; i++){
                res.add(matrix[i][right]);
                tot--;
            }
            right--;
            
            for(int i = right;tot>0 && i >= left; i--){
                res.add(matrix[bottom][i]);
                tot--;
            }
            bottom--;
            
            for(int i = bottom;tot>0 && i >= top; i--){
                res.add(matrix[i][left]);
                tot--;
            }
            left++;
        }
        
        return res;
    }
}