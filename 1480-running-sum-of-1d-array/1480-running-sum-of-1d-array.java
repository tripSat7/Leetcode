class Solution {
    public int[] runningSum(int[] nums) {
        if(nums.length>=1 && nums.length<=1000){
            for(int i=1;i<nums.length;i++){
                    nums[i]=nums[i]+nums[i-1];
                }
            }
        return nums;
        }       
}