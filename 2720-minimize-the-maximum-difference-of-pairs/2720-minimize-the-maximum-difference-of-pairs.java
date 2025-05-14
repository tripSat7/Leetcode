public class Solution {
    public int minimizeMax(int[] nums, int p) {
        if(p == 0){
            return 0;
        } 
        
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        int result = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(nums, mid, p)) {
                result = mid;
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    private boolean isValid(int[] nums, int threshold, int p) {
        int i = 0, count = 0;
        while (i < nums.length - 1) {
            if (Math.abs(nums[i] - nums[i + 1]) <= threshold) {
                count++;
                i += 2;
            } else {
                i++;
            }
            
        }

        return count >= p;
    }
}