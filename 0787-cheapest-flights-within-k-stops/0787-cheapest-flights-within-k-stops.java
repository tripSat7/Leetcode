class Pair{
    int first, second;
    
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}


class Tuple{
    int first, second, third;
    
    Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0; i < m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        
        int dist[] = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = (int)(1e9);
        }
        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        // System.out.println(adj);
        dist[src] = 0;
        while(!q.isEmpty()){
            Tuple t = q.remove();
            int stops = t.first;
            int source = t.second;
            int price = t.third;
            
            if(stops > k){
                continue;
            }
            //System.out.println(source);
            
            for(Pair itr : adj.get(source)){
                int ew = price + itr.second;
                
                if(ew < dist[itr.first] && stops <= k){
                    // System.out.println(source+"||"+itr.first+"::"+ew);
                    dist[itr.first] = ew;
                    q.add(new Tuple(stops + 1, itr.first, ew));
                }
            }
        }
        
        return dist[dst] == (1e9) ? -1 : dist[dst];
    }
}