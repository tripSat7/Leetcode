class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1, max = Integer.MIN_VALUE;
        
        for(int i : nums){
            max = Math.max(i,max);
        }
        
        while(min < max){
            int mid = (min+max)/2;
            if(sum(nums, threshold, mid)){
                max = mid;
            }
            else{
                min = mid + 1;
            }
            
        }
        
        return max;
    }
    
    public boolean sum(int[] nums, int threshold, int mid){
        int res = 0;
        for(int i : nums){
           res += (i + mid - 1) / mid;
        }
        return res <= threshold;
    }
}