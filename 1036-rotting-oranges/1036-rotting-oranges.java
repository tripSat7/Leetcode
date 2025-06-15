// TC: O(N * M), where N = number of rows, M = number of columns

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int countFreshOrange = 0;

        // Initialize queue with all rotten oranges and count fresh ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
                if (grid[i][j] == 1) {
                    countFreshOrange++;
                }
            }
        }

        // No fresh oranges to rot
        if (countFreshOrange == 0){
            return 0;
        } 
        // No rotten oranges to spread rot
        if (q.isEmpty()){
            return -1;
        } 

        int minutes = -1;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; // 4 directions

        // BFS: each level = 1 minute
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cell = q.poll();
                int x = cell[0], y = cell[1];

                // Check 4 adjacent cells
                for (int[] dir : dirs) {
                    int i = x + dir[0];
                    int j = y + dir[1];

                    // If adjacent is fresh, rot it and add to queue
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        countFreshOrange--;
                        q.offer(new int[] {i, j});
                    }
                }
            }
            minutes++; // one minute passed
        }

        // If all fresh oranges are rotted
        return countFreshOrange == 0 ? minutes : -1;
    }
}
