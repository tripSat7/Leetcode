class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1, max = Integer.MIN_VALUE;
        
        for(int i : nums){
            max = Math.max(i,max);
        }
        
        while(min < max){
            int mid = (min+max)/2;
            boolean flag = sum(nums, threshold, mid);
            //System.out.println(mid+"::"+flag);
            if(flag){
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
            if(i%mid != 0){
                res = res + (i/mid) + 1;
            }
            else{
                res = res + (i/mid);
            }
        }
        //System.out.println(res);
        return res <= threshold;
    }
}