class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int max = 1 ;
        int i;
        int c = 1;
        for(i = 1; i < n; i++)
        {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    c++;
                } else {
                    max = Math.max(max, c);
                    c = 1;
                }
            }
        }
        
        return Math.max(max,c);
    }
}