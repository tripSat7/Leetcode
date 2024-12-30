class Solution {
    public long countSubarrays(int[] nums, int k) {
        long answer = 0;
        int left = 0;

        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            max = Math.max(max, i);
        }

        int count = 0;
        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == max) {
                count++;
            }
            while (count >= k) {
                answer += nums.length - right;
                if (nums[left] == max) {
                    count--;
                }
                left++;
            }
        }
        return answer;
    }
}