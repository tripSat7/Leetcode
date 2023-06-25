class Solution {
    public int arraySign(int[] nums) {
        int neg=0;
        int res;
        for(int i:nums){
            if(i==0){
                return 0;
            }
            if(i<0){
                neg++;
            }  
        }
        res = neg%2==0?1:-1;
        return res;
    }
}