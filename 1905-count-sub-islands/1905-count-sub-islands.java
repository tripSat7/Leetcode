class Solution {
    boolean check = true; 
    int count = 0;
    private void method(int [][] grid1,int[][] grid2,int i,int j){
        grid2[i][j] = 0;
        if(grid1[i][j] != 1) {
            check = false;
        }
        
        if(i < grid2.length - 1 && grid2[i+1][j] == 1){
            method(grid1, grid2, i+1, j);
        }
        
        if(j < grid2[i].length - 1 && grid2[i][j+1] == 1){
            method(grid1,grid2,i,j+1);
        }
        
        if(i > 0 && grid2[i-1][j] == 1){
            method(grid1,grid2,i-1,j);
        }
        
        if(j > 0 && grid2[i][j-1] == 1){
            method(grid1, grid2, i, j-1);
        }
    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2){
        for(int i = 0; i < grid2.length; i++){
            for(int j = 0;j < grid2[i].length; j++){
                if(grid2[i][j] == 1){
                    method(grid1, grid2, i, j);
                    if(check == true){
                        count++;  
                    } 
                    else {
                        check=true;
                    }
                }
                
            }
        }
        return count;
    }
}