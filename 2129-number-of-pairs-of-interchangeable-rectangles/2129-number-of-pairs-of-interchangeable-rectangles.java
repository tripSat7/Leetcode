public  class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> count = new HashMap<>();
        for (int[] rect : rectangles) {
            double ratio = (double) rect[0] / rect[1];
            count.put(ratio, count.getOrDefault(ratio, 0) + 1);
        }
        
        long res = 0;
        for (int c : count.values()) {
            if (c > 1) {
                res += (c * 1L * (c - 1)) / 2;
            }
        }
        return res;
    }
}