// TC : O(n)
// SC : O(1)

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1){
            return nums[0];
        } 

        // prevMinusOne: max money robbed up to house i - 2
        // prev: max money robbed up to house i - 1
        int prevMinusOne = nums[0];
        int prev = Math.max(nums[0], nums[1]);

        // Iterate through the rest of the houses
        for (int i = 2; i < n; i++) {
            // Either rob current house + amount two steps back,
            // or skip current house and take the previous total
            int curr = Math.max(nums[i] + prevMinusOne, prev);

            // Update state for next iteration
            prevMinusOne = prev;
            prev = curr;
        }

        // 'prev' contains the maximum money that can be robbed
        return prev;
    }
}
