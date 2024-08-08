class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < times.length; i++){
            adj.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }
        
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, k});
        
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int src = curr[1];
            int t = curr[0];
            
            for(int[] nodes : adj.get(src)){
                int dest = nodes[0];
                int time = nodes[1];
                
                if(time + t < dist[dest]){
                    dist[dest] = time + t;
                    pq.add(new int[]{dist[dest], dest});
                }
            }
        }
        
        int min = 0;
        
        for(int i = 1; i <=n; i++){
            
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            
            min = Math.max(min, dist[i]);
        }
        
        
        return min;
    }
}