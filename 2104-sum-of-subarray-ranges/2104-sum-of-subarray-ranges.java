class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;
        
        for (int left = 0; left < n; ++left) {
            int min = nums[left], max = nums[left];
            for (int right = left; right < n; ++right) {
                min = Math.min(min, nums[right]);
                max = Math.max(max, nums[right]);
                res += max - min;
            }
        }
        return res;
    }
}