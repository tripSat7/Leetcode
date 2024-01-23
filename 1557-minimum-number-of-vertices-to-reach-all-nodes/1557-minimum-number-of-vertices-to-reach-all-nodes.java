class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList();
        boolean[] incomingEdge = new boolean[n];
        for (List<Integer> edge : edges) {
            int to = edge.get(1);
            incomingEdge[to] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!incomingEdge[i]) {
                result.add(i);
            }
        }
        return result;
    }
}