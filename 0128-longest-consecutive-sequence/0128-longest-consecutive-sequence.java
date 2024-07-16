class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        
        int res = 1;
        
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            
            if(!set.contains(n-1) && set.contains(n+1)){
                int len = 0;
                while(set.contains(n)){
                    len++;
                    n++;
                }
                res = Math.max(len, res);
            }
        }
        
        return res;
    }
}