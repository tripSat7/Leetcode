class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < flights.length; i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0, src, 0});
        
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int stops = curr[0];
            int s = curr[1];
            int price = curr[2];
            // System.out.println("--"+s+"||"+stops+"||"+price);
            for(int[] nodes : adj.get(s)){
                int ew = nodes[1];
                int d = nodes[0];
                // System.out.println(d+":"+ew);
                if(stops < k+1 && ew + price < dist[d]){
                    dist[d] = ew + price;
                    pq.add(new int[]{stops + 1, d, dist[d]});
                }
            }
        }
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}