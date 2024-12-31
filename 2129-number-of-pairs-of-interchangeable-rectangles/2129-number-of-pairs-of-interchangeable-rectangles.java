class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> freq = new HashMap<>();
        for (int[] r : rectangles) {
            double ratio = (double) r[0] / r[1];
            freq.put(ratio, freq.getOrDefault(ratio, 0l) + 1);
        }

        long count = 0;
        for (long n : freq.values()) {
            count += (n * (n - 1)) / 2; 
        }
        return count;
    }
}