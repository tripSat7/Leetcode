class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new int[]{roads[i][1], roads[i][2]});
            adj.get(roads[i][1]).add(new int[]{roads[i][0], roads[i][2]});
        }
        
        long[] dist = new long[n];
        int[] pathCount = new int[n];
        
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        pathCount[0] = 1;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int src = (int) curr[1];
            long t = curr[0];
            
            if (t > dist[src]) continue;
            
            for (int[] nodes : adj.get(src)){
                int dest = nodes[0];
                long dt = nodes[1];
                
                if (t + dt < dist[dest]){
                    dist[dest] = t + dt;
                    pathCount[dest] = pathCount[src];
                    pq.add(new long[]{dist[dest], dest});
                } else if (t + dt == dist[dest]){
                    pathCount[dest] = (pathCount[dest] + pathCount[src]) % mod;
                }
            }
        }
        
        return pathCount[n - 1];
    }
}
