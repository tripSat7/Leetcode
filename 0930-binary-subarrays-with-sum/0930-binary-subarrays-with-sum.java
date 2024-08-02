class Solution {
    private int window(int[] nums, int goal) {
        int n = nums.length;
        int sum = 0, l = 0, r = 0;
        int count = 0;
        while(r < n){
            sum += nums[r];
           while(sum > goal && l <= r){
            sum -= nums[l];
            l++;
           }
           count += (r - l + 1);
           r++;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return window(nums, goal) - window(nums, goal - 1);
    }
}