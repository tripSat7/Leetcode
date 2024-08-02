class Solution {
    public int give(int[] nums, int goal){
        int n = nums.length;
        int sum = 0, l = 0, r = 0;
        int c = 0;
        while(r<n){
            sum += nums[r];
           while(sum>goal && l<=r){
            sum -= nums[l];
            l++;
           }
           c += (r - l + 1);
           r++;
        }
        return c;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return give(nums, goal) - give(nums, goal-1);
    }
}