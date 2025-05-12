class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int count = 0, max = 0, n = nums.length;
        for(int i = 0, j = 0; i < n; i++){
            
            if(nums[i] == 0){
                count++;
                while(j < n && count > k){
                    if(nums[j] == 0){
                        count--;
                    }
                    j++;
                }
            }
            System.out.println(i + "::" + j);
            max = Math.max(i - j + 1, max);
        }
        
        return max;
    }
}