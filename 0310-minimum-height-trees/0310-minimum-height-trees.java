class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                q.offer(i);
            }
        }

        while (n > 2) {
            int size = q.size();
            n = n - size;
            
            while (size-- > 0) {
                int leaf = q.poll();
                for (int neighbor : graph.get(leaf)) {
                    graph.get(neighbor).remove(leaf);
                    if (graph.get(neighbor).size() == 1) {
                        q.add(neighbor);
                    }
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        res.addAll(q);

        return res;
    }
}