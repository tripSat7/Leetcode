class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        long[] preRow1 = new long[n];
        long[] preRow2 = new long[n];

        preRow1[0] = grid[0][0];
        preRow2[0] = grid[1][0];
        
        for (int i = 1; i < n; i++) {
            preRow1[i] = preRow1[i - 1] + grid[0][i];
            preRow2[i] = preRow2[i - 1] + grid[1][i];
        }

        long result = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long topPoints = preRow1[n - 1] - preRow1[i];
            long bottomPoints = (i > 0) ? preRow2[i - 1] : 0;

            long secondRobotPoints = Math.max(topPoints, bottomPoints);

            result = Math.min(result, secondRobotPoints);
        }

        return result;
    }
}
