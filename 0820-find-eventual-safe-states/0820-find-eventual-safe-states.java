// Time Complexity: O(V + E), where V = number of nodes, E = number of edges
// Space Complexity: O(V + E) for reversed adjacency list, queue, and marking arrays

// Approach - From terminal nodes you can find out the safe nodes, so by reversing the edges of the graph and then applying a topological sort, you get all the safe nodes. 

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];        // Outdegree in the original graph
        List<List<Integer>> adj = new ArrayList<>(); // Reversed graph

        // Initialize adjacency list for reversed graph
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build reversed graph and count reversed indegrees
        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adj.get(node).add(i); // Reverse the edge direction
                indegree[i]++;        // Count indegree in the reversed graph
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // All terminal nodes are initially safe
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        System.out.println(adj);
        System.out.println(q);
        boolean[] safe = new boolean[n]; // Marks whether each node is safe

        
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true; // Mark node as safe

            // For each predecessor in reversed graph
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--; // Remove the edge to the now-safe node
                if (indegree[neighbor] == 0) {
                    q.add(neighbor); // This node is now also safe
                }
            }
        }

        // Collect all nodes determined to be safe
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}
