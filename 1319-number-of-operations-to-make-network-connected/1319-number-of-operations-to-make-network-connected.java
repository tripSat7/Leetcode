class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n-1){
            return -1;
        }
     
        
        List<Integer> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        } 
        
        for (int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }
        
        boolean visited[] = new boolean[n];
        int components = 0;
        for(int i = 0; i < n; i++){
            components += dfs(i, visited, graph);
        }
        
        return components - 1;
    }
    
    
    public int dfs(int node, boolean visited[], List<Integer> graph[]){
        if(visited[node]){
            return 0;
        }
        
        visited[node] = true;
        for(int dest : graph[node]){
            dfs(dest, visited, graph);
        }
        
        return 1;
    }
}