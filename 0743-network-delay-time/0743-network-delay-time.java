class Pair{
    int first, second;
    
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        int m = times.length;
        for(int i = 0; i < n + 1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        
        int dist[] = new int[n+1];
        for(int i = 1; i < n+1; i++){
            dist[i] = (int)(1e9);
        }
        dist[k] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k,0));
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            int node = p.first;
            int ew = p.second;
            // System.out.println(node+"||"+ew);
            
            for(Pair itr : adj.get(node)){
                int time = ew + itr.second;
                int dest = itr.first;
                // System.out.println("to "+ dest +" : "+time);
                // System.out.println(dist[dest]);
                if(time < dist[dest]){
                    
                    dist[dest] = time;
                    q.add(new Pair(dest,time));
                }
            }
        }
        
        int res = 0;
        
        for(int i = 1; i < n + 1; i++){
            if(dist[i] == (1e9)){
                return -1;
            }
            // System.out.println(i+":"+dist[i]);
            if(dist[i] > res){
                res = dist[i];
            }
        }
        
        return res;
    }
}