class Solution {
    public int search(int[] nums, int target) {
        int c=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                c=i;             
            }
        }
        return c;
    }
}