class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, nums.length - 1, 0);
    }

    public int helper(int[] nums, int target, int i, int sum){

        if(i == 0){
            if(target == sum && nums[0] == 0){
                return 2;
            }

            if(target == sum + nums[0] || target == sum - nums[0]){
                return 1;
            }

            return 0;
        }

        int notTake = helper(nums, target, i - 1, sum - nums[i]);
        int take = helper(nums, target, i - 1, sum + nums[i]);

        return take + notTake;
    }
}