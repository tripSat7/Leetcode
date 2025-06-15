// TC : O(n)
// SC : O(n)
class Solution {
    public int rob(int[] nums) {
        // If there's only one house, rob it
        if (nums.length == 1) {
            return nums[0];
        }

        // If there are two houses, rob the one with more money
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // Since the houses are in a circle, we can't rob both the first and the last
        // Case 1: exclude last
        int resultWithFirst = solve(nums, 0, nums.length - 2);
        // Case 2: exclude first
        int resultWithLast = solve(nums, 1, nums.length - 1);

        return Math.max(resultWithFirst, resultWithLast);
    }

    public int solve(int[] nums, int start, int end) {
        int[] money = new int[nums.length];

        money[start] = nums[start];
        money[start + 1] = Math.max(nums[start + 1], nums[start]);

        // DP relation: for each house, decide to rob it or skip
        for (int i = start + 2; i <= end; i++) {
            money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        }

        return money[end];
    }
}
