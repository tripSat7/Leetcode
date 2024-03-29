class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int j = 0;
        for(int i: pushed){
            stk.push(i);
            while((j<popped.length && !stk.isEmpty()) && stk.peek() == popped[j]){
                stk.pop();
                j++;
            }
        }
        
        if(!stk.isEmpty()){
            return false;
        }
        
        return true;
    }
}