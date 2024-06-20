class Solution {
    public int splitArray(int[] nums, int k) {
        int min = 0, max = 0;
        
        for(int i : nums){
            min = Math.max(min, i);
            max += i;
        }
        
        while(min <= max){
            int mid = (min+max)/2;
            
            if(checkSum(nums, k, mid)){
                min = mid + 1;
            }
            else{
                max = mid - 1;
            }
        }
        
        return min;
    }
    
    public boolean checkSum(int[] nums, int k, int mid){
        int req = 1, sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] > mid){
                req++;
                sum = nums[i];
            }
            else{
                sum += nums[i];
            }
        }
        
        return req > k;
    }
}