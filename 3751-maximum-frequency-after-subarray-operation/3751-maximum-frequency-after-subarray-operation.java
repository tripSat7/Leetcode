// Approach: For every possible value in [1, 50], use a sliding window to find the max segment you can create by flipping k's to that value. 
// Answer is the largest such segment for any value, plus all elements already equal to k.
// Time Complexity: O(N * R) | Space Complexity: O(1), where N = nums.length, R = 50

class Solution {
    public int maxFrequency(int[] nums, int k) {
        int cnt = 0;
        // Count how many elements are already equal to k
        for (int num : nums) {
            if (num == k) {
                cnt++;
            }
        }

        int res = cnt;
        // For every possible value from 1 to 50 (except k)
        for (int i = 1; i <= 50; i++) {
            if (i == k){
                continue;
            } 
            int max = 0, s = 0;
            // Sliding window: track max group that can be created by flipping k's to i
            for (int num : nums) {
                if (num == i){
                    s++;
                } 
                else if(num == k){
                    s--;
                } 
                if (s < 0){
                    s = 0;
                } 
                max = Math.max(max, s);
            }
            res = Math.max(res, max + cnt);
        }
        return res;
    }
}
