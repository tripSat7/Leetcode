class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int prev=nums[0],j=0;
        int count[]=new int[n];
        count[0]=0;
        if(nums[0]==1)
            {
                count[j]++;
            }
        
        for(int i=1;i<nums.length;i++)
        {
            prev=nums[i-1];
            if(nums[i]==1)
            {
                count[j]++;
            }
            else
            {
                j++;
            }   
        }
        int max=count[0];
        for(int i=0;i<count.length;i++)
        {
            if(count[i]>max)
            {
                max=count[i];
            }
            
        }
        return max ;
    }
}