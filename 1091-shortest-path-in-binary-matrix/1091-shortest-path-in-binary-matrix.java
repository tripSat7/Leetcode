class Solution {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && grid[0][0] == 0){
            return 1;
        }
        
        if(grid[0][0] != 0 || grid[m-1][n-1] != 0){
            return -1;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});
        
        int[][] dist = new int[m][n];
        
        for(int i = 0; i < m; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        
        int dr[] = {-1, 0, 1, 0, -1, 1, -1, 1};
        int dc[] = {0, 1, 0, -1, -1, 1, 1, -1};
        
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int r = curr[1];
            int c = curr[2];
            int d = curr[0];
            // System.out.println(r+"||"+c+"||"+d);
            
            for(int i = 0; i < 8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 0 && d + 1 < dist[nr][nc]){
                    dist[nr][nc] = d + 1;
                    if(nr == m-1 && nc == n-1){
                        return dist[nr][nc] + 1;
                    }
                    pq.offer(new int[]{dist[nr][nc], nr, nc});
                }
            }
        }
        
        return -1;
    }
}