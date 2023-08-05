class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1){
            return nums[0]==target?0:-1;
        }
        int l = 0, h = nums.length-1, mid;
        while(l<=h){
            mid = l+(h-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                h = mid-1;
            }else{
                l = mid+1;
            }    
        }
        
        return -1;
    }
}