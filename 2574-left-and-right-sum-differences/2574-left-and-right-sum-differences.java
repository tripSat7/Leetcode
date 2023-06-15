class Solution {
    public int[] leftRightDifference(int[] nums) {
        int []res = new int[nums.length];
        if(nums.length==1){
            return res;
        }
        int rs=0,ls=0;
        for(int n:nums){
            rs+=n;
        }
        rs=rs-nums[0];
        res[0]=Math.abs(rs-ls);
        for(int i=1;i<nums.length;i++){
            ls=ls+nums[i-1];
            rs=rs-nums[i];
            res[i]= Math.abs(rs-ls);
        }
        return res;
    }
}