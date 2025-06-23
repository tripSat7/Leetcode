// Time Complexity: O(α(N)) per find/union, where α is the inverse Ackermann function (almost constant time for practical N)
// Space Complexity: O(N), where N is the number of nodes

class UnionFind {
    int[] parent;
    int[] rank; // Or use size, both are fine

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each node is its own parent initially
            rank[i] = 1;   // Initial rank/size is 1
        }
    }

    // Recursive find with full path compression
    public int find(int node) {
        if (node != parent[node]) {
            parent[node] = find(parent[node]); // Flatten the path directly to root
        }
        return parent[node];
    }

    // Union by rank (attach smaller tree to bigger)
    public boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) {
            return false; // Already connected
        }

        // Attach smaller rank tree under bigger...make sure rootU is always the bigger one
        if (rank[rootV] > rank[rootU]) {
            int temp = rootU;
            rootU = rootV;
            rootV = temp;
        }
        parent[rootV] = rootU;    // Merge sets
        rank[rootU] += rank[rootV]; // Update rank/size
        return true; // Union was successful
    }
}

// Example usage for connected components in a graph
public class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int components = n;
        for (int[] edge : edges) {
            // If union happened, decrease components count
            if (uf.union(edge[0], edge[1])) {
                components--;
            }
        }
        return components;
    }
}
