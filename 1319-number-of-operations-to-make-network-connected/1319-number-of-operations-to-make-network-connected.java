class DisjointSet {
    int parent[];
    int size[];

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void unionBySize(int u, int v) {
        int u_parent = find(u);
        int v_parent = find(v);

        if (u_parent == v_parent) {
            return;
        }

        if (size[u_parent] < size[v_parent]) {
            parent[u_parent] = v_parent;
            size[v_parent] += size[u_parent];
        } else {
            parent[v_parent] = u_parent;
            size[u_parent] += size[v_parent];
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0;
        int m = connections.length;
        for (int i = 0; i < m; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            if (ds.find(u) == ds.find(v)) {
                cntExtras++;
            } else {
                ds.unionBySize(u, v);
            }
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i) {
                components++;
            }
        }

        int res = components - 1;
        if (cntExtras >= res) {
            return res;
        }

        return -1;
    }
}
