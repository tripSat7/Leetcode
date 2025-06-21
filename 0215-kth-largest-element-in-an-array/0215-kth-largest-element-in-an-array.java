// Time complexity: O(n+m)
// Space complexity: O(m)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Find minimum and maximum values in the array
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }
        
        // Create and populate the counting array for all possible values
        int[] count = new int[maxValue - minValue + 1];
        for (int num : nums) {
            count[num - minValue]++;
        }
        
        // Iterate from the largest value towards the smallest
        int remain = k; // Number of elements left to skip to reach the k-th largest
        for (int num = count.length - 1; num >= 0; num--) {
            remain -= count[num];
            // When we've skipped k elements, return the current number
            if (remain <= 0) {
                return num + minValue;
            }
        }
        
        // This should not be reached for valid input
        return -1;
    }
}
