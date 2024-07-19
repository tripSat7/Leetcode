class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = nums[0];
        int maxEnd = nums[0];
        int minSum = nums[0];
        int minEnd = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            maxEnd = Math.max(maxEnd + nums[i], nums[i]);
            minEnd = Math.min(minEnd + nums[i], nums[i]);
        
            maxSum = Math.max(maxEnd, maxSum);
            minSum = Math.min(minEnd, minSum);
        }
        
        return Math.max(maxSum, Math.abs(minSum));
    }
}