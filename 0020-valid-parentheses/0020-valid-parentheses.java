class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        char []arr = s.toCharArray();
        for(char ch:arr){
            if(ch=='(' || ch=='[' || ch=='{'){
                stk.push(ch);
            }
            else if(!stk.empty()){
                char c = stk.pop();
                if(ch==')' && c!='('){
                    return false;
                }
                else if(ch==']' && c!='['){
                    return false;
                }
                else if(ch=='}' && c!='{'){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        
        return stk.empty();
    }
}