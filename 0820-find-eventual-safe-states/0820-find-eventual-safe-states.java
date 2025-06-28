// Time Complexity: O(V + E) where V is number of nodes and E is number of edges
//   - Each node and edge is visited once in DFS
// Space Complexity: O(V) for the recursion stack and marking arrays

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];     // Marks if a node has been visited
        int[] pathVis = new int[n]; // Marks if a node is on the current DFS path
        int[] check = new int[n];   // Marks if a node is safe (1) or not safe (0)

        // Run DFS for every node
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, graph, vis, pathVis, check);
            }
        }

        List<Integer> res = new ArrayList<>();
        // Collect all safe nodes
        for (int i = 0; i < n; i++) {
            if (check[i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    // DFS to detect cycles and mark safe nodes
    public boolean dfs(int node, int[][] graph, int[] vis, int[] pathVis, int[] check) {
        vis[node] = 1;        // Mark node as visited
        pathVis[node] = 1;    // Mark node on current path
        check[node] = 0;      // Assume node is unsafe until proven otherwise

        // Traverse all neighbors
        for (int it : graph[node]) {
            if (vis[it] == 0) {
                // If a cycle is found in the subtree, propagate up
                if (dfs(it, graph, vis, pathVis, check)) {
                    return true;
                }
            } else if (pathVis[it] == 1) {
                // Found a cycle (back edge)
                return true;
            }
        }

        check[node] = 1;      // Mark as safe if no cycle found
        pathVis[node] = 0;    // Remove from current path (backtrack)
        return false;         // No cycle detected
    }
}
