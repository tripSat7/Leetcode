class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int even=nums.length-1, odd=0;
        while(even>odd){
            if(nums[odd]%2==1 && nums[even]%2==0){
                nums[odd]=nums[odd]+nums[even];
                nums[even]=nums[odd]-nums[even];
                nums[odd]=nums[odd]-nums[even];
            }
            if(nums[odd]%2!=1){
                odd++;
            }
            if(nums[even]%2!=0){
                even--;
            }
        }
        return nums;
    }
}