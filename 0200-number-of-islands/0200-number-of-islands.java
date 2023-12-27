class Pair{
    int first;
    int second;
    
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        int count = 0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void bfs(char[][] grid, int visited[][], int row, int col){
        visited[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        int n = grid.length;
        int m = grid[0].length;
        
        while(!q.isEmpty()){
            int qrow = q.peek().first;
            int qcol = q.peek().second;
            q.poll();
            
            for(int i = -1 ; i <= 1 ; i++){
                for(int j = -1 ; j <= 1 ; j++){
                    if(Math.abs(i) != Math.abs(j)){
                        int nrow = qrow + i;
                        int ncol = qcol + j;

                        if((nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m) && visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                            visited[nrow][ncol] = 1;
                            q.add(new Pair(nrow,ncol));
                        }
                    }
                }
            }
        }
    }
}