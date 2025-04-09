class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.putIfAbsent(manager[i], new ArrayList<>());
            graph.get(manager[i]).add(i);
        }

        return helper(graph, informTime, headID);
    }

    public int helper(Map<Integer, List<Integer>> graph, int[] informTime, int manager){
        if(!graph.containsKey(manager)){
            return 0;
        }
        int time = 0;
        for(int temp : graph.get(manager)){
            time = Math.max(time, helper(graph, informTime, temp));
        }

        return time + informTime[manager];
    }
}