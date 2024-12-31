public  class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> count = new HashMap<>();
        long res = 0;
        for (int[] rect : rectangles) {
            double ratio = (double) rect[0] / rect[1];
            res += count.getOrDefault(ratio, 0);
            count.put(ratio, count.getOrDefault(ratio, 0) + 1);
        }
        return res;
    }
}