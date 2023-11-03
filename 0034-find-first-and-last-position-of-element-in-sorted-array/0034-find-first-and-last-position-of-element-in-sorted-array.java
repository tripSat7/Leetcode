class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        else if(nums.length == 1){
            if(nums[0] == target){
                return new int[]{0,0};
            }
        }
        else{
            int left = 0, right = nums.length-1;
            boolean flag = false;
            while(left <= right){
                int mid = left + (right-left)/2;
                if(nums[mid] >= target){
                    right = mid - 1;    
                }
                else{
                    left = mid + 1;
                }
                
                if(nums[mid] == target){
                    res[0] = mid;
                }
            }
            
            left = 0; right = nums.length-1;
            while(left <= right){
                int mid = left + (right-left)/2;
                if(nums[mid] <= target){
                    left = mid + 1;    
                }
                else{
                    right = mid - 1;
                }
                
                if(nums[mid] == target){
                    res[1] = mid;
                }
            }     
        }
        
        return res;
    }
}