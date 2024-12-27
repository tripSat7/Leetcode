class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];

        for (int i = 0; i < n; i++) {
            freq[Math.min(n, nums[i])]++;
        }
        
        int x = 0;//prefixSum
        for (int i = n; i >= 1; i--) {
            x += freq[i];
            if (i == x) {
                return i;
            }
        }
        
        return -1;
    }
}