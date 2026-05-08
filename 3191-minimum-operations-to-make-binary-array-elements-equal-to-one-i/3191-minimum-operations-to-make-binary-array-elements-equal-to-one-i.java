class Solution {
    public int minOperations(int[] nums) {
        int i = 0, j = 2;
        int count = 0;
        while(j < nums.length){
            if(nums[i] == 0){
                nums[i] = 1;
                nums[i+1] = nums[i+1] == 0 ? 1 : 0;
                nums[j] = nums[j] == 0? 1 : 0;
                
                count++;
            }
            j++;
            i++;
        }
        if(nums[i] != 1 || nums[i+1] != 1) return -1;
        return count;
    }
}