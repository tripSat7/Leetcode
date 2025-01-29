class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum % 2 == 1){
            return false;
        }

        boolean prev[] = new boolean[sum/2 + 1];

        prev[0] = true;

        if (nums[0] <= sum/2) {
            prev[nums[0]] = true;
        }

        for(int i = 1; i < nums.length; i++){
            boolean temp[] = new boolean[sum/2 + 1];
            temp[0] = true;
            for(int target = 1; target <= sum/2; target++){
                boolean notTaken = prev[target];

                boolean taken = false;
                if(nums[i] <= target){
                    taken = prev[target - nums[i]];
                }

                temp[target] = taken || notTaken;
            }

            prev = temp;
        }


        return prev[sum/2];
    }

}