class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum  =0, max = Integer.MIN_VALUE;
    
        for(int i = 0; i < nums.length; i++)
        {
            sum = sum + nums[i];
            if(sum > max)
            {
                max = sum;
            }
            
            if(sum < 0)
            {
                sum = 0;
            }
        }
        
        sum = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++)
        {
            sum = sum + nums[i];
            if(sum < min)
            {
                min = sum;
            }
            
            if(sum > 0)
            {
                sum = 0;
            }
        }

        return Math.max(Math.abs(max),Math.abs(min));
    }
}