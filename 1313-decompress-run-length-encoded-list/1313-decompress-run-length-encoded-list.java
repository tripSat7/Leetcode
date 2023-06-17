class Solution {
    public int[] decompressRLElist(int[] nums) {
        int arrLen=0;
        for(int i=0;i<nums.length;i=i+2){
            if(i%2==0){
                arrLen+=nums[i];
            }
        }
        int res[] = new int[arrLen];
        int x=0;
        for (int i=0;i<nums.length;i+=2) {
            Arrays.fill(res, x, x+nums[i], nums[i+1]);
            x += nums[i];
        }
        
        return res;
    }
}