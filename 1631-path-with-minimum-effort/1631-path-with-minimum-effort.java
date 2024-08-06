class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        
        for(int i = 0; i < m; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0});
        
        int dr[] = {0,1,0,-1};
        int dc[] = {-1,0,1,0};
        
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int d = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(r == m-1 && c == n-1){
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && Math.max(Math.abs(heights[nr][nc] - heights[r][c]), d) < dist[nr][nc]){
                    dist[nr][nc] = Math.max(Math.abs(heights[nr][nc] - heights[r][c]), d);
                    
                    pq.add(new int[]{dist[nr][nc], nr, nc});
                }
            }
        }
        
        return dist[m-1][n-1];
    }
}