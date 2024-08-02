class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return window(nums, k) - window(nums, k-1);
    }

    private int window(int[] nums, int k) {
        int st = 0, end = 0, sum = 0, count = 0;
        
        while (end < nums.length) {
            sum += (nums[end] & 1);
            while (sum > k) {
                sum -= nums[st] & 1;
                st++;
            }
            count += (end - st + 1);
            end++;
        }
        
        return count;
    }
}