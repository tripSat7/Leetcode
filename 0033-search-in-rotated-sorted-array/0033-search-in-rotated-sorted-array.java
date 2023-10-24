class Solution {
    public int search(int[] nums, int target) {
        
        int idx = minIndex(nums);
        int left = 0, right = nums.length - 1;
        if(target == nums[idx]){
            return idx;
        }
        else if(target <= nums[right] && target > nums[idx]){
            left = idx + 1;
        }
        else{
            right = idx - 1;
        }
        while(left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        if(right > -1 && nums[right] == target){
            return right;
        }
        
        return -1;
    }
    
    public int minIndex(int nums[]){
        
        int n = nums.length;
        int left = 0, right = n-1;
        while(left < right){
            int mid = left+(right - left)/2;
            if(mid > 0 && nums[mid]<nums[mid-1]){
                return mid;
            }
            else if(nums[mid] >= nums[left] && nums[mid] > nums[right]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        
        return left;
    }
}