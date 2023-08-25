class Solution {
    public int minAddToMakeValid(String s) {
            
        Stack<Character> stk = new Stack<Character>();
        char ch[] = s.toCharArray();
        int i = 0, res = 0;
        while(i<ch.length){
            if(ch[i]=='('){
                stk.push(ch[i]);
            }else{
                if(stk.isEmpty()){
                    res++;
                }else{
                    stk.pop();    
                }
            }
            i++;
        }
        
        return res+stk.size();
    }
}