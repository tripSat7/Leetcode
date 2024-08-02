class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                nums[i] = 0;
            }
            else{
                nums[i] = 1;
            }
        }
        
        return window(nums, k) - window(nums, k-1);
    }
    
    public int window(int nums[], int goal){
        
        int count = 0, sum = 0, left = 0, st = 0;
        
        for(int end = 0; end < nums.length; end++){
            sum += nums[end];
            
            while(sum > goal && end < nums.length){
                sum = sum - nums[st];
                st++;
            }
            
            count = count + (end - st + 1);
        }
        
        return count;
    }
}