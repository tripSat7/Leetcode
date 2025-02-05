class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        if (Math.abs(target) > totalSum || (target + totalSum) % 2 != 0) {
            return 0;
        }
        
        int subsetSum = (target + totalSum) / 2;
        int prev[] = new int[subsetSum + 1];

        if (nums[0] == 0){
            prev[0] = 2;
        }
        else{
            prev[0] = 1;
        }

        if (nums[0] != 0 && nums[0] <= subsetSum){
            prev[nums[0]] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            int cur[] = new int[subsetSum + 1];
            for (int tar = 0; tar <= subsetSum; tar++) {
                int notTaken = prev[tar];

                int taken = 0;
                if (nums[i] <= tar)
                    taken = prev[tar - nums[i]];

                cur[tar] = (notTaken + taken);
            }
            prev = cur;
        }

        return prev[subsetSum];
    }
}
