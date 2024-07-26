class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        } 

        for(int[] pair : prerequisites){
            int prereq = pair[0];
            int course = pair[1];
            graph[prereq].add(course);
        }

        boolean[][] visited = new boolean[numCourses][numCourses];
        for(int node = 0; node < numCourses; node++){
            dfs(node, visited[node], graph);
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] querie : queries){
            int a = querie[0];
            int b = querie[1];
            res.add(visited[a][b]);
        }
        return res;
    }

    private void dfs(int node, boolean[] vis, List<Integer>[] graph){
        vis[node] = true;
        for(int child : graph[node]){
            if(vis[child]) 
            {
                continue;
            }
             dfs(child, vis, graph);
        }
    }
}