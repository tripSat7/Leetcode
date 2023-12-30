

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});  
                } 
                else if(grid[i][j] == 1){
                    fresh++;  
                } 
            }
        }
        int res = 0;
        int[][] search = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            res++;
            for(int i = 0; i < size; i++){
                int[] orange = q.poll();
                int rX = orange[0];
                int rY = orange[1];
                for(int[] adj : search){
                    int x = rX + adj[0];
                    int y = rY + adj[1];
                    if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        q.offer(new int[]{x,y});
                        fresh--;
                    }
                }
            }
        }
        return fresh == 0 ? res : -1;
    }  
}