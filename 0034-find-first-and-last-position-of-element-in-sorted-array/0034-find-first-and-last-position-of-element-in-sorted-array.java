public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }

    private int findFirst(int[] nums, int target){
        int leftBound = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

            if(nums[mid] == target){
                leftBound = mid;
            } 
        }
        return leftBound;
    }

    private int findLast(int[] nums, int target){
        int rightBound = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

            if(nums[mid] == target){
                rightBound = mid;
            } 
        }
        return rightBound;
    }
}


//TC : O(logn)
//SC : O(1)