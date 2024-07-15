class Solution {
    public String removeKdigits(String num, int k) {
        
        int len = num.length();
        if(k == len){
            return "0";
        }        
            
        Deque<Character> stk = new ArrayDeque<>();
        int i = 0;
        while(i < num.length()){
            while(k > 0 && !stk.isEmpty() && stk.peek() > num.charAt(i)){
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
            i++;
        }
        
        // corner case : "1111"
        while(k > 0){
            stk.pop();
            k--;            
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        sb.reverse();
        
        //remove all the 0's from the front
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
            
        return sb.toString();
    }
}