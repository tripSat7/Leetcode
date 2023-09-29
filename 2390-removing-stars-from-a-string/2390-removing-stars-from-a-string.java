class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='*' && !stk.isEmpty()){
                stk.pop();
            }
            else{
                stk.push(ch);
            }
        }
        String res = "";
        while(!stk.isEmpty()){
            res = stk.pop() + res;
        }
        return res;
    }
}