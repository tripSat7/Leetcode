class Solution {
    public int findTheCity(int e, int[][] edges, int distanceThreshold) {
        
        int m = e;
        int n = e;
        int dist[][] = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    dist[i][j] = 0;
                }
                else{
                    dist[i][j] = (int)(1e8); 
                }   
            }
        }
        
        for(int[] edge : edges){
            int r = edge[0];
            int c = edge[1];
            int wt = edge[2];
            
            dist[r][c] = wt;
            dist[c][r] = wt;
        }
        
        for(int via = 0; via < e; via++){
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
        
        int res = 0, countMin = Integer.MAX_VALUE, count;
        
        for(int i = 0; i < m; i++){
            count = 0;
            
            for(int j = 0; j < n; j++){
                if(dist[i][j] <= distanceThreshold){
                    count++;
                }  
            }
    
            if(count <= countMin){
                res = i;
                countMin = count;
            }      
        }
        
        return res;
    }
}