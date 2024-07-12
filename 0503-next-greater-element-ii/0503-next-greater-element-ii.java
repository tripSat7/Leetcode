class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int []ans = new int[nums.length];
        int n = nums.length;
        
        for(int i = n*2 - 1; i >= 0 ; i--){
            while(!stk.isEmpty() && stk.peek() <= nums[i % n]){
                stk.pop();
            }
            
            if(i < n){
                ans[i] = stk.isEmpty() ? -1 : stk.peek();
            } 
            
            stk.push(nums[i % n]);
        }
        
        return ans;
    }
}