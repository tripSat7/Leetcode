class Solution {
    private int totalSum;
    private int[][] memo;

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        int n = nums.length;
        memo = new int[n][2 * totalSum + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(nums, target, nums.length - 1, 0);
    }

    private int helper(int[] nums, int target, int i, int sum) {
        if(i == 0) {
            if(sum == target && nums[0] == 0) {
                return 2;
            }
            if(sum + nums[0] == target || sum - nums[0] == target) {
                return 1;
            }
            return 0;
        }

        int shiftedSum = sum + totalSum;
        if (memo[i][shiftedSum] != -1) {
            return memo[i][shiftedSum];
        }

        int subtract = helper(nums, target, i - 1, sum - nums[i]);
        int add = helper(nums, target, i - 1, sum + nums[i]);

        memo[i][shiftedSum] = subtract + add;
        return memo[i][shiftedSum];
    }
}