class Pair{
    int first, second, third;
    
    Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> q = new PriorityQueue<>((p1, p2) -> p1.first - p2.first);
        int m = heights.length;
        int n = heights[0].length;
        int dist[][] = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        q.add(new Pair(0,0,0));
        
        int X[] = {0,1,0,-1};
        int Y[] = {-1,0,1,0};
        dist[0][0] = 0;
        
        while(!q.isEmpty()){
            Pair p = q.peek();
            int ef = p.first;
            int row = p.second;
            int col = p.third;
            q.remove();
            // System.out.println(row+"||"+col+"::"+dist[row][col]);
            for(int i = 0; i < 4; i++){
                int nr = row + X[i];
                int nc = col + Y[i];
                // System.out.println(nr+"||"+nc);
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && Math.max(Math.abs(heights[row][col] - heights[nr][nc]), ef) < dist[nr][nc]){
                    
                    dist[nr][nc] = Math.max(Math.abs(heights[row][col] - heights[nr][nc]), ef);
                    // System.out.println(nr+"|"+nc+"??"+dist[nr][nc]);
                    q.add(new Pair(dist[nr][nc],nr,nc));
                }
            }
        }
        
        
        
        return dist[m-1][n-1];
    }
}