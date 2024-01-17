class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int vis[] = new int[graph.length];
        int pathVis[] = new int[graph.length];
        int check[] = new int[graph.length];
        
        for(int i = 0; i < graph.length; i++){
            if(vis[i] == 0){
                dfs(i, graph, vis, pathVis, check);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < graph.length; i++){
            if(check[i] == 1){
                res.add(i);
            }
        }
        
        return res;
    }
    
    
    public boolean dfs(int node, int[][] graph, int vis[], int pathVis[], int check[]){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        
        for(int it : graph[node]){
            if(vis[it] == 0){
                if(dfs(it, graph, vis, pathVis, check)){
                    return true;
                }
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }
        
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}