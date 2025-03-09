
class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(nums, nums.length - 1, nums.length, dp);
    }

    public int helper(int[] nums, int idx, int prev_idx, int dp[][]) {
        if (idx == -1) {
            return 0;
        }

        if (dp[idx][prev_idx] != -1) { 
            return dp[idx][prev_idx];
        }

        int notTake = helper(nums, idx - 1, prev_idx, dp);
        int take = 0;

        if (prev_idx == nums.length || nums[idx] < nums[prev_idx]) {
            take = 1 + helper(nums, idx - 1, idx, dp);
        }

        return dp[idx][prev_idx] = Math.max(notTake, take);  
    }
}
