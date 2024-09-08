class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long res = 0, max = 0;
        for (int a: nums) {
            res += max;
            max = Math.max(max, a);
        }
        return res;
    }
}