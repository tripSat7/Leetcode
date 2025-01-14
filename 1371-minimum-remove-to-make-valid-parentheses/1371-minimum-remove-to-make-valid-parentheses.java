class Solution {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        boolean[] b = new boolean[s.length()];
        StringBuilder res = new StringBuilder("");
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            } 
            else if(s.charAt(i) == ')'){
                if(!st.isEmpty()){
                    b[i] = true;
                    b[(int) st.pop()] = true; 
                }
            }
            else{
                b[i] = true;
            }
        }               
        
        for(int i = 0; i < len; i++){
            if(b[i]){
                res.append(s.charAt(i));
            } 
        }   
        
        return res.toString();
    }
}