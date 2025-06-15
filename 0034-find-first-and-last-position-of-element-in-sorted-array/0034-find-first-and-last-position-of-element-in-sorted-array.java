class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);   // find first (left) index
        int last = findBound(nums, target, false);   // find last (right) index
        return new int[] {first, last};
    }

    // Helper function to find boundary
    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid; // potential answer

                // Keep searching to the left (if finding first)
                if (isFirst) {
                    right = mid - 1;
                }
                // Keep searching to the right (if finding last)
                else {
                    left = mid + 1;
                }
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return bound;
    }
}
//TC : O(logn)
//SC : O(1)