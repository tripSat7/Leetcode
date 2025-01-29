class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum % 2 == 1){
            return false;
        }

        int dp[][] = new int[nums.length][sum/2 + 1];

        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(nums, nums.length - 1, sum/2, dp);
    }

    public boolean helper(int[] nums, int i, int target, int dp[][]){

        if (target == 0){
            return true;
        }

        if (i == 0){
            return nums[0] == target;
        }
            
        if (dp[i][target] != -1){
            return dp[i][target] == 0 ? false : true;
        }
            
        boolean notTaken = helper(nums, i - 1, target, dp);

        boolean taken = false;
        if (nums[i] <= target){
            taken = helper(nums, i - 1, target - nums[i], dp);
        }
    
        dp[i][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }
}