class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int normalmaxSum = normalMaximumSum(nums);
        if(normalmaxSum < 0){
            return normalmaxSum;
        }
        int arrSum = 0; 
        for(int i = 0; i < nums.length; i++){
            arrSum += nums[i];
            nums[i] = -nums[i];
        }
        
        int maxCircular = arrSum + normalMaximumSum(nums);
        return maxCircular > normalmaxSum ? maxCircular: normalmaxSum;
    }
    
    int normalMaximumSum(int[] nums){
        int res = nums[0], maxEnding = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            res = Math.max(maxEnding, res);
        }
        
        return res;
    }
}