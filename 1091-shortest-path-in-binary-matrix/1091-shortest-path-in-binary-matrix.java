class Pair{
    int first, second, third;
    
    Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1 && grid[m-1][n-1] == 0){
            return 1;
        }
        if(grid[0][0] != 0 || grid[m-1][n-1] != 0){
            return -1;
        }
        
        Queue<Pair> q = new LinkedList<>();
        
        int dist[][] = new int[m][n];
                
        for(int i = 0; i < m; i++){
            // for(int j = 0; j < n; j++){
            //     dist[i][j] = (int)(1e9);
            // }
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        q.add(new Pair(1,0,0));
        
        int X[] = {0,1,1,1,0,-1,-1,-1};
        int Y[] = {-1,-1,0,1,1,1,0,-1};    
            
        while(!q.isEmpty()){
            Pair p = q.peek();
            int ew = p.first;
            int row = p.second, col = p.third;
            q.remove();
            // System.out.println(row+"||"+col+"::"+ew);
            for(int i = 0; i < 8; i++){
                int nr = row + X[i];
                int nc = col + Y[i];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 0 && ew + 1 < dist[nr][nc]){
                    dist[nr][nc] = ew + 1;
                    if(nr == m-1 && nc == n-1){
                        return ew + 1;
                    }
                    q.add(new Pair(ew + 1, nr, nc));
                }
            }
        } 
            
        return -1;
    }
}