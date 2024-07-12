class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Deque<Integer> stk = new ArrayDeque<>();
        int nge[] = new int[len];

        for(int i=2*len-1;i>=0;i--) {
            while(!stk.isEmpty() && stk.peek() <= nums[i%len]) {
                stk.pop();
            }
            if(i<len) {
                if(!stk.isEmpty()) {
                    nge[i] = stk.peek();
                } else {
                    nge[i] = -1;
                }
            }
            stk.push(nums[i%len]);
        }
        return nge;
    }
}