class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }    
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }    
        
        int resultWithFirst = solve(nums, 0, nums.length - 2);
        int resultWithLast = solve(nums, 1, nums.length - 1);
        
        return Math.max(resultWithFirst, resultWithLast);
    }
    
    public int solve(int[] nums, int start, int end){          
        int money[] = new int[nums.length];
        
        money[start] = nums[start];
        money[start + 1] = Math.max(nums[start + 1], nums[start]);
        
        for (int i = start + 2; i <= end; i++){
            money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        }
        
        return money[end];
    }
}