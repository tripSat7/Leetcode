class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i], max);
        }
        
        int maxlen = 0, cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == max){
                cnt++;
            }
            else{
                maxlen = Math.max(maxlen, cnt);
                cnt = 0;
            }
        }
        
        return Math.max(maxlen, cnt);
    }
}