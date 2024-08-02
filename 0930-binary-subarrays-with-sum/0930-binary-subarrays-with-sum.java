class Solution {
    private int slidingWindowAtMost(int[] nums, int goal) {
        int st = 0, sum = 0, count = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum > goal && st <= end) {
                sum -= nums[st++];
            }

            count += end - st + 1;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
    }
}