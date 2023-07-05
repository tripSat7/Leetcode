class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int arrSum=0;
        for(int i=0;i<n;i++){
            arrSum=arrSum+nums[i];
        }
        int totSum = n*(n+1)/2;
        return totSum-arrSum;
    }
}