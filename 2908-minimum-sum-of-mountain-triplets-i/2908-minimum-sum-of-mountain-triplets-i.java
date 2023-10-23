class Solution {
    public int minimumSum(int[] nums) {
        
        int n = nums.length;
 
        int res = Integer.MAX_VALUE;
        
        for (int j = 1; j < n-1; j++) {
            int lm = Integer.MAX_VALUE;
            for(int k = j-1; k >= 0; k--){
                if(nums[k] < lm){
                    lm = nums[k];
                }        
            }
            
            int rm = Integer.MAX_VALUE;
            for(int k = j+1; k < n; k++){
                if(nums[k] < rm){
                    rm = nums[k];
                }        
            }          
                        
            if (nums[j] > lm && nums[j] > rm) {
                res = Math.min(res, lm + nums[j] + rm);
            }
        }

        if (res == Integer.MAX_VALUE) {
            return -1;
        } else {
            return res;
        }

    }
}