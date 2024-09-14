class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, res = 0, streak = 0;

        for (int num : nums) {
            if (max < num) {
                max = num;
                res = streak = 0;
            }

            if (max == num) {
                streak++;
            } else {
                streak = 0;
            }

            res = Math.max(res, streak);
        }
        return res;
    }
}