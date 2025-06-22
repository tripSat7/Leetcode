// Time Complexity: O(n) Each element is processed at most twice
// Space Complexity: O(1)

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean foundOne = false;

        // Mark unusable values and check if '1' exists
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                foundOne = true;  // Track if '1' is present
                nums[i] = -1;     // Temporarily mark as processed
            } 
            else if (nums[i] <= 0) {
                nums[i] = -1;     // Replace non-positive with -1
            }
        }
        // If '1' is missing, that's our answer
        if (!foundOne) return 1;

        int i = 0;
        // Mark indices corresponding to positive numbers found in array
        while (i < n) {
            int idx = nums[i] - 1; // Intended index for the value

            // Ignore already marked, out of bounds, or -1 values
            if (idx < 0 || idx >= n) {
                i++;
                continue;
            }
            if (nums[idx] == 0) {
                i++;
            } 
            else {
                int temp = nums[idx];
                nums[idx] = 0; // Mark that this number exists in array
                if (idx > i) { 
                    nums[i] = temp; // Bring new candidate forward to process at i
                }
                else {
                    i++; // No more processing at this position
                }
            }
        }

        // Find first index > 0 that's not marked zero — that's the answer
        for (i = 1; i < n; i++) {
            if (nums[i] != 0) {
                return i + 1; // Index + 1 is the missing positive
            }
        }

        // If all numbers 1 to n are present, return n + 1
        return n + 1;
    }
}
