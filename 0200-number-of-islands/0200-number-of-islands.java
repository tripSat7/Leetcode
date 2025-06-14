class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Set<String> visited = new HashSet<>();

        int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int res = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){ 
                String st = i + "," + j;
                if(grid[i][j] == '1' && !visited.contains(st)){
                    res++;
                    bfs(i, j, grid, visited, directions);
                }
            }
        }

        return res;
    }

    public void bfs(int r, int c, char[][] grid, Set<String> visited, int directions[][]){
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited.add(r+ "," + c);

        while(!q.isEmpty()){
            int temp[] = q.poll();
            int row = temp[0], col = temp[1];

            for(int direction[] : directions){
                int nr = row + direction[0], nc = col + direction[1];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1' && !visited.contains(nr + "," + nc)){
                    visited.add(nr + "," + nc);
                    q.add(new int[]{nr, nc});
                }
            }
        }

    }
}