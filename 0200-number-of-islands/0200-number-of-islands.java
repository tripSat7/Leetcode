class Solution {
    public int numIslands(char[][] grid) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int noOfIsnlands =0;

        for(int r=0; r< rowLength;r++){
            for(int c=0; c< columnLength;c++){
                if(grid[r][c] == '1'){
                    checkIsland(grid,r,c);
                    noOfIsnlands++;
                }
            }
        }
       return noOfIsnlands;
    }

    public void checkIsland(char[][] grid, int row, int column){
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        if( row < 0 || column <0 || row >= rowLength || column >= columnLength ||
            grid[row][column] == '0'){
                return;
            }
        
        grid[row][column]='0';
        checkIsland(grid, row+1, column);
        checkIsland(grid, row-1, column);
        checkIsland(grid, row, column-1);
        checkIsland(grid, row, column+1);
    }
}