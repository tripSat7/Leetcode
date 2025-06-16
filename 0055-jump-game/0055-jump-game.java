// TC: O(n)
// SC: O(1)

public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1; // Start from the last index

        // Traverse backwards to find if we can reach lastPos from earlier indices
        for (int i = nums.length - 1; i >= 0; i--) {
            // If the current position can reach or go beyond lastPos
            if (i + nums[i] >= lastPos) {
                lastPos = i; // Update lastPos to current index
            }
        }

        // If we’ve moved lastPos all the way back to 0, it’s reachable
        return lastPos == 0;
    }
}
