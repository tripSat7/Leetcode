class Solution {
    public long repairCars(int[] ranks, int cars) {
        int maxRank = IntStream.of(ranks).max().getAsInt();
        long low = 0, high = 1L * maxRank * cars * cars;
        while (low < high) {
            long time = low + (high - low) / 2;
            if (canFinish(ranks, cars, time)) {
                high = time;
            }
            else {
                low = time + 1;
            }
        }
        return low;
    }
    public boolean canFinish(int[] ranks, int cars, long time) {
        long finish = 0;
        for (int r : ranks) {
            finish += (int)Math.floor(Math.sqrt(time / r));
            if (finish >= cars) {
                return true;
            }
        }
        return false;
    }
}