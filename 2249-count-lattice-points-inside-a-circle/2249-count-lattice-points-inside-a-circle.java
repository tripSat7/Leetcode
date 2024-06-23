class Solution {
    public int countLatticePoints(int[][] circles) {
        int count = 0;
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (int[] circle : circles) {
            int x = circle[0], y = circle[1], r = circle[2];
            minX = Math.min(minX, x - r);
            maxX = Math.max(maxX, x + r);
            minY = Math.min(minY, y - r);
            maxY = Math.max(maxY, y + r);
        }
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int[] circle : circles) {
                    int cx = circle[0], cy = circle[1], r = circle[2];
                    if ((x - cx) * (x - cx) + (y - cy) * (y - cy) <= r * r) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}