// Time Complexity: O(n)
// Space complexity : O(1)
class Solution {
    public int jump(int[] nums) {
        int near = 0, far = 0, jumps = 0;

        // While the farthest reachable index is before the last index
        while (far < nums.length - 1) {
            int farthest = 0;

            // Explore all indices in the current jump range [near, far]
            for (int i = near; i <= far; i++) {
                // Track the farthest index we can reach from current range
                farthest = Math.max(farthest, i + nums[i]);
            }

            // Move to the next range of indices for the next jump
            near = far + 1;
            far = farthest;

            // Increment jump count
            jumps++;
        }

        return jumps;        
    }
}
