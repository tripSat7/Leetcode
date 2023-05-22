class Solution {
    public int[] applyOperations(int[] nums) {
        int slow=0, fast=slow+1;
        while(fast<nums.length){
            if(nums[slow] == nums[fast]){
                nums[slow] = nums[slow]*2;
                nums[fast] =0;
            }
            fast++;slow++;
        }
        slow=0;fast=1;
        while(fast<nums.length){
            if(nums[slow]==0 && nums[fast]!=0){
                nums[slow]=nums[fast]+nums[slow];
                nums[fast]=nums[slow]-nums[fast];
                nums[slow]=nums[slow]-nums[fast];
            }
            if(nums[slow]!=0){
                slow++; 
            }
            fast++;
        }
        return nums;
    }
}