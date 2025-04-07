public class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(0, -1, adj, hasApple);
    }

    private int dfs(int cur, int parent, List<List<Integer>> adj, List<Boolean> hasApple) {
        int time = 0;
        for(int child : adj.get(cur)) {
            if(child == parent){
                continue;
            } 
            int childTime = dfs(child, cur, adj, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                time += 2 + childTime;
            }
        }
        return time;
    }
}