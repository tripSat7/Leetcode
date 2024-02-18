class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int []ans = new int[nums.length];
        Arrays.fill(ans,-1);
        for(int i = 0 ; i < nums.length * 2; i++){
            while(!stk.empty() && nums[stk.peek()] < nums[i % nums.length]){
                ans[stk.pop()] = nums[i % nums.length];
            }
            if(i < nums.length) stk.add(i);
        }
        
        
        return ans;
    }
}