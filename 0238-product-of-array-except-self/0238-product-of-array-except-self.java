class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];
        int prefix=1, postfix=1;
        res[0]=1;
        for(int i=1;i<nums.length;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            postfix=postfix*nums[i+1];
            res[i] = postfix*res[i];
        }
        
        return res;
    }
}