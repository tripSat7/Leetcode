public class Solution {
    public long gridGame(int[][] grid) {
        long res = Long.MAX_VALUE;
        long topSum = 0, bottomSum = 0;
        int n = grid[0].length;
        for(int i = 0; i < n; i++){
            topSum += grid[0][i];
        }

        for(int i = 0; i < n; i++){
            topSum -= grid[0][i];
            res = Math.min(res, Math.max(topSum, bottomSum));
            bottomSum += grid[1][i];
        }

        return res;
    }
}