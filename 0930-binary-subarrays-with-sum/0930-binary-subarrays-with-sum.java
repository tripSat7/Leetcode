class Solution {
    private int slidingWindowAtMost(int[] nums, int goal) {
        int n = nums.length;
        int sum = 0, l = 0, r = 0;
        int count = 0;
        while(r < n){
            sum += nums[r];
           while(l <= r && sum > goal){
            sum -= nums[l];
            l++;
           }
           count += (r - l + 1);
           r++;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
    }
}