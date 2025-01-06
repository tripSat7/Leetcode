class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0, cons = 0;

        if(nums[0] == 0){
            cons++;
            res++;
        }

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == 0){
                if(nums[i-1] == 0){
                    res += cons+1;
                    cons++;
                }
                else{
                    res++;
                    cons = 1;
                }
            }
        } 

        return res;
    }
}