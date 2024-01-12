class Pair{
    int first;
    int second;
    
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        int arow[] = {-1,0,+1,0};
        int acol[] = {0,-1,0,+1};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    bfs(i, j, grid, vis, arow, acol);
                }
            }
        }
        
        return max;
    }
    
    public void bfs(int row, int col, int[][] grid, int vis[][], int arow[], int acol[]){
        vis[row][col] = 1;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        int count = 1;
        while(!q.isEmpty()){
            int qr = q.peek().first;
            int qc = q.peek().second;
            q.remove();
            
            for(int i = 0; i<4; i++){
                int nr = qr + arow[i];
                int nc = qc + acol[i];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == 0 && grid[nr][nc] == 1){
                    count++;
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
        
        if(count > max){
            max = count;
        }
        
    }
}