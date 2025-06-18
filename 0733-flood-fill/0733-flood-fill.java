// Time Complexity: O(N * M), where N = rows, M = cols
// Space Complexity: O(N * M) for the queue in the worst case

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        // No work if the color is already the target
        if (originalColor == newColor){
            return image;
        } 

        int rows = image.length, cols = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;

        // Directions: up, down, left, right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            // Visit all 4 neighbors
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                // If in-bounds and matches the original color, fill and enqueue
                if ((nr >= 0 && nr < rows) && (nc >= 0 && nc < cols) && image[nr][nc] == originalColor) {
                    image[nr][nc] = newColor;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return image;
    }
}
