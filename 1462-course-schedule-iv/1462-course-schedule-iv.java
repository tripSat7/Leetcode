class Solution {
    
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new HashSet<>());
        }
        
        for(int[] pre : prerequisites){
            graph.get(pre[0]).add(pre[1]);
        }
            
        List<Boolean> res = new ArrayList<>();
        Boolean[][] memo = new Boolean[numCourses][numCourses];
        for(int[] q : queries){
            res.add(query(graph, q[0], q[1], memo));
        }
        
        return res;
    }
    
    private boolean query(Map<Integer, Set<Integer>> graph, int from, int to, Boolean[][] memo) {
        if(from == to) return true;
        
        if(memo[from][to] != null)
            return memo[from][to];
        
        for(int next : graph.get(from)) {
            if(query(graph, next, to, memo)){
                return memo[from][to] = true;
            }
        }
        
        return memo[from][to] = false;
    }
}