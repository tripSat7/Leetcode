class Solution {
    public int maxProduct(int[] nums) {
        
        int max, currMax, currMin;
        max = currMin = currMax = nums[0];
        
        for (int i=1; i<nums.length; i++) {            
            if (nums[i] >= 0) {
                currMax = Math.max(nums[i] * currMax, nums[i]);
                currMin = Math.min(nums[i] * currMin, nums[i]);
            } 
            else {
                int tempMin = currMin;
                int tempMax = currMax;
                
                currMax = Math.max(tempMin * nums[i], nums[i]);
                currMin = Math.min(tempMax * nums[i], nums[i]);
            }
            max = Math.max(max, currMax);       
        }
        
        return max;
    }
}