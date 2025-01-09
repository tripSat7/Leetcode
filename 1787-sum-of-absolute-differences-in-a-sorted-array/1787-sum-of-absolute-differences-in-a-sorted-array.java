class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int suffix[] = new int[n];
        suffix[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--){
            suffix[i] = nums[i] + suffix[i+1]; 
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            count += nums[i];
            //System.out.println(suffix[i]);
            nums[i] = ((i+1) * nums[i] - count) + (suffix[i] - nums[i] * (n-i));
        }

        return nums;
    }
}