class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i=0; i < pushed.length; i++) {
            while (i < pushed.length && pushed[i] != popped[popIndex]) {
                stack.push(pushed[i]);
                i++;
            }
            if (i < pushed.length && pushed[i] == popped[popIndex]) {
                popIndex++;
            }
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        
        if (popIndex == popped.length){
            return true;
        }else{
            return false;    
        }
            
        
    }
}