class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] lMin = new int[n];
        int[] rMin = new int[n];

        lMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            lMin[i] = Math.min(lMin[i - 1], nums[i-1]);
        }

        rMin[n - 1] = nums[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            rMin[i] = Math.min(rMin[i + 1], nums[i+1]);
        }
        
        int res = Integer.MAX_VALUE;

        for (int j = 1; j < n-1; j++) {
            if (nums[j] > lMin[j] && nums[j] > rMin[j]) {
                res = Math.min(res, lMin[j] + nums[j] + rMin[j]);
            }
        }

        if (res == Integer.MAX_VALUE) {
            return -1;
        } else {
            return res;
        }
    }
}