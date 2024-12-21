class Solution {
    private boolean increasing(int[] nums){
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] > nums[i])
                return false;
        }
        return true;
    }
    private boolean decreasing(int[] nums){
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] < nums[i])
                return false;
        }
        return true;
    }
    public boolean isMonotonic(int[] nums) {
        if(nums[0] > nums[nums.length -1])
            return decreasing(nums);
        else
            return increasing(nums);

    }
}